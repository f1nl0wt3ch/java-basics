<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isThreadSafe="true"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="leffa" scope="page" class="luokat.Leffa" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
input.margin
{
margin-top:15px;
margin-bottom:15px;
margin-right:25px;
}

</style>
<title>Leffatietojen lisäys</title>
</head>
<body>
<h2>Lisää leffan tiedot</h2>
<form action="LisaaServletti" method="get">
<table>
<tr><td>Nimi</td><td><input type="text" name="nimi" size="35" value="${nimi}"/></td></tr>
<tr><td>Ohjaaja</td><td><input type="text" name="ohjaaja" size="20" value="${ohjaaja}"/></td></tr>
<tr><td>Valmistumisvuosi</td><td><input type="text" name="valmistumisvuosi" size="4" value="${valmistumisvuosi}" /></td></tr>
</table>

<input class="margin" type="submit" value="Lisää leffa" name="action"/>
<input class="margin" type="submit" value="Leffalistaan" name="action" /><br />
</form>
</body>
</html>