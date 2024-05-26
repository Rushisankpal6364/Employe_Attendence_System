<%@page import="Beans.sheet"%>
<%@page import="Beans.Employe"%>
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
int id = Integer.parseInt(request.getParameter("id"));
sheet sh = EmployeDao.getEmploye2(id);

%>

        <table>
        <tr>
            <td><label>Name :</label> </td>
            <td><%=sh.getName()%></td>
        </tr>
        <tr>
            <td>Start Time :</td>
            <td><%=sh.getStartdate()%></td>   
        </tr>
        <tr>
            <td>End Time:</td>
            <td><%=sh.getEnddate()%></td>   
        </tr>
        </table>
        
        	
			<tr>
            <td>
                <button type="submit" name="btn" value="back"><a href="Allreport.jsp" >Back</a></button>
            </td>
        </tr>
        <tr>
            <td>
                <button type="submit" name="btn" value="back"><a href="Admin.html" >Logout</a></button>
            </td>
        </tr>
</body>
</html>