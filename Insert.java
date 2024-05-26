package Beans;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    String action = request.getParameter("btn");
	   
	   
	    if (action.equals("insert")) {
	    	String name = request.getParameter("name");
	    	String password = request.getParameter("password");
	    	String email = request.getParameter("email");
	    	String phoneno = request.getParameter("phoneno");
	    	
	    		
	    	
	    	
	    	Employe emp = new Employe();
	    	emp.setName(name);
	    	emp.setPassword(password);
	    	emp.setEmail(email);
	    	emp.setPhoneno(phoneno);
	    	
	    	int status = EmployeDao.InsertEmploye(emp);
	    	
	    	if(status == 1) {
	    		System.out.println("<----Data Inserted---->");
	    		out.print("<script>alert('data inserted...');window.location='index.html' </script>");
	    	}else {
	    		System.out.println("<----Unable to insert Data---->");
	    	}
	    }
	    	 if(action.equals("login")) {
	 	       	response.sendRedirect("login.html");
	 	       }
	 
	}
	   
   

}
