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
<style>
/* Set black background color, white text and some padding */
.container-fluid {
    
	width: 1000px;
	margin: auto;
	padding-bottom: 20px;
}
</style>
<title>Apply</title>
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
			
			<!--  begin content -->
			<div class="col-sm-8 text-left">

	       

	        <form:form role="form" action="sendCV" modelAttribute="ehdokas" method="post">
	        <!-- ehdokkaan tiedot alku -->
	        
	        <div class="form-inline col-sm-8">
	        <label class="col-sm-4">Työ id</label>
	        <p class="p-control"><c:out value="${duuni.id }"/></p>
	        </div>
	        
	        <div class="form-inline col-sm-8">
	        <label class="col-sm-4">Työ nimi</label>
	        <p class="p-control"><c:out value="${duuni.nimi }"/></p>
	        </div>
	       <div class="form-group">
	        <spring:message code="lomake.suku.tyontekija" var="l_suku"/>
			<div class="col-sm-6"><form:input path="suku" class="form-control" placeholder="${l_suku}" />
					<form:errors path="suku" class="help-inline" /></div>
				
				    <spring:message code="lomake.etu.tyontekija" var="l_etu" />
			<div class="form-group col-sm-6"><form:input class="form-control" path="etu" placeholder="${l_etu }"/>
					<form:errors path="etu" Class="help-inline" /></div>
				</div> 
			


			<div class="form-group col-sm-4">
			<spring:message code="lomake.ika.tyontekija" var="l_ika" />
			<form:input class="form-control" path="ika" placeholder="${l_ika }"/>
					<form:errors path="ika" Class="help-inline" />
			</div>

			<div class="form-group col-sm-12">
			<spring:message code="lomake.osoite.tyontekija" var="l_osoite" />
			<form:input class="form-control" path="osoite" placeholder="${l_osoite }" />
			<form:errors path="osoite" Class="help-inline" />
			</div>

			<div class="form-group col-sm-6">
			<spring:message code="lomake.kaupunki.tyontekija" var="l_kaupunki" />
					<form:input class="form-control" path="kaupunki" placeholder="${l_kaupunki }" />
					<form:errors path="kaupunki" Class="help-inline" />
			</div>

			<div class="form-group col-sm-8">
			<spring:message code="lomake.puh.tyontekija" var="l_puh"/>
					<form:input class="form-control" path="puh" placeholder="${l_puh }" />
					<form:errors path="puh" Class="help-inline" />
			</div>


			<div class="form-group col-sm-8">
			<spring:message code="lomake.sposti.tyontekija" var="l_sposti" />
					<form:input class="form-control" path="sposti" placeholder="${l_sposti }" />
					<form:errors path="sposti" Class="help-inline" />
			</div>

			
			
			<div class="form-group col-sm-6">
			<spring:message code="lomake.tutkinto.tyontekija" var="l_tutkinto" />
					<form:input class="form-control" path="tutkinto" placeholder="${l_tutkinto }" />
					<form:errors path="tutkinto" Class="help-inline" />
			</div>

			<div class="form-group col-sm-2">
			<spring:message code="lomake.kokemus.tyontekija" var="l_kokemus"/>
					<form:input class="form-control" path="kokemus" placeholder="${l_kokemus }" />
					<form:errors path="kokemus" Class="help-inline" />
			</div>

			
			 
            <div class="form-group col-sm-12">
					<spring:message code="lomake.itse.tyontekija" var="l_itse"/>
			      <form:textarea class="form-control" rows="6" path="itsetieto" placeholder="${l_itse }" /></div>
			

			<div class="form-group col-sm-6">
					<spring:message code="lomake.kieli.tyontekija" var="l_kieli" />
					<form:input class="form-control" path="kieli" multioption="true" placeholder="${l_kieli }" />
			</div>
			<input type="hidden" value="${duuni.id }" name="duuni_id" />
			<input type="hidden" value="${ehdokas.id }" name="ehdokas_id" />
			<div class="form-inline">
				<div class="col-sm-offset-5 col-sm-4">
					<button type="submit" class="btn btn-default">
						Apply
					</button>
				</div>
			</div>	
			</form:form>
			</div>
			<!-- end content -->
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