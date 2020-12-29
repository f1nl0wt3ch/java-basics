<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="<c:url value="resources/bootstrap-3.3.6/js/bootstrap.min.js" />"></script>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" />

<style>
.navbar-inverse {
   width: 1000px;
   margin: auto;
   height: 50px;
   border-radius:0;
}
.dropdowm-menu li a {
   color: #000000;
}
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li class="dropdown">
      <a href="" class="dropdown-toggle" data-toggle="dropdown" ><span class="glyphicon glyphicon-home"></span><span class="caret"></span></a>
         <ul class="dropdown-menu" role="menu">
          <li><a href="#"><spring:message code="uutiset.template.sivu"></spring:message></a></li>
          <li><a href="vjb.de/tyopaikat"><spring:message code="kaikki.tyopaikka"></spring:message></a></li>
          <li><a href="vjb.de/ehdokas"><spring:message code="kaikki.ehdokas"></spring:message></a></li>
          <li><a href="vjb.de/lomake"><spring:message code="lomake.template.sivu"></spring:message></a></li>
          <li><a href="vjb.de/partneri"><spring:message code="partnerit.template.sivu"></spring:message></a></li>
          <li><a href="vjb.de/yhteystiedot"><spring:message code="yhteystiedot.template.sivu"></spring:message></a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-center">
      <li><a href="register"><span class="glyphicon glyphicon-user"></span> <spring:message code="register.uusi.kayttaja"></spring:message></a></li>
      <li><a href="login.do"><span class="glyphicon glyphicon-log-in"></span> <spring:message code="login.kirjaudu.kayttaja"></spring:message></a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    
                <li><a href="?lang=en">en</a></li>
				<li><a href="?lang=vn">vn</a></li>
				<li><a href="?lang=fi">fi</a></li>
			
    </ul>
  </div>
</nav>

</body>
</html>