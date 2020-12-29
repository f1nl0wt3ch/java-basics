<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
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
	padding-bottom: 25px;
}
</style>



<title><spring:message code="partneri.page.home" /></title>
</head>
<body>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<p>
					<a href="#">Link</a>
				</p>
				<p>
					<a href="#">Link</a>
				</p>
				<p>
					<a href="#">Link</a>
				</p>
			</div>
			<div class="col-sm-8 text-left">
			<div class="col-sm-12 text-left">
					<p>
					<h3>
						<span class="glyphicon glyphicon-user"></span> Tilinhallinta</h3></p>
						<p class="text-right"><mark>Welcome <sec:authentication property="principal.username"/>!</mark></p>
						<hr>
						<ol class="breadcrumb">
							<li><a href="uusiduuni.do">Laita
									uusi työpaikka</a></li>
							<li class="active"><a href="#">Julkaistut työpaikat</a></li>
							<li><a href="tiedot.do">Partneritiedot</a></li>
						</ol>


						<!-- Laita tietoja tähän -->
						<div class="col-sm-12 text-left">
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
						<c:forEach items="${duuniList}" var="duunit">
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
								<form:form modelAttribute="duuni" method="POST">
																	
									<input type="hidden" value="${duunit.id }" name="duuni_id" />
									<td><input type="submit" class="btn btn-success" name="submit" value="Muokkaa"/></td>
								</form:form>
							</tr>
						</c:forEach>
					</tbody>
				</table>
						</div>
						<!-- loppu	 -->
				</div>



				<div class="col-sm-4"></div>
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