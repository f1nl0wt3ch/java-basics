<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
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
</style>
<title><spring:message code="employee.page.list" /></title>
</head>
<body style=background:url(resources/images/backgroundi.jpg)>
<div class="container-fluid text-center">    
  <div class="row content">
    <!-- <div class="col-sm-2 sidenav">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div> -->
    
    <!--  content begin  -->
    <div class="col-sm-12 text-left"> 
        <div id="vietjob" class="carousel slide" data-ride="carousel">
           <ol class="carousel-indicators">
               <li data-target="#vietjob" data-slide-to="0" class="active"></li>
               <li data-target="#vietjob" data-slide-to="1"></li>
               <li data-target="#vietjob" data-slide-to="2"></li>
               <li data-target="#vietjob" data-slide-to="3"></li>
               <li data-target="#vietjob" data-slide-to="4"></li>
               <li data-target="#vietjob" data-slide-to="5"></li>
               <li data-target="#vietjob" data-slide-to="6"></li>
           </ol>
           <div class="carousel-inner" role="listbox">
              <div class="item active">
                  <img src="resources/images/slideshow/Code-Zuckerberg-poster.png" >
              </div>
              <div class="item">
                  <img src="resources/images/slideshow/CXRCcePWcAAy1e4.png" >
              </div>
              <div class="item">
                  <img src="resources/images/slideshow/hiringnow.jpg" >
              </div>
              <div class="item">
                  <img src="resources/images/slideshow/Job-applications-employment-sex-offenders.jpg" >
              </div>
              <div class="item">
                  <img src="resources/images/slideshow/jobs-how-to-apply-hook_1.png" >
              </div>
              <div class="item">
                  <img src="resources/images/slideshow/promotional-jobs-front-page.jpg" >
              </div>
              <div class="item">
                  <img src="resources/images/slideshow/qwskaebk9j8fxyr2kjno.jpg" >
              </div>
           </div>
               <a class="left carousel-control" href="#vietjob" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#vietjob" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
        </div>
    </div>
    
   <!-- end content -->
    <!-- <div class="col-sm-2 sidenav">
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div> -->
  </div>
</div>
<%@ include file="/WEB-INF/views/templates/footer-over.jsp"%>
<%@ include file="/WEB-INF/views/templates/footer-under.jsp"%>
</body>
</html>