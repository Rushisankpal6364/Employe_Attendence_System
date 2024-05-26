package Beans;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
		int id = Integer.parseInt(request.getParameter("id"));
		int status = EmployeDao.deleteData(id);
		
		if(status == 1) {
			System.out.println("<------Data Deleted------>");
			response.sendRedirect("display.jsp");
		}else {
			System.out.println("<-----Unable to Delete Data------>");
		}
	}
	
	
	}


