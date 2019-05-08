<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


	<!DOCTYPE html>
	<html lang="es" class="h-100">
		<t:headertemplate>
	   </t:headertemplate>
		   

	<body>

		<div class="row pt-5">
	      	<div class="col-sm-12 section-title">
	          	<h1 class="text-center my-auto">Búsqueda de citas</h1>
	      	</div>
	  	</div>
	  	
	  	<div class="card card-container">
	       <form class="form-signin" action="FormularioServlet" method="post">
	            
	             <div class="form-row mt-1 mb-2 pb-4 border-bottom">
	             <div class="col-sm-6">
	                <label for="nombrePaciente">Nombre Paciente</label>
	                <input type="text" name="nombrePaciente" id="inputNombrePaciente"
							class="form-control" placeholder="Introduce aquí el nombre del paciente" autofocus>
	             </div>
	             <div class="col-sm-6">
	                <label for="apellidosPaciente">Apellidos Paciente</label>
	                <input type="text" name="apellidosPaciente" id="inputApellidosPaciente"
							class="form-control" placeholder="Introduce aquí los apellidos del paciente" >
	             </div>
	           </div> <!-- /row -->
	           
	           <div class="form-row mt-1 mb-2 pb-4 border-bottom">
	             <div class="col-sm-6">
	                <label for="nombreMedico">Nombre Médico</label>
	                <input type="text" name="nombreMedico" id="inputNombreMedico"
							class="form-control" placeholder="Introduce aquí el nombre del médico">
	             </div>
	             <div class="col-sm-6">
	                <label for="apellidosMedico">Apellidos Médico</label>
	                <input type="text" name="apellidosMedico" id="inputApellidosMedico"
							class="form-control" placeholder="Introduce aquí los apellidos del médico" >
	             </div>
	           </div> <!-- /row -->
	           
	            <div class="form-row mt-1 mb-2 pb-4 border-bottom">
	             <div class="col-sm-6">
	                <label for="especialidad">Especialidad</label>
	                <select name="especialidad" id="especialidad" class="form-control">
        				<option value="" selected>Selecciona...</option>
        				<t:especialidades/>
                    </select>
                                      
	             </div>
	             <div class="col-sm-6">
	                <label for="fecha">Fecha</label>
	                <input type="date" name="fecha" id="inputFecha"
							class="form-control" placeholder="Fecha de consulta" required>
	             </div>
	           </div> <!-- /row -->
	           
	           
	            <div class="form-row mt-1 mb-2 pb-4 border-bottom">
	             <div class="col-sm-6">
	                <label for="consulta">Consulta</label>
	                <select name="consulta" id="consulta" class="form-control">
                    </select>
	             </div>
	           </div> <!-- /row -->
	           
	           <div class="row">
	               <div class="col-8 offset-2 col-sm-6 offset-sm-3">
	                 <button class="btn btn-lg btn-block btn-signin" type="submit">Buscar</button>
	               </div>
	           </div> <!-- /row -->
	             
	       </form>
					<!-- /form -->
		 </div>


	</body>
	
	          	    
			
		<t:footertemplate>
	    </t:footertemplate>     	
		
</html>			  
			  
			  
			  
