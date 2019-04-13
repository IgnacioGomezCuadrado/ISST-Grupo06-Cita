<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


 
<t:pacientepagestemplate>

	<jsp:attribute name="head">
		<title>Citas Pendientes - DocApp</title>
	</jsp:attribute>
	
	<jsp:body>
	   
	    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom subemargen">
		        <h1>Selecci�n de Especialidad</h1>
		</div>
            <p>Elije la especialidad m�dica deseada.</p>
        <div class="row">
	        
	        <!-- caja especialidad -->
	        <a href="../diagnostico-por-imagen">
	        <div class="col-md-3 text-center">
	            <div class="mz-module">
	                <div class="mz-module-about">
	                    <h3>Cardiolog�a</h3>
	                    <div class="separador-horizontal"></div>
	                </div>
	            </div>
	        </div>
	        </a>
	        <!-- / caja especialidad -->
        </div>

	</jsp:body>

</t:pacientepagestemplate>