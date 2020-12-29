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
<%@ include file="/WEB-INF/views/templates/navbar-logout.jsp"%>
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
		<div class="col-sm-12">
		<table class="table">
		<tr>
		<th>Id</th>
		<th>Päivämäärä</th>
	    <th>Aihe</th>
		</tr>
		<c:forEach items="${uutiset }" var="uutinen" >
		<tr>
		<td><c:out value="${uutinen.id }"/></td>
		<td><fmt:formatDate value="${uutinen.paiva }"/></td>
	    <td><c:out value="${uutinen.aihe }"/></td>
	    <form:form action="deletenew" method="post">
	    <input type="hidden" name="id" value="${uutinen.id }"/>
	    
	    <td><button type="submit" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-trash"></span></button></td>
	    
	    </form:form>
		</tr>
		</c:forEach>
		</table>
			<h3>Post news</h3>
			<hr>

			<form:form class="form-horizontal" role="form"
				modelAttribute="uutinen" enctype="multipart/form-data" method="Post">
				<div class="form-group">
					<form:input class="col-sm-4" path="paiva" id="datepicker"
						placeholder="Päivämäärä" />
				</div>
				<script type="text/javascript">
										$(function() {
											$('#datepicker').datepicker();
										});
									</script>
				<div class="form-group">
					<input type="file" class="form-control col-sm-3" name="kuva" ></input>
				</div>

				<div class="form-group">
					<form:input type="text" class="col-sm-6" path="aihe"
						placeholder="Syötä aihe"></form:input>
				</div>

				<div class="form-group">
					<form:textarea rows="15" class="form-control" path="sisalto"></form:textarea>
				</div>

				<div class="form-group">
					<input type="submit" name="submit" value="Post"
						class="btn btn-default col-sm-3" />
				</div>
			</form:form>
		</div>
		<!-- end -->




	</div>
<%@ include file="/WEB-INF/views/templates/footer-over.jsp"%>
<%@ include file="/WEB-INF/views/templates/footer-under.jsp"%>
</body>
</html>