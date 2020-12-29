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
    }
    .form-control{
         width: 30px;
    }
</style>
<title><spring:message code="employee.page.list" /></title>
</head>
<body>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    <div class="col-sm-8 text-left">
    <div class="panel-heading text-left"><h3>Omat tiedot</h3></div>
      
     <div>
     <!-- begin1 -->
         
         <div class="panel-content">
         <table class="table table-bordered">
           <tr>
              <th >Nimi</th>
              <td class="col-sm-6"><c:out value="${ehdokas.etu} " /> <c:out value="${ehdokas.suku} " /></td>
           </tr>
          
           <tr>
              <th >Syntymävuosi</th>
              <td class="col-sm-6"><fmt:formatDate value="${ehdokas.ika}" pattern="dd-MM-yyyy"/></td>
           </tr>
           
           <tr>
              <th >Sukupuoli</th>
              <td class="col-sm-6"><c:out value="${ehdokas.sukupuoli} " /></td>
           </tr>
           
           <tr>
              <th >Sähköposti</th>
              <td class="col-sm-6"><c:out value="${ehdokas.sposti} " /></td>
           </tr>
           
           <tr>
              <th >Puhelinnumero</th>
              <td class="col-sm-6"><c:out value="${ehdokas.puh} " /></td>
           </tr>
       
            <tr>
              <th >Tutkinto</th>
              <td class="col-sm-6"><c:out value="${ehdokas.tutkinto} " /></td>
           </tr>
           <tr>
              <th >Kielitaito</th>
              <td class="col-sm-6"><c:out value="${ehdokas.kieli} " /></td>
           </tr>
           <tr>
              <th >Kokemus</th>
              <td class="col-sm-6"><c:out value="${ehdokas.kokemus} " /> vuotta</td>
           </tr>
         
            <tr>
              <th >Osoite</th>
              <td class="col-sm-6"><c:out value="${ehdokas.osoite} " /> ,<c:out value="${ehdokas.kaupunki} " /></td>
           </tr>
            <tr>
              <th>Kansalaisuus</th>
              <td class="col-sm-6"><c:out value="${ehdokas.kansalaisuus} " /></td>
           </tr>
           <tr>
              <th >Minusta</th>
              <td class="col-sm-6"><c:out value="${ehdokas.itsetieto} " /></td>
           </tr>
         </table>
         
         </div>
         <!-- end3 -->
     </div>

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