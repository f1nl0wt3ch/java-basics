<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Asiakkaan tietojen näyttäminen</title>
</head>	
<body>
	<h1>
		Asiakkaan tietojen näyttäminen
	</h1>
	<p><b>Etunimi: </b><c:out value="${asiakas.etunimi}"/></p>
	<p><b>Sukunimi: </b><c:out value="${asiakas.sukunimi}"/></p>
	<p><b>Lahiosoite: </b><c:out value="${asiakas.osoite}"/></p>
	<p><b>postinumero: </b><c:out value="${asiakas.posti.postinro}"/>
	<b>postitoimipaikka: </b><c:out value="${asiakas.posti.postitmp}"/></p>
</body>
</html>