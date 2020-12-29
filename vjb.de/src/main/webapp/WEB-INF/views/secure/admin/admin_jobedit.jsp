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
		<div class="col-sm-9">
		<!-- Duunin vanhat tiedot -->
		<h3>Muokaa duunin tietoja</h3>
		<hr>
		<form:form class="form-horizontal" role="form" modelAttribute="duuni" method="post">
	    <div class="form-group">
	    <form:label class="col-sm-3" path="nimi">Nimi:</form:label>
	    <form:input class="form-control" path="nimi"/>
	    <form:errors path="nimi"></form:errors>
	    </div>
	    
	    <div class="form-group">
	    <form:label class="col-sm-3" path="tiedot">Tiedot:</form:label>
	    <form:textarea class="form-control" path="tiedot" rows="8" />
	    <form:errors path="tiedot"></form:errors>
	    </div>
	    
	     <div class="form-group">
	     <form:label class="col-sm-3" path="paikka">Paikka:</form:label>
	     <form:input class="col-sm-4" path="paikka" />
	     <form:errors path="paikka"></form:errors>
	    </div>
	    
	    <div class="form-group">
	    <form:label class="col-sm-3" path="palkka">Palkka:</form:label>
	    <form:input class="col-sm-4" path="palkka" />
	    <form:errors path="palkka"></form:errors>
	    </div>
	    
	    <div class="form-group">
	    <form:label class="col-sm-3" path="sopimus">Sopimus:</form:label>
	    <form:input class="col-sm-6" path="sopimus" />
	    <form:errors path="sopimus"></form:errors>
	    </div>
	    
	    <div class="form-group">
	    <form:label class="col-sm-3" path="vaatimus">Vaatimus:</form:label>
	    <form:textarea class="form-control" path="vaatimus" rows="8" />
	    <form:errors path="vaatimus"></form:errors>
	    </div>
	    
	    <div class="form-group">
	    <form:label class="col-sm-3" path="erapv">Eräpäivä:</form:label>
	    <form:input id="datepicker" class="col-sm-6" path="erapv" />
	    <form:errors path="erapv"></form:errors>
	    <script>
	      $(document).ready(function(){
	    	  $("#datepicker").datepicker();
	      });
	    </script>
	    </div>
	    
	    <div class="form-group">
	    <spring:message code="button.save" var="save"></spring:message>
	    <input type="submit" class="btn btn-success col-sm-offset-4 col-sm-2" value="${save }" />
	    </div>
	    </form:form>
	    </div>
		 <!-- end -->
       
     
	</div>
<%@ include file="/WEB-INF/views/templates/footer-over.jsp"%>
<%@ include file="/WEB-INF/views/templates/footer-under.jsp"%>
</body>
</html>