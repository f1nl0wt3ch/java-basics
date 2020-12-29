<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isThreadSafe="true"%>
<html>
<head>
<title>Ilmoitus</title>
</head>
<body>
<h2>Leffatietojen käsittely</h2>
<form action="PoistaServletti" method="get" >

<c:out value="${ilmoitus}" />
<p>
<input style="margin-top:15px;margin-bottom:15px;margin-right:25px;"type="submit" value="Leffalistaan" name="action"/>
</p>
</form>
</body>
</html>