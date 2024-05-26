<%@page import="Beans.EmployeDao"%>
<%@page import="Beans.Employe"%>
<%@page import="java.util.List"%>
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
List<Employe>list = EmployeDao.getAllEmploye();
%>

<table class="table">
    <tr>
    <th>id</th>
    <th>Name</th>
    <th>Password</th>
    <th>Email</th>
    <th>Phoneno</th>
    <th>Delete Option</th>
    <th>Update Option</th>
    </tr>
    
    <%for(Employe emp:list){ %>
		<tr>
			<td><%=emp.getId() %></td>
		    <td><%=emp.getName() %></td>
			<td><%=emp.getPassword() %></td>
			<td><%=emp.getEmail() %></td>
			<td><%=emp.getPhoneno() %></td>
			<td><button><a href='Delete?id=<%=emp.getId()%>'>Delete</a></button></td>
		    <td><button><a href='Update.jsp?id=<%=emp.getId()%>'>Update</a></button></td>
		   
		</tr>
	<%} %>
</body>
</html>