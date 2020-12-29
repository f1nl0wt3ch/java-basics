<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Students by EL</title>
</head>
<body>
	<%request.getAttribute("listStudent"); %>
	<h3>Student Information</h3>
	<table border="0" cellpadding="5" cellspacing="5" width="200">
		<tr>
			<td>Id</td>
			<td>${student.id }</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${student.name }</td>
		</tr>
		<tr>
			<td>DOB</td>
			<td>
				<fmt:formatDate var="dob" value="${student.dob }" pattern="MM/dd/yyyy" />
				${dob }
			</td>
		</tr>
		<tr>
			<td valign="top">Photo</td>
			<td><img src="images/${student.photo }" width="120" height="100"/></td>
		</tr>
	</table>
	
	<h3>List Students</h3>
	<table border="1" cellpadding="2" cellspacing="2" width="500">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>DOB</th>
			<th>Address</th>
			<th>Photo</th>
		</tr>
		<c:forEach var="student" items="${listStudent }">
			<tr>
				<td>${student.id }</td>
				<td>${student.name }</td>
				<td>
					<fmt:formatDate var="dob" value="${student.dob }" pattern="MM/dd/yyyy" />
					${dob }
				</td>
				<td>${student.address }</td>
				<td>
					<img src="images/${student.photo }" width="120" height="100"/>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>
