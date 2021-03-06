<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/paciente"%>
<%@taglib prefix="med" tagdir="/WEB-INF/tags/medico"%>
<%@taglib prefix="pas" tagdir="/WEB-INF/tags/pas"%>

<shiro:hasRole name="paciente">
<t:pacientepagestemplate>

	<jsp:attribute name="head">
		<title>Selecci�n Especialidad - DocApp</title>
	</jsp:attribute>

	<jsp:body>
	   
	    <div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom subemargen">
		        <h1>Selecci�n de Especialidad</h1>
		</div>
            <p>Elije la especialidad m�dica de tu cita.</p>
        <div class="row especialidades">
	    
	        <!-- caja especialidad -->
	        
	        <c:forEach items="${especialidades}" var="esp">
				<div class="col-lg-3 col-md-4">
	           		<a href="DoctoresEspecialidadServlet?esp=${esp.id }">
                		<div class="box">
                			<i class="fas fa-star-of-life"></i>
                			<h4 class="title">${esp.nombre }</h4>
                			<div class="separador-horizontal"></div>
                		</div>
               		</a>
            	</div>
			</c:forEach>
	         
	        <!-- / caja especialidad -->
        
        </div>

	</jsp:body>

</t:pacientepagestemplate>

</shiro:hasRole>

<shiro:hasRole name="medico">
	<med:medicopagestemplate>

	<jsp:attribute name="head">
		<title>Selecci�n Especialidad - DocApp</title>
	</jsp:attribute>

	<jsp:body>
	   
	    <div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom subemargen">
		        <h1>Selecci�n de Especialidad</h1>
		</div>
            <p>Elije la especialidad m�dica de tu cita.</p>
        <div class="row especialidades">
	    
	        <!-- caja especialidad -->
	        
	        <c:forEach items="${especialidades}" var="esp">
				<div class="col-lg-3 col-md-4">
	           		<a href="DoctoresEspecialidadServlet?esp=${esp.id }">
                		<div class="box">
                			<i class="fas fa-star-of-life"></i>
                			<h4 class="title">${esp.nombre }</h4>
                			<div class="separador-horizontal"></div>
                		</div>
               		</a>
            	</div>
			</c:forEach>
	         
	        <!-- / caja especialidad -->
        
        </div>

	</jsp:body>

</med:medicopagestemplate>
</shiro:hasRole>

<shiro:hasRole name="pas">
<pas:paspagestemplate>

	<jsp:attribute name="head">
		<title>Selecci�n Especialidad - DocApp</title>
	</jsp:attribute>

	<jsp:body>
	   
	    <div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom subemargen">
		        <h1>Selecci�n de Especialidad</h1>
		</div>
            <p>Elije la especialidad m�dica de tu cita.</p>
        <div class="row especialidades">
	    
	        <!-- caja especialidad -->
	        
	        <c:forEach items="${especialidades}" var="esp">
				<div class="col-lg-3 col-md-4">
	           		<a href="DoctoresEspecialidadServlet?esp=${esp.id }">
                		<div class="box">
                			<i class="fas fa-star-of-life"></i>
                			<h4 class="title">${esp.nombre }</h4>
                			<div class="separador-horizontal"></div>
                		</div>
               		</a>
            	</div>
			</c:forEach>
	         
	        <!-- / caja especialidad -->
        
        </div>

	</jsp:body>

</pas:paspagestemplate>

</shiro:hasRole>


