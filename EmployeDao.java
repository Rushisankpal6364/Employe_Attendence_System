package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class EmployeDao {

	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employe1","root","Rushikesh@123");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return con;
		
	}
	
	public static int InsertEmploye(Employe emp) {
		int status = 0;
		PreparedStatement ps;
		try {
			Connection con = getConnection();
			ps = con.prepareStatement("Insert into emp(name,password,email,phoneno) values(?,?,?,?)");
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getPassword());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getPhoneno());
			status = ps.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<Employe>getAllEmploye(){
		Connection con = getConnection();
		List<Employe>list = new ArrayList<Employe>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employe emp = new Employe();
				
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setPassword(rs.getString("password"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneno(rs.getNString("phoneno"));
				list.add(emp);
				
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public static int deleteData(int id) {
		int status = 0;
		PreparedStatement ps;
		try {
			Connection con = getConnection();
			ps = con.prepareStatement("Delete from emp where id = ?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public static Employe getEmploye (int id) {
		Connection con = getConnection();
		PreparedStatement ps;
		Employe emp = new Employe();
		
		try {
			ps = con.prepareStatement("select * from emp where id=?");
			ps.setInt(1, id);
			ResultSet rs =  ps.executeQuery();
			  
			if(rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setPassword(rs.getString("password"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneno(rs.getString("phoneno"));
				
			}	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
		
	}
	
	public static int UpdateEmploye(String name, String password, String email, String phoneno,int id) {
		
		PreparedStatement ps;
		int status = 0;
		 try {
			 Connection con = getConnection();
			 ps = con.prepareStatement("update emp set name =?, password=?, email =?, phoneno =? where id=?");
			
			 ps.setString(1, name);
			 ps.setString(2, password);
			 ps.setString(3, email);
			 ps.setString(4, phoneno);
			 ps.setInt(5, id);
			 status = ps.executeUpdate();
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return status;
	}
	

	public static List<sheet>getReport(){
		Connection con = getConnection();
		List<sheet>list = new ArrayList<sheet>();

		try {
			PreparedStatement ps = con.prepareStatement("select * from info,info2 where info.id=info2.userid");
			ResultSet rs = ps.executeQuery();
		
			
			while(rs.next()) {
				sheet sh = new sheet();
//				
//				emp.setId(rs.getInt("id"));
//				emp.setName(rs.getString("name"));
//				emp.setDate(rs.getString("Startdate"));
//				emp.setId(rs.getInt("id"));
//				emp.setName(rs.getString("name"));
//				emp.setDate(rs.getString("Enddate"));
//				emp.setId(rs.getInt("id"));
				
				sh.setId(rs.getInt("id"));
				sh.setEnddate(rs.getString("Enddate"));

				sh.setName(rs.getString("name"));
				sh.setStartdate(rs.getString("Startdate"));
				list.add(sh);
				
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public static List<Employe> getEmploye1(){
		Connection con = getConnection();
		List<Employe>list = new ArrayList<Employe>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from info");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employe emp = new Employe();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setDate(rs.getString("startdate"));
				list.add(emp);
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static sheet getEmploye2(int id) {
		
		Connection con = getConnection();
		//Employe emp = new Employe();
        sheet sh=new sheet();
	    PreparedStatement ps;
	    PreparedStatement ps2;
		try {
			ps= con.prepareStatement("select * from info where id =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			ps2= con.prepareStatement("select * from info2 where userid =?");
			ps2.setInt(1, id);
			ResultSet rs2 = ps2.executeQuery();
			
			if(rs.next() && rs2.next()) {
				System.out.println("enter");
				sh.setId(rs.getInt("id"));
				sh.setName(rs.getString("name"));
				sh.setStartdate(rs.getString("Startdate"));
				sh.setEnddate(rs2.getString("Enddate"));
				
			}
		}catch (SQLException p1) {
			// TODO Auto-generated catch block
			p1.printStackTrace();
	}
		return sh;
	}
	

}
		

