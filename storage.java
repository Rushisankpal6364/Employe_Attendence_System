package Beans;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class storage
 */
@WebServlet("/storage")
public class storage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	String btn = request.getParameter("sub");
	
	HttpSession session = request.getSession(false);
	String name = (String)session.getAttribute("name");
	String startdate=request.getParameter("date");
	String enddate = request.getParameter("date");
	System.out.println("name ==>"+name);
	System.out.println("date ==>"+startdate);
	
	System.out.println(btn);
	System.out.println(1);
	if(btn.equals("SignIN")) {
		try {
			System.out.println(1);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employe1","root","Rushikesh@123");

			System.out.println(1);			
			Statement stmp = con.createStatement();
		    int status=stmp.executeUpdate("insert into info(name,startdate)values('"+name+"','"+startdate+"')");
		    System.out.print(status);

			System.out.println(1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	if(btn.equals("SignOUT")) {
		try {
		
			System.out.println(11);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employe1","root","Rushikesh@123");
			System.out.println(11);			
			Statement stmp = con.createStatement();
					
			ResultSet rs = stmp.executeQuery("select * from info where name='"+name+"'");
				
			if(rs.next()) {

				int status=stmp.executeUpdate("insert into info2(name,enddate,userid) values('"+name+"','"+enddate+"','"+rs.getInt("id")+"')");
					System.out.print(status);

			}
			
				System.out.println(11);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
	}
	
	
	
	
		
		
		
	
	


