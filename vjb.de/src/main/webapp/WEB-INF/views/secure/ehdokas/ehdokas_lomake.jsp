<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Jquery JS-->
<script src="https://code.jquery.com/jquery-1.12.2.min.js" integrity="sha256-Xxq2X+KtazgaGuA2cWR1v3jJsuMJUozyIXDB3e793L8="   crossorigin="anonymous"></script> 
<script src="<c:url value="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" />"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- datepicker -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<title><spring:message code="lomake.page.ehdokas" /></title>
<%@ include file="/WEB-INF/views/templates/navbar-logout.jsp"%>

<style>
#content-left {
	height: 1000px;
	width: 800px;
	margin: auto;
	color: black;
	padding-top: 20px;
	padding-left: 0px;
}
</style>
</head>
<body>

	<div id="content-left">
		<form:form class="form-horizontal" role="form"
			modelAttribute="ehdokas" method="post">
			<fieldset>
				<legend>
					<h3>Henkilön tiedot</h3>
				</legend>

				<div class="form-group">
					<div class="col-sm-2">
						<form:label path="suku">
							<spring:message code="lomake.suku.tyontekija" />
						</form:label>
					</div>
					<div class="col-sm-6">
					<form:input path="suku" class="form-control"
							cssErrorClass="VirheellinenKentta" />
						<form:errors path="suku" cssClass="Virheteksti" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-2">
						<form:label path="etu">
							<spring:message code="lomake.etu.tyontekija" />
						</form:label>
					</div>

					<div class="col-sm-6">
						<form:input path="etu" class="form-control"
							cssErrorClass="VirheellinenKentta" />
						<form:errors path="etu" cssClass="Virheteksti" />
					</div>

				</div>
				<div class="form-group">
					<div class="col-sm-2">
						<form:label path="ika">
							<spring:message code="lomake.ika.tyontekija" />
						</form:label>
					</div>
					<div class="col-sm-6">
					<fmt:formatDate value="${ika }" pattern="dd-MM-yyyy" var="ika"/>
						<form:input path="ika" value="${ika }" id="datepicker" class="form-control col-sm-2"
							cssErrorClass="VirheellinenKentta" />
						<form:errors path="ika" cssClass="Virheteksti" />
						<script>
                        $(function() {
                        $( "#datepicker" ).datepicker();
                        });
                        </script>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-2">
						<form:label path="osoite">
							<spring:message code="lomake.osoite.tyontekija" />
						</form:label>
					</div>
					<div class="col-sm-9">
						<form:input path="osoite" class="form-control"
							cssErrorClass="VirheellinenKentta" />
						<form:errors path="osoite" cssClass="Virheteksti" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-2">
						<form:label path="kaupunki">
							<spring:message code="lomake.kaupunki.tyontekija" />
						</form:label>
					</div>
					<div class="col-sm-6">
						<form:input path="kaupunki" class="form-control"
							cssErrorClass="VirheellinenKentta" />
						<form:errors path="kaupunki" cssClass="Virheteksti" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-2">
						<form:label path="puh">
							<spring:message code="lomake.puh.tyontekija" />
						</form:label>
					</div>
					<div class="col-sm-6">
						<form:input path="puh" class="form-control"
							cssErrorClass="VirheellinenKentta" />
						<form:errors path="puh" cssClass="Virheteksti" />
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-2">
						<form:label path="sposti">
							<spring:message code="lomake.sposti.tyontekija" />
						</form:label>
					</div>
					<div class="col-sm-6">
						<form:input path="sposti" class="form-control"
							cssErrorClass="VirheellinenKentta" />
						<form:errors path="sposti" cssClass="Virheteksti" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-3">
						<form:label path="alaId">Mihin alaan haluat hakea?</form:label>
					</div>
					<div class="col-sm-6 c-select">
						<select name="ala" class="form-control">
							<option>Valitse työala</option>
							<c:forEach items="${alaList }" var="alaList">
								<option><c:out value="${alaList }" /></option>
							</c:forEach>
						</select>
					</div>
					<div class="col-sm-3">
						<input type="text" name="ala" class="form-control"
							placeholder="Tai syötä tähän" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-2">
						<form:label path="tutkinto">
							<spring:message code="lomake.tutkinto.tyontekija" />
						</form:label>
					</div>
				  <div class="col-sm-2" >
					<form:select path="tutkinto" class="form-control">
						<form:option value="">
							<spring:message code="lomake.tutkinto.valinto" />
						</form:option>
						<c:forEach items="${tutkintoList}" var="tutkintoList">
						    <form:option value=""><c:out value="${tutkintoList }"/></form:option>
						</c:forEach>
					</form:select>
				</div>
					<div class="col-sm-3">
						<form:input path="tutkinto" class="form-control"
							placeholder="Tai syötä tähän" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-2">
						<form:label path="kokemus">
							<spring:message code="lomake.kokemus.tyontekija" />
						</form:label>
					</div>
					<div class="col-sm-2">
						<form:input path="kokemus" class="form-control col-sm-2"
							cssErrorClass="VirheellinenKentta" />
						<form:errors path="kokemus" cssClass="Virheteksti" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-2">
						<form:label path="sukupuoli">
							<spring:message code="lomake.sukupuoli.tyontekija" />
						</form:label>
					</div>
					<div class="col-sm-2">
						<form:label path="sukupuoli">
							<spring:message code="lomake.nainen.tyontekija" />
						</form:label>
						<form:radiobutton path="sukupuoli" value="Nainen"></form:radiobutton>
					</div>

					<div class="col-sm-2">
						<form:label path="sukupuoli">
							<spring:message code="lomake.mies.tyontekija" />
						</form:label>
						<form:radiobutton path="sukupuoli" value="Nainen"></form:radiobutton>
					</div>

				</div>

				<div class="form-group">
					<div class="col-sm-2">
						<form:label path="itsetieto">
							<spring:message code="lomake.itse.tyontekija" />
						</form:label>
					</div>
					<div class="col-sm-10">
						<form:textarea rows="6" path="itsetieto" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-2">
						<form:label path="kieli">
							<spring:message code="lomake.kieli.tyontekija" />
						</form:label>
					</div>
					<%-- <div class="col-sm-3">
					<form:select class="form-control" path="kieli" multioption="true" >
						<form:option value="">select skills</form:option>
						<form:options items="${kieliList }" />
					</form:select>
				</div> --%>

					<div class="col-sm-3">
						<form:input path="kieli" class="form-control"
							placeholder="Syötä tähän" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-2">
						<form:label path="kansalaisuus">
			Kansalaisuus</form:label>
					</div>
					<div class="col-sm-3">
						<form:input path="kansalaisuus" class="form-control"
							placeholder="syötä kansalaisuudesi" />
					</div>
				</div>

				<div class="form-inline">
					<div class="col-sm-offset-2 col-sm-2">
						<button type="submit">
							<spring:message code="lomake.nappi.tyontekija" />
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