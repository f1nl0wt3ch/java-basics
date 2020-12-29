<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/WEB-INF/views/templates/navbar-logout.jsp"%>
<%@ include file="/WEB-INF/views/templates/logo-banner.jsp"%>
<%@ include file="/WEB-INF/views/templates/menu-bootstrap.jsp"%>
<!-- Jquery JS-->
<script src="https://code.jquery.com/jquery-1.12.2.min.js" integrity="sha256-Xxq2X+KtazgaGuA2cWR1v3jJsuMJUozyIXDB3e793L8="   crossorigin="anonymous"></script> 
<script src="<c:url value="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" />"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- datepicker -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<style>
 /* Set black background color, white text and some padding */
    .container-fluid {
      width: 1000px;
      margin: auto;
    }
    .form-control{
         width: 30px;
    }
</style>
<title><spring:message code="employee.page.list" /></title>
</head>
<body>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    <div class="col-sm-8 text-left">
      <form:form class="form-inline" modelAttribute="ehdokas" method="POST">
		<form:select class="form-control" path="kaupunki">
		<form:option value="">select city</form:option>
		   <form:option value="Kaikki"></form:option>
			<form:options items="${kaupunkiList}"></form:options>
		</form:select>
		<spring:message code="button.search" var="search" />
		<input type="submit" name="submit" value="${search }" />
	   </form:form>
      <h3><spring:message code="kaikki.ehdokas"></spring:message></h3>
      <hr>
      <table class="table table-striped">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Gender</th>
        <th>City</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="ehdokas" items="${ehdokkaat}">
      <tr>
        <td><c:out value="${ehdokas.suku} "></c:out></td>
        <td><c:out value="${ehdokas.etu} "></c:out></td>
        <td><c:out value="${ehdokas.sukupuoli} "></c:out></td>
        <td><c:out value="${ehdokas.kaupunki} "></c:out></td>
       
        <form:form action="yksiehdokas" method="post">
        <input type="hidden" name="id" value="${ehdokas.id }" />
        <spring:message code="button.more" var="more"/>
        <td><input type="submit" name="submit" class="btn btn-info" value="${more }" /></td>
        </form:form>
      </tr>
      </c:forEach>
    </tbody>
  </table>

    </div>
    <div class="col-sm-2 sidenav">
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div>
  </div>
</div>
<%@ include file="/WEB-INF/views/templates/footer-over.jsp"%>
<%@ include file="/WEB-INF/views/templates/footer-under.jsp"%>
</body>
</html>