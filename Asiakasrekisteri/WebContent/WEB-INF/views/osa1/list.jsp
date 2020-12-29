<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<body>

	<p><b><a href="uusi"> <c:out value="Lisää uusi asiakas" /></a></b></p>
	

	<table style="background-color: rgb(240,240,240); padding: 10px; border-radius: 10px; -webkit-border-radius: 10px; -moz-border-radius: 15px; border-color: gray; border-style: solid; border-width: 1px">

		<c:forEach var="asiakas" items="${asiakaslista}">
			<tr>
				<td><a href="${asiakas.numero}">
					<c:out value="${asiakas.etunimi}"/> 
					<c:out value="${asiakas.sukunimi}"/> 
					</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>