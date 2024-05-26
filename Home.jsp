<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

<%
Date date=new Date();
%>	

function signin(){
    var http = new XMLHttpRequest();
	const mydate=new Date()
    const datebtn = document.getElementById("sub").value
    http.open("GET","storage?sub="+datebtn+"&date="+mydate+"");
    http.send();	
    http.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            // Enable the "Sign Out" buttons
            document.getElementById("sub").disabled = true;

            document.getElementById("sub1").disabled = false;
        }
    };

}


	
	function signout(){
	    var http = new XMLHttpRequest();
		const mydate=new Date()
	    const datebtn = document.getElementById("sub1").value
	    http.open("GET","storage?sub="+datebtn+"&date="+mydate+"");
	    http.send();	
	    http.onreadystatechange = function(){
	        if(this.readyState == 4 && this.status == 200){
	            // Enable the "Sign Out" buttons
	            document.getElementById("sub").disabled = false;

	            document.getElementById("sub1").disabled = true;
	        }
	    };

	}	





</script>
</head>
<body>
<h1>Welcome to Home Page</h1>

<form action="storage" method="get">
<h1>Start Time <%=date %></h1>
<input type="button" id="sub" value="SignIN"  onclick="signin()" />

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<h1>End Time <%=date %></h1>
<input type="button" id="sub1" value="SignOUT" disabled onclick="signout()" />
</form>

<button><a href = 'report.jsp'>Display</a></button>
</body>
</html>