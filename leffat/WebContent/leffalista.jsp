<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isThreadSafe="true"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="leffa" scope="session" class="luokat.Leffa" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="REFRESH" content="text/html; charset=ISO-8859-1" />
<style>
input.margin
{
margin-top:15px;
margin-bottom:15px;
margin-right:25px;
}
</style>
<title>Leffalista - jsp</title>
</head>
<body>
<form action="YllapitoServletti" method="get">
<h2>Leffat</h2>

<h3>Omat suosikkileffat</h3>

<h3>Omat suosikkileffani</h3>

<table>
<c:forEach items="${elokuvat}" var="leffa" >
 <tr>
 	<td><c:out value="${leffa.elokuvaId}" /></td>
  	<td><c:out value="${leffa.elokuvaNimi}" /></td>
  	<td><c:out value="${leffa.ohjaaja}" /></td> 
  	 <td><c:out value="${leffa.valmistumisvuosi}" /> </td>	
 </tr>
</c:forEach>
</table>
<form>
<p>
<input class="margin" type="submit" value="Lisää" name="action"/>
<input class="margin" type="submit" value="Päivitä" name="action" />
<input class="margin" type="submit" value="Poista" name="action" />
</p>
</form>

</body>
</html>