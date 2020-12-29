<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<c:url value="resources/bootstrap-3.3.6/js/bootstrap.min.js" />"></script>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" />
<style>
.navbar-inverse {
   width: 1000px;
   margin: auto;
   height: 50px;
}
.dropdowm-menu li a {
   color: red;
}
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li class="dropdown">
       <a href="" class="dropdown-toggle" data-toggle="dropdown" ><span class="glyphicon glyphicon-home"></span><span class="caret"></span></a>
         <ul class="dropdown-menu" role="menu">
          <li><a href="news"><spring:message code="uutiset.template.sivu"></spring:message></a></li>
          <li><a href="tyopaikat"><spring:message code="kaikki.tyopaikka"></spring:message></a></li>
          <li><a href="ehdokas"><spring:message code="kaikki.ehdokas"></spring:message></a></li>
          <li><a href="lomake"><spring:message code="lomake.template.sivu"></spring:message></a></li>
          <li><a href="partneri"><spring:message code="partnerit.template.sivu"></spring:message></a></li>
          <li><a href="yhteystiedot"><spring:message code="yhteystiedot.template.sivu"></spring:message></a></li>
        </ul>

      </li>
    </ul>
    <ul class="nav navbar-nav navbar-center">
      <li><a href="<c:url value='logout' />"><span class="glyphicon glyphicon-log-out"></span> <spring:message code="logout.kayttaja"></spring:message></a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><sec:authorize access="isAuthenticated()"><a href="vjb.de/public">Tilinhallinta</a></sec:authorize></li>
      <li><a href="?lang=en">en</a></li>
				<li><a href="?lang=vn">vn</a></li>
				<li><a href="?lang=fi">fi</a></li>
			
    </ul>
  </div>
</nav>

</body>
</html>