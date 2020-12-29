<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><spring:message code="register.page" /></title>
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
#content {
	width: 1000px;
	height: 600px;
	margin: auto;
	padding: auto;
}
</style>
</head>
<body>

	<div id="content">
		<form:form class="form-horizontal" role="form"
			modelAttribute="kayttaja" method="post">
			<fieldset>
				<legend>
					<h3>
						<spring:message code="register.page" />
					</h3>
				</legend>

                <div class="form-group">
                <div class="col-sm-3"></div>
                <div class="col-sm-4">
                 <p class="text text-warning"><c:out value="${virhe }"/></p>
                </div>
                </div>
				<div class="form-group">
					
						<form:label class="col-sm-3" path="suku">
							<spring:message code="lomake.suku.tyontekija" /></form:label>
						<div class="col-sm-4">
						<form:input class="form-control" path="suku"
							placeholder="Enter firstname" />
						<form:errors path="suku" class="help-inline"></form:errors>
						</div>
				</div>
					
				<div class="form-group">
						<form:label class="col-sm-3" path="etu">
							<spring:message code="lomake.etu.tyontekija" /></form:label>
							<div class="col-sm-4">
						<form:input class="form-control" path="etu"
							placeholder="Enter lastname" />
						<form:errors path="etu"></form:errors>
						</div>

				</div>
				<div class="form-group">
						<form:label class="col-sm-3" path="sposti">
							<spring:message code="lomake.sposti.tyontekija"></spring:message></form:label>
							<div class="col-sm-4">
						<form:input type="email" class="form-control" path="sposti"
							placeholder="Enter email" />
						<form:errors path="sposti" class="help-inline"></form:errors>
						</div>
				</div>	

					<div class="form-group">
							<form:label class="col-sm-3" path="tunnus">
								<spring:message code="login.tunnus.kayttaja"></spring:message></form:label>
							<div class="col-sm-4">	
							<form:input type="text" class="form-control" path="tunnus"
								placeholder="Enter username" />
						    <form:errors path="tunnus" class="help-inline"/>
						    </div>
					</div>

					<div class="form-group">
							<form:label class="col-sm-3" path="salasana">
								<spring:message code="login.salasana.kayttaja" /></form:label>
							<div class="col-sm-4">
							<form:input type="password" class="form-control" path="salasana"
								placeholder="Enter password" />
							<form:errors path="salasana"/>
							</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-4">
							<button type="submit" class="btn btn-default">
								<spring:message code="register.uusi.kayttaja"></spring:message>
							</button>
						</div>
					</div>
			</fieldset>
		</form:form>
	</div>
<%@ include file="/WEB-INF/views/templates/footer-over.jsp"%>
<%@ include file="/WEB-INF/views/templates/footer-under.jsp"%>
</body>
</html>