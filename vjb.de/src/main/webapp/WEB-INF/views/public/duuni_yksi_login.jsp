<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
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
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script><title><spring:message code="duuni.page.yksipaikka" /></title>

<style>
 /* Set black background color, white text and some padding */
    .container-fluid {
      width: 1000px;
      margin: auto;
      padding-bottom:50px;
    }
    
</style>
</head>
<body>

<div class="container-fluid text-center">    
  <div class="row content">
  <!-- yhdes -->
    <div class="col-sm-2 sidenav">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    
   <!-- toinen -->
    <div class="col-sm-8 text-left">
    <h1><code>Työpaikan tiedot</code></h1>
    <hr>
				
			<table class="table table-bordered">
		<tr>
			<th style="padding-right: 80px">Id</th>
			<td><c:out value="${duuni.id }" /></td>
		</tr>

		<tr>
			<th>Nimi</th>
			<td><c:out value="${duuni.nimi }" /></td>
		</tr>

		<tr>
			<th>Eräpäivä</th>
			
			<td><fmt:formatDate value="${duuni.erapv }"/></td>
		</tr>

		<tr>
			<th>Paikka</th>
			<td><c:out value="${duuni.paikka }" /></td>
		</tr>

		<tr>
			<th>Palkka</th>
			<td><c:out value="${duuni.palkka }" /></td>
		</tr>

		<tr>
			<th>Tiedot</th>
			<td><c:out value="${duuni.tiedot}" /></td>
		</tr>
		
		<tr>
			<th>Vaatimukset</th>
			<td><c:out value="${duuni.vaatimus }"/></td>
		</tr>
	</table>
			

    </div>
    <!-- kolmas -->
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