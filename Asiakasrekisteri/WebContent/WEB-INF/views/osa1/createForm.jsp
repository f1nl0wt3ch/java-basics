<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Asiakaslomake</title>
</head>	
<body>
	<h1>
		Luo asiakas
	</h1>
		<form:form modelAttribute="asiakas" action="talleta" method="get">
		  	<fieldset>		
				<legend>Asiakkaan tiedot</legend>
				<p>
				<c:if test="${etunimiPuuttuu==true}">
				<c:out value ="Anna myös asiakkaan etunimi"/>
				<br />
				</c:if>
					<form:label	path="etunimi">Etunimi</form:label><br/>
					<form:input path="etunimi" />			
				</p>
				<p>	
				<c:if test="${sukunimiPuuttuu==true}">
				<c:out value ="Anna myös asiakkaan sukunimi"/>
				<br />
				</c:if>
					<form:label path="sukunimi">Sukunimi</form:label><br/>
					<form:input path="sukunimi" />
				</p>
				<p>	
				<c:if test="${osoitePuuttuu==true}">
				<c:out value ="Anna myös asiakkaan osoite"/>
				<br />
				</c:if>
					<form:label path="osoite">Osoite</form:label><br/>
					<form:input path="osoite" />
				</p>
				<p>	
				<c:if test="${postinroPuuttuu==true}">
				<c:out value ="Anna myös postinumero ja postitoimipaikka"/>
				<br />
				</c:if>
					<form:label path="posti.postinro">Postinumero</form:label><br/>
					<form:input path="posti.postinro" />
					<form:label path="posti.postitmp">Postitoimipaikka</form:label><br/>
					<form:input path="posti.postitmp" />
				</p>
				<p>	
					<input type="submit" value="Luo asiakas"/>
				</p>
			</fieldset>
		</form:form>
</body>
</html>>