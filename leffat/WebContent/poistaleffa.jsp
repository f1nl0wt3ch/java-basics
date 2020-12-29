<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isThreadSafe="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leffan poisto</title>
</head>
<body>
<form action="PoistaServletti" method="get">
<h3>Anna poistettavan elokuvan nimi</h3>
<table>
<tr><td>Nimi</td><td><input type="text" name="nimi" size="35" value="${nimi}"/></td></tr>
</table>
<input style="margin-top:15px;margin-bottom:15px;margin-right:25px;"type="submit" value="Poista leffa" name="action"/>
<input style="margin-top:15px;margin-bottom:15px;margin-right:25px;" type="submit" value="Leffalistaan" name="action" /><br />
</form>
</body>
</html>