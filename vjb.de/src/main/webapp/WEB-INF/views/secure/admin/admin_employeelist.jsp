<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Jquery JS-->
<script src="https://code.jquery.com/jquery-1.12.2.min.js" integrity="sha256-Xxq2X+KtazgaGuA2cWR1v3jJsuMJUozyIXDB3e793L8="   crossorigin="anonymous"></script> 
<script src="<c:url value="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" />"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- datepicker -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<%@ include file="/WEB-INF/views/templates/navbar-logout.jsp"%>
<style>
/* Set black background color, white text and some padding */
.container-fluid {
	width: 1000px;
	margin: auto;
	
}

.panel-body {
	text-align: center;
}

.glyphicon {
	text-align: left;
}
</style>
<title><spring:message code="admin.page.home" /></title>
</head>

<body>
<div class="container-fluid">
	 <ul class="nav navbar-nav text-left">
	                <li><a class="w3-light-green" href="joblist">Jobs control</a></li>
					<li><a class="w3-light-gray" href="employeelist">Employees control</a></li>
					<li><a class="w3-light-gray" href="#">Partners control</a></li>
					<li><a class="w3-light-gray" href="newpost">News control</a></li>
					<li><a class="w3-light-gray" href="email">Send Email</a></li>
	    </ul>
		<!-- begin -->
		<div class="col-sm-9">
		
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
    <c:forEach var="ehdokas" items="${ehdokasList}">
      <tr>
        <td><c:out value="${ehdokas.suku} "></c:out></td>
        <td><c:out value="${ehdokas.etu} "></c:out></td>
        <td><c:out value="${ehdokas.sukupuoli} "></c:out></td>
        <td><c:out value="${ehdokas.kaupunki} "></c:out></td>
       
        <form:form action="employeeaction" method="post">
        <input type="hidden" name="id" value="${ehdokas.id }" />
        <spring:message code="button.edit" var="edit"/>
        <spring:message code="button.delete" var="delete"/>
        <td><input type="submit" name="submit" class="btn btn-info" value="${edit }" /></td>
        <td><input type="submit" name="submit" class="btn btn-info" value="${delete }" /></td>
        </form:form>
      </tr>
      </c:forEach>
    </tbody>
  </table>

		
		
		 <!-- end -->

      
	</div>
	</div>
<%@ include file="/WEB-INF/views/templates/footer-over.jsp"%>
<%@ include file="/WEB-INF/views/templates/footer-under.jsp"%>
</body>

</html>