<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="<c:url value="resources/bootstrap-3.3.6/js/bootstrap.min.js" />"></script>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" />
<style>
.navbar-inverse {
      width: 1000px;
      margin: auto;
      height: 50px;
      border-radius:0;
}
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li><a href="news"><spring:message code="uutiset.template.sivu" /></a></li>
			    <li><a href="tyopaikat"><spring:message code="tyo.template.sivu" /></a></li>
				<li><a href="ehdokas"><spring:message code="tyontekija.template.sivu" /></a></li>
				<li><sec:authorize access="isAuthenticated()"><a href="lomake"><spring:message code="lomake.template.sivu" /></a></sec:authorize></li>
				<li><a href=""><spring:message code="partnerit.template.sivu" /></a></li>
				<li><a href="yhteys"><spring:message code="yhteystiedot.template.sivu" /></a></li>
				<li><a href="palaute"><spring:message code="palaute.template.sivu" /></a></li>
				

    </ul>
  </div>
</nav>
</body>
</html>