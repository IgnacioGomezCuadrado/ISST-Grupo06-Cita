<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


 
<t:pacientepagestemplate>

	<jsp:attribute name="head">
		<title>Elegir Especialidad - DocApp</title>
	</jsp:attribute>
	<jsp:body>
	   
	    
	    
	    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
		        <h1>Citas Pendientes</h1>
		</div>
            <p>Aquí se muestra un listado con tus citas pendientes.</p>
			<div class="table-responsive">
			  <table class="table table-striped table-sm">
				<thead class="bg-light">
				<tr>
				<th>Cita</th>
				<th>Médico</th>
				<th>Fecha</th>
				<th>Hora</th>
				<th colspan="2">Acciones</th>
				</tr>
				</thead>
				<tbody>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
			    <td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
			    <td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				<tr>
				<td>Ginecología</td>
				<td>Paco Jones</td>
				<td>22/04/2019</td>
				<td>11:30</td>
				<td><button type="button" class="btn btn-info acciones-paciente">Modificar</button></td>
				<td><button type="button" class="btn btn-info acciones-paciente">Cancelar</button></td>
				</tr>
				</tbody>
			</table>
		</div>
	</jsp:body>

</t:pacientepagestemplate>
   


