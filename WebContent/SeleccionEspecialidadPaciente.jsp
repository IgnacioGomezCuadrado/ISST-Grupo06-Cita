<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>



<t:pacientepagestemplate>

	<jsp:attribute name="head">
		<title>Selección Especialidad - DocApp</title>
	</jsp:attribute>

	<jsp:body>
	   
	    <div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom subemargen">
		        <h1>Selección de Especialidad</h1>
		</div>
            <p>Elije la especialidad médica de tu cita.</p>
        <div class="row especialidades">
	    
	        <!-- caja especialidad -->
	        
	        <c:forEach items="${especialidades}" var="esp">
				<div class="col-lg-3 col-md-4">
	           		<a href="DoctoresEspecialidadServlet?esp=${esp.id }">
                		<div class="box">
                			<div class="img-especialidad">
								<img class="img-fluid" src="${pageContext.request.contextPath}/images/especialidades/cardiologia.jpg">
							</div>
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