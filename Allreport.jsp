<%@page import="Beans.Employe"%>
<%@page import="java.util.List"%>
<%@page import="Beans.EmployeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<%
List<Employe>list = EmployeDao.getEmploye1();
%>
<table class="table table-bordered table-hover">
    <tr>
    <th>id</th>
    <th>Name</th>
    <th>Start Time</th>
    <th>userid</th>
    
    
    
    </tr>
    
        <%for(Employe emp:list){ %>
		<tr>
			<td><%=emp.getId() %></td>
		    <td><%=emp.getName() %></td>
			<td><%=emp.getDate() %></td>
			<td><a href='Specificemploye.jsp?id=<%=emp.getId()%>'>Check</a></td>
			
		</tr>
	<%} %>
	
	 <tr>
            <td>
                <button type="submit" name="btn" value="back"><a href="Admin.html" >Logout</a></button>
            </td>
        </tr>

</body>
</html>