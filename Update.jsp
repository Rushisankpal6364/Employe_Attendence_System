<%@page import="Beans.EmployeDao"%>
<%@page import="Beans.Employe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style = "display: flex; align-items: center;  justify-content: center;">
<style>
form{
    display: inline-block; 
    border: 5px solid black;
    padding: 50px;
    
}
 
table{
    border: 2px solid black;
    padding: 20px;
    background-color:grey;
}

</style>  
<%
int id = Integer.parseInt(request.getParameter("id"));
Employe emp = EmployeDao.getEmploye(id);
%>
<form action="Update" method="POST">

        <table>
        <tr>
            <td><label>Name :</label> </td>
            <td><input type="text" name="name" value="<%=emp.getName()%>"></td>
        </tr>
      
        <tr>
            <td>Password :</td>
            <td><input type="text" name="password" value="<%=emp.getPassword()%>"></td>   
        </tr>
        <tr>
            <td>Email :</td>
            <td><input type="text" name="email" value="<%=emp.getEmail()%>"></td>   
        </tr>
        <tr>
            <td>Phoneno :</td>
            <td><input type="text" name="phoneno" value="<%=emp.getPhoneno()%>"></td>   
        </tr>
      
        <tr>
            <td><input type="hidden" name="id" value="<%=emp.getId()%>"></td>   
        </tr>
        <tr>
            <td>
                <button type="submit" name="btn" value="insert">Update</button>
            </td>
        </tr>
        
    </table>
    </form>
</body>
</html>