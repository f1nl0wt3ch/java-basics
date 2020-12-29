<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
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
    <li class="active"><a href="applied">Avoinhakemukset</a></li>
    <li><a href="update.do">Tietop�ivitys</a></li>
  </ol>
  <!-- Laita tietoja t�h�n -->
	<div class="col-sm-12 text-left">
	    <table class="table bordered">
	    
	    <tr><th>Ty�nimi</th>
	    <th>Paikka</th>
	    <th>Hakup�iv�</th>
	    <th>Haku p��ttyy</th>
	    </tr>
	    <c:forEach items="${applyList }" var="apply">
	    <tr><td><c:out value="${apply.nimi}"/></td>
	    <td><c:out value="${apply.tyopaikka}"/></td>
	    <td><fmt:formatDate value="${apply.hakemuspv}"/></td>
	    <td><fmt:formatDate value="${apply.hakupaattyy}"/></td>
	    </tr>
	    </c:forEach>
	    
	    
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