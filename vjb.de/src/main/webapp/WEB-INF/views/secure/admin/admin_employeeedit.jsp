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
	                <li><a class="w3-light-green" href="joblist">Jobs control</a></li>
					<li><a class="w3-light-gray" href="employeelist">Employees control</a></li>
					<li><a class="w3-light-gray" href="#">Partners control</a></li>
					<li><a class="w3-light-gray" href="newpost">News control</a></li>
					<li><a class="w3-light-gray" href="email">Send Email</a></li>
	    </ul>
		<!-- begin -->
		<div class="col-sm-9">
		<!-- Duunin vanhat tiedot -->
		<h3>Muokaa ehdokkaan tietoja</h3>
		<hr>
		<form:form class="form-horizontal" role="form" modelAttribute="ehdokas" method="post">
	    
	    <div class="form-group">
	    <div class="col-sm-4">
	    <form:input class="form-control" path="suku" placeholder="Suku"/>
	    <form:errors path="suku"></form:errors>
	    </div>
	    
	    <div class="col-sm-4">
	    <form:input class="form-control" path="etu" placeholder="Etu"/>
	    <form:errors path="etu"></form:errors>
	    </div>
	    </div>
	    
	   <div class="form-group">
	    <div class="col-sm-4">
	    <form:input id="datepicker" class="form-control" path="ika" placeholder="Ikä"/>
	    <form:errors path="ika"></form:errors>
	     <script>
	      $(document).ready(function(){
	    	  $("#datepicker").datepicker();
	      });
	    </script>
	    </div>
	    </div>
	    
	    <div class="form-group">
	    <div class="col-sm-2">
	    <form:input class="form-control" path="sukupuoli" placeholder="Sukupuoli"/>
	    <form:errors path="sukupuoli"></form:errors>
	    </div>
	    </div>
	    
	     <div class="form-group">
	     <div class="col-sm-12">
	    <form:input class="form-control" path="osoite" placeholder="Osoite"/>
	    <form:errors path="osoite"></form:errors>
	    </div>
	    </div>
	    
	     <div class="form-group">
	     <div class="col-sm-6">
	     <form:input class="form-control" path="kaupunki" placeholder="Kotikaupunki"/>
	     <form:errors path="kaupunki"></form:errors>
	     </div>
	    </div>
	    
	    <div class="form-group">
	    <div class="col-sm-8">
	    <form:input class="form-control" path="puh" placeholder="Puhelinnumero"/>
	    <form:errors path="puh"></form:errors>
	    </div>
	    </div>
	    
	    <div class="form-group">
	    <div class="col-sm-8">
	    <form:input class="form-control" path="sposti" placeholder="Sähköposti"/>
	    <form:errors path="sposti"></form:errors>
	    </div>
	    </div>
	    
	    <div class="form-group">
	    <div class="col-sm-4">
	    <form:input class="form-control" path="tutkinto" placeholder="Tutkinto" />
	    <form:errors path="tutkinto"></form:errors>
	    </div>
	    </div>
	    
	    <div class="form-group">
	    <div class="col-sm-8">
	    <form:input class="form-control" path="kieli" placeholder="Kielitaidot"/>
	    <form:errors path="kieli"></form:errors>
	    </div>
	    </div>
	    
	    <div class="form-group">
	    <div class="col-sm-4">
	    <form:input class="form-control" path="kokemus" placeholder="Kokemusvuosi" />
	    <form:errors path="kokemus"></form:errors>
	    </div>
	    </div>
	    
	    <div class="form-group">
	    <div class="col-sm-6">
	    <form:input class="form-control" path="kansalaisuus" placeholder="Kansalaisuus" />
	    <form:errors path="kansalaisuus"></form:errors>
	    </div>
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