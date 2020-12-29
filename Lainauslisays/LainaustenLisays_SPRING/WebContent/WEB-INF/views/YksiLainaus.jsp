<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>LAINAUKSEN  näyttäminen</title>
</head>	
<body>
<h1> LAINAUS</h1>
<p>LAINAUSNUMERO: <c:out value="${lainaus.numero}"/>&nbsp;&nbsp;&nbsp;
<c:out value="${lainaus.lainausPvm}"/>
</p>
<div>
Lainaaja: <c:out value="${lainaus.lainaaja.numero}"/> 
<c:out value="${lainaus.lainaaja.etunimi}"/>&nbsp;
<c:out value="${lainaus.lainaaja.sukunimi}"/> <br />
<c:out  value="${lainaus.lainaaja.osoite}"/><br />
<c:out value="${lainaus.lainaaja.posti.postinro}"/>&nbsp;
<c:out value="${lainaus.lainaaja.posti.postitmp}"/>
</div>
<p> </p>
<table>
<tr>
<td>isbn</td>
<td>nidenro</td>
<td>nimi&nbsp&nbsp</td>
<td>&nbspkirjoittaja</td>
<td>painos</td>
<td>&nbspkustantaja</td>
<td>&nbsppalautuspvm </td>
</tr>

<c:forEach items="${lainaus.lista}" var="niteenlainaus">
	<tr>
 		<td><c:out value="${niteenlainaus.nide.kirja.isbn}"/>
		 </td>
 		<td>
 			&nbsp&nbsp&nbsp<c:out value="${niteenlainaus.nide.nidenro}"/>
 		</td>
 		<td><c:out value="${niteenlainaus.nide.kirja.nimi}"/>&nbsp
		 </td>
		 <td><c:out value="${niteenlainaus.nide.kirja.kirjoittaja}"/>
		 </td>
		 <td>&nbsp&nbsp&nbsp<c:out value="${niteenlainaus.nide.kirja.painos}"/>
		 </td>
		 <td><c:out value="${niteenlainaus.nide.kirja.kustantaja}"/>
		 </td>
 		<td>
 			<c:if test="${niteenlainaus.palautusPvm!=null}">
			 &nbsp<c:out value="${niteenlainaus.palautusPvm}"/>
			 </c:if>
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>