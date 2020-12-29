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
						<h3><span class="glyphicon glyphicon-user"></span>Tilinhallinta</h3>
						<p class="text-right"><mark>Welcome <sec:authentication property="principal.username"/>!</mark></p>
						
						</p>
						<hr>
						<ul class="nav navbar-nav">
							<li><a href="partner/uusiduuni">Laita uusi työpaikka</a></li>
							<li><a href="partner/postedjobs">Julkaistut työpaikat</a></li>
							<li class="active"><a href="">Partneritiedot</a></li>
						</ul>


						<!-- Laita tietoja tähän -->
						<div class="col-sm-12 text-left">
						
						<form:form role="form" modelAttribute="duuni" action="jobedit.do" method="post">

								<div class="form-group">
									<form:input type="text" class="form-control" path="nimi"
										placeholder="Työnimi"></form:input>
								</div>

								<div class="form-group">
									<form:textarea class="form-control" path="tiedot" rows="6"
										placeholder="Työtiedot" />
								</div>

								<div class="form-group">
									<form:input type="text" class="form-control" path="palkka"
										placeholder="Palkka 2000/kk"></form:input>
								</div>

								<div class="form-group">
									<form:input type="text" class="form-control" path="paikka"
										placeholder="Paikka"></form:input>
								</div>

								<div class="form-group">
									<form:textarea class="form-control" path="vaatimus" rows="6"
										placeholder="Työvaatimukset" />
								</div>

								<div class="form-group">
									<form:select class="form-control" path="sopimus"
										placeholder="Työsopimus">
										<form:option value="Valitse sopimustyyppi"></form:option>
										<form:options items="${sopimukset }"></form:options>
									</form:select>
								</div>

								<div class="form-group">

									<input class="form-control" path="erapv" id="datepicker"
										placeholder="Eräpäivä" />
									<script type="text/javascript">
										$(function() {
											$('#datepicker').datepicker();
										});
									</script>
								</div>

                               <spring:message code="button.save" var="save"></spring:message>
								<input type="submit"
									class="col-sm-offset-5 col-sm-2 btn-success" value="${save }" />

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