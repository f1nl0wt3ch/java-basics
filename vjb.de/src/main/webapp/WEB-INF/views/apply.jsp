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
.container-fluid {
	width: 1000px;
	margin: auto;
	padding-bottom: 10px;
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
			<h3>Luo uusi lomake</h3>
			<hr>
				<form:form class="form-horizontal" role="form"
			modelAttribute="ehdokas" method="post">
			
			<div class="form-group">
			        <spring:message code="lomake.suku.tyontekija" var="l_suku"/>
					<form:input path="suku" class="form-control" placeholder="${l_suku}" />
					<form:errors path="suku" class="help-inline" />
			</div>

			<div class="form-group">
			<spring:message code="lomake.etu.tyontekija" var="l_etu" />
				
					<form:input class="form-control" path="etu" placeholder="${l_etu }"/>
					<form:errors path="etu" Class="help-inline" />
				

			</div>
			<div class="form-group col-sm-4 pull-left">
			<spring:message code="lomake.ika.tyontekija" var="l_ika" />
					<form:input class="form-control" path="ika" placeholder="${l_ika }"/>
					<form:errors path="ika" Class="help-inline" />
			</div>
           
			<div class="form-group">
				<spring:message code="lomake.osoite.tyontekija" var="l_osoite" />
					<form:input class="form-control" path="osoite" placeholder="${l_osoite }" />
					<form:errors path="osoite" Class="help-inline" />
			</div>

			<div class="form-group">
			<spring:message code="lomake.kaupunki.tyontekija" var="l_kaupunki" />
					<form:input class="form-control" path="kaupunki" placeholder="${l_kaupunki }" />
					<form:errors path="kaupunki" Class="help-inline" />
			</div>

			<div class="form-group">
			<spring:message code="lomake.puh.tyontekija" var="l_puh"/>
					<form:input class="form-control" path="puh" placeholder="${l_puh }" />
					<form:errors path="puh" Class="help-inline" />
			</div>


			<div class="form-group">
			<spring:message code="lomake.sposti.tyontekija" var="l_sposti" />
					<form:input class="form-control" path="sposti" placeholder="${l_sposti }" />
					<form:errors path="sposti" Class="help-inline" />
			</div>

			<%-- <div>
				<div>Mihin alaan haluat hakea?</div>
				<div><form:select path="ala_id">
				<form:option value="">Select your department</form:option>
			<form:options items="${listId }"/>
				</form:select></div>
			</div> --%>
			
			<div class="form-group">
			<spring:message code="lomake.tutkinto.tyontekija" var="l_tutkinto" />
					<form:select class="form-control" path="tutkinto" placeholder="${l_tutkinto }">
						<form:option value="">
							<spring:message code="lomake.tutkinto.valinto" />
						</form:option>
						<form:options items="${tutkinnot }" />
					</form:select>
			</div>

			<div class="form-group">
			<spring:message code="lomake.kokemus.tyontekija" var="l_kokemus"/>
					<form:input class="form-control" path="kokemus" placeholder="${l_kokemus }" />
					<form:errors path="kokemus" Class="help-inline" />
			</div>

			<div class="form-inline">
			<%-- <spring:message code="lomake.sukupuoli.tyontekija" /> --%>
			<div class="col-sm-4"><form:label path="sukupuoli">
			        <spring:message code="lomake.nainen.tyontekija" />
			    </form:label> <form:radiobutton path="sukupuoli"
						value="Nainen"></form:radiobutton> </div>
			    
			<div class="col-sm-4"><form:label path="sukupuoli">
			        <spring:message code="lomake.mies.tyontekija" />
			    </form:label> <form:radiobutton path="sukupuoli"
						value="Nainen"></form:radiobutton> </div>
			    
			 </div>
			 
            <div class="form-group">
					<spring:message code="lomake.itse.tyontekija" var="l_itse"/>
			      <form:textarea class="form-control" rows="6" path="itsetieto" placeholder="${l_itse }" /></div>
			

			<div class="form-group">
					<spring:message code="lomake.kieli.tyontekija" var="l_kieli" />
					<form:select class="form-control" path="kieli" multioption="true" placeholder="${l_kieli }">
						<form:option value="">select skills</form:option>
						<form:options items="${kieliList }" />
					</form:select>
			</div>

			<div class="form-inline">
				<div class="col-sm-offset-4 col-sm-3">
				    <input type="hidden" value="${duuni_id }" />
				    <input type="hidden" value="${ehdokas_id }" />
					<button type="submit" class="btn btn-default">
						<spring:message code="lomake.nappi.tyontekija" />
					</button>
				</div>
			</div>
		</form:form>
			
			</div>
			<!-- end form -->
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