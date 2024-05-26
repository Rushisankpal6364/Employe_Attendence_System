<%@page import="Beans.sheet"%>
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
List<sheet> list = EmployeDao.getReport();
%>

<table class="table table-bordered table-hover">
    <tr>
    <th>id</th>
    <th>Name</th>
    <th>start Time</th>
    <th>End Time </th>
    
    
    </tr>
    
        <%for(sheet sh:list){ %>
		<tr>
			<td><%=sh.getId() %></td>
		    <td><%=sh.getName() %></td>
			<td><%=sh.getStartdate() %></td>
			<td><%=sh.getEnddate() %>
	<%} %>
	
		</tr>
			<tr>
            <td>
                <button type="submit" name="btn" value="back"><a href="index.html" >LogOut</a></button>
            </td>
        </tr>
</body>
</html>