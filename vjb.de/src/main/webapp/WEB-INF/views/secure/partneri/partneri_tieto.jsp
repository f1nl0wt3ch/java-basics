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
					<h3><span class="glyphicon glyphicon-user"></span>Tilinhallinta</h3>
						<p class="text-right"><mark>Welcome <sec:authentication property="principal.username"/>!</mark></p>
						<hr>
						<ul class="nav navbar-nav">
							<li><a href="uusiduuni">Laita uusi työpaikka</a></li>
							<li><a href="postedjobs">Julkaistut työpaikat</a></li>
							<li class="active"><a href="#">Partneritiedot</a></li>
						</ul>
				<div class="col-sm-12 text-left">
				

						<!-- Laita tietoja tähän -->
						<div class="col-sm-6 text-left">
						   <form:form modelAttribute="partneri">
						        <div class="form-group col-sm-12">
						        <div >
						        <form:input type="text" path="nimi" class="form-control"  placeholder="Yhtiönimi"/>
						        </div>
						        </div>
						        <div class="form-group col-sm-12">
						        <div>
						         <form:input type="text" path="osoite" class="form-control" placeholder="Osoite"/>
						         </div>
						        </div>
						        <div class="form-group col-sm-12">
						        <form:input type="text" path="puh" class="form-control" placeholder="Puhelin numero"/>
						        </div>
						        <div class="form-group col-sm-12">
						        <form:input type="text" path="websivu" class="form-control" palceholder="Websivusto"/>
						        </div>
						        <div class="form-group col-sm-12">
						        <spring:message code="button.edit" var="edit" />
						        <input type="submit" class="col-sm-8-offset col-sm-4" value="${edit }"></input>
						        </div>
						   </form:form>
						</div>
						<div class="col-sm-6 text-left">
						     <form:form modelAttribute="kayttaja">
						     <div class="form-group">
						         <form:input type="text" path="sposti" class="form-control" placeholder="Sähköposti"/>
						     </div>
						     <div class="form-group">
						         <form:password path="salasana" class="form-control" placeholder="Salasana"/>
						     </div>
						     <div class="form-group"></div>
						     <div class="form-group"></div>
						     <div class="form-group">
						        
						        <input type="submit" class="col-sm-8-offset col-sm-4" value="${edit }"></input>
						        </div>
						     </form:form>
						</div>
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