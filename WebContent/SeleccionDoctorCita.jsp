<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/paciente" %>
<%@taglib prefix="med" tagdir="/WEB-INF/tags/medico" %>


<shiro:hasRole name="paciente">
<t:pacientepagestemplate>

	<jsp:attribute name="head">
		<title>Selección Doctor - DocApp</title>
	</jsp:attribute>
	
	<jsp:body>
	   
	    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom subemargen">
		        <h1>Selección de Doctor</h1>
		</div>
		    <h2 class="text-center">${especialidad.nombre}</h2>
            <p>Haz click en los doctores para comprobar su disponibilidad.</p>
        <div class="row doctores">
	    
	        <!-- caja doctores -->
	         
	    	<c:forEach items="${especialidad.medicosEsp}" var="medEsp">
				<div class="col-lg-3 col-md-4">
	           		<a href="FechaServlet?med=${medEsp.email}">
                      <div class="box">
                          <i class="fas fa-user-md"></i>
                          <h4 class="title">Doctor/a ${medEsp.apellidos}</h4>
                          <div class="separador-horizontal"></div>
                      </div>
               		</a>
             	</div>
			</c:forEach>
	        
	        <!-- / caja doctores -->
        
        </div>

	</jsp:body>

</t:pacientepagestemplate>
</shiro:hasRole>

<shiro:hasRole name="medico">
  <med:medicopagestemplate>

	<jsp:attribute name="head">
		<title>Selección Doctor - DocApp</title>
	</jsp:attribute>
	
	<jsp:body>
	   
	    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom subemargen">
		        <h1>Selección de Doctor</h1>
		</div>
		    <h2 class="text-center">${especialidad.nombre}</h2>
            <p>Haz click en los doctores para comprobar su disponibilidad.</p>
        <div class="row doctores">
	    
	        <!-- caja doctores -->
	         
	    	<c:forEach items="${especialidad.medicosEsp}" var="medEsp">
				<div class="col-lg-3 col-md-4">
	           		<a href="FechaServlet?med=${medEsp.email}">
                      <div class="box">
                          <i class="fas fa-user-md"></i>
                          <h4 class="title">Doctor/a ${medEsp.apellidos}</h4>
                          <div class="separador-horizontal"></div>
                      </div>
               		</a>
             	</div>
			</c:forEach>
	        
	        <!-- / caja doctores -->
        
        </div>

	</jsp:body>

</med:medicopagestemplate>

</shiro:hasRole>