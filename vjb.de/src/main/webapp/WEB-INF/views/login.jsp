<%@ page session="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="login.page" /></title>
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
<script type="text/javascript" src="resources/js/login.js"></script>
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
<h3><spring:message code="login.kirjaudu.kayttaja" /></h3>
<hr>
    
	<c:url value="tarkastus" var="springcheck"></c:url>
<form action='${springcheck }' class="form-horizontal" role="form"  method="post">
    <div class="form-group">
    <div class="col-sm-2"></div>
    <div class="col-sm-4">
    <c:if test="${not empty loginerror }">
    <p class="text text-warning">Sis‰‰nkirjautuminen ep‰onnistui</p>
    </c:if>
    </div>
    </div>
  <div class="form-group">
    <label class="control-label col-sm-2"><spring:message code="login.tunnus.kayttaja"></spring:message>:</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="tunnus" placeholder="Enter username" />
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" ><spring:message code="login.salasana.kayttaja"></spring:message>:</label>
    <div class="col-sm-4"> 
      <input type="password" class="form-control" name="salasana" placeholder="Enter password" />
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-4">
      <div class="checkbox">
        <label><input type="checkbox" name="remember-me"> <spring:message code="login.remember.kayttaja"></spring:message></label>
      </div>
    </div>
  </div>
  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-4">
      <button type="submit" class="btn btn-default"><spring:message code="login.kirjaudu.kayttaja"/></button>
    </div>
  </div>
</form>

     

</div>
<%@ include file="/WEB-INF/views/templates/footer-over.jsp"%>
<%@ include file="/WEB-INF/views/templates/footer-under.jsp"%>
</body>
</html>