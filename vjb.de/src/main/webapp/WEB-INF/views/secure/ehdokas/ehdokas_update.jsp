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
	padding-bottom: 50px;
}
</style>
<title><spring:message code="ehdokas.page.home" /></title>

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
				<div class="col-sm-12 text-left"><p><h4><span class="glyphicon glyphicon-user"></span> Tilinhallinta</h3></p>
				<p class="text-right"><mark>Welcome <sec:authentication property="principal.username"/>!</mark></p>
				<hr >
					<ol class="breadcrumb">
    <li><a href="applied">Avoinhakemukset</a></li>
    <li class="active"><a href="">Tietopäivitys</a></li>
  </ol>
  <!-- Laita tietoja tähän -->
	<div class="col-sm-12 text-left">
	<form:form modelAttribute="ehdokas" role="form" method="POST">
	<div class="form-group col-sm-6"><form:input path="suku" class="form-control" placeholder="suku"/></div>
	<div class="form-group col-sm-6"><form:input path="etu" class="form-control" placeholder="etu"/></div>
	<div class="form-group col-sm-4"><form:input id="datepicker" path="ika" class="form-control" placeholder="ika"/></div>
	<script>
	      $(document).ready(function(){
	    	  $("#datepicker").datepicker({
	    		  dateFormat: "yyyy";
	    	  });
	      });
	    </script>
	<div class="form-group col-sm-12"><form:input path="osoite" class="form-control" placeholder="osoite"/></div>
	<div class="form-group col-sm-6"><form:input path="kaupunki" class="form-control" placeholder="kaupunki"/></div>
	<div class="form-group col-sm-12"><form:input path="puh" class="form-control" placeholder="Puhelinnumero"/></div>
	<div class="form-group col-sm-6"><form:input path="sposti" class="form-control" placeholder="Sähköposti"/></div>
	<div class="form-group col-sm-6"><form:input path="tutkinto" class="form-control" placeholder="Tutkinto"/></div>
	<div class="form-group col-sm-6"><form:input path="kieli" class="form-control" placeholder="kielitaito"/></div>
	<div class="form-group col-sm-4"><form:input path="kokemus" class="form-control" placeholder="Kokemus"/></div>
	<div class="form-group col-sm-6"><form:input path="kansalaisuus" class="form-control" placeholder="Kansalaisuus"/></div>
	<div class="form-group col-sm-offset-4 col-sm-4">
	<spring:message code="button.save" var="save" ></spring:message>
	<input type="submit" class="form-control btn-success" value="${save}"/></div>
	
	</form:form>
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