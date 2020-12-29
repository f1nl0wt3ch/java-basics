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
	                <li><a class="w3-light-green" href="admin/joblist">Jobs control</a></li>
					<li><a class="w3-light-gray" href="admin/employeelist">Employees control</a></li>
					<li><a class="w3-light-gray" href="#">Partners control</a></li>
					<li><a class="w3-light-gray" href="admin/newpost">News control</a></li>
					<li><a class="w3-light-gray" href="admin/email">Send Email</a></li>
	    </ul>
		<!-- begin -->
		<div class="col-sm-9">
		
		<h1><spring:message code="kaikki.tyopaikka"></spring:message></h1>
    <hr>
				<table>
					<form:form class="form-inline" modelAttribute="duuni" method="POST">
						<tr>
							<td><form:select class="form-control" path="paikka">
							
									<form:option value="select job's place"></form:option>
									<form:option value="Kaikki"></form:option>
									<form:options items="${listPaikka }" />
								</form:select></td>
							<td><form:select class="form-control" path="nimi">
									<form:option value="select job's tilte"></form:option>
									<form:option value="Kaikki"></form:option>
									<form:options items="${listNimi }" />
								</form:select></td>
								<spring:message code="button.search" var="search"/>
							<td><input type="submit" name="submit" value="${search }"></td>
						</tr>

					</form:form>
				</table>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Julkaistupäivä</th>
							<th>Nimi</th>
							<th>Eräpäivä</th>
							<th>Paikka</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listDuuni}" var="duunit">
							<tr>
								<td><p>
										<c:out value="${duunit.id }" />
									</p></td>
																	<td><p>
										<fmt:formatDate type="Date" value="${duunit.julkaistupv }" />
									</p></td>
								<td><p>
										<c:out value="${duunit.nimi }" />
									</p></td>
								<td><p>
										<fmt:formatDate type="Date" value="${duunit.erapv }" />
									</p></td>
								<td><p>
										<c:out value="${duunit.paikka }" />
									</p></td>
								<form:form modelAttribute="duuni" action="jobaction" method="POST">
																	
									<input type="hidden" value="${duunit.id }" name="id" />
									<td><input type="submit" class="btn btn-info" name="submit" value="Lisätieto"/></td>
									<td><input type="submit" class="btn btn-success" name="submit" value="Muokkaa"/></td>
									<td><input type="submit" class="btn btn-primary" name="submit" value="Poista"/></td>
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