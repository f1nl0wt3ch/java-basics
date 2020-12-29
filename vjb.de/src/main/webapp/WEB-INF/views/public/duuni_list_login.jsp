<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/templates/navbar-login.jsp"%>
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
<title><spring:message code="duuni.page.tyopaikka" /></title>
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
</head>
<body>

<div class="container-fluid text-center">    
  <div class="row content">
  <!-- yhdes -->
    <div class="col-sm-2 sidenav">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    
   <!-- toinen -->
    <div class="col-sm-8 text-left">
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
							<th>Nimi</th>
							<th>Julkaistupäivä</th>
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
										<c:out value="${duunit.nimi }" />
									</p></td>
								<td><p>
										<fmt:formatDate value="${duunit.julkaistupv }" />
									</p></td>
								<td><p>
										<c:out value="${duunit.paikka }" />
									</p></td>
								<form:form modelAttribute="duuni" action="tyopaikka"
									method="POST">
									<spring:message code="button.more" var="more"/>
									<spring:message code="button.apply" var="apply" />
									<td><input type="submit" class="btn btn-default"  name="submit" value="${more }"></input></td>
									<td><sec:authorize access="isAuthenticated()"><input type="submit" class="btn btn-success" name="submit" value="${apply }"></input></sec:authorize></td>
									<input
										type="hidden" value="${duunit.id }" name="id" />
								</form:form>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>

    </div>
    <!-- kolmas -->
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
</html>