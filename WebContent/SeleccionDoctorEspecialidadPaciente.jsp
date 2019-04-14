<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


 
<t:pacientepagestemplate>

	<jsp:attribute name="head">
		<title>Selección Doctor - DocApp</title>
	</jsp:attribute>
	
	<jsp:body>
	   
	    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom subemargen">
		        <h1>Selección de Doctor</h1>
		</div>
		    <h2 class="text-center">ESPECIALIDAD SELECCIONADA</h2> <%--Este título debe de ser el nombre de la especialidad elegida, hay que
		    pasar el parámetro --%>
            <p>Haz click en los doctores para comprobar su disponibilidad.</p>
        <div class="row doctores">
	    
	        <!-- caja doctores -->
	         
	         <div class="col-lg-3 col-md-4">
	           <a href="#">
                      <div class="box">
                          <i class="fas fa-user-md"></i>
                          <h4 class="title">Dr. Mengueche</h4>
                          <div class="separador-horizontal"></div>
                      </div>
               </a>
             </div>
            
            <div class="col-lg-3 col-md-4">
	           <a href="#">
                      <div class="box">
                          <i class="fas fa-user-md"></i>
                          <h4 class="title">Dr. Mengueche</h4>
                          <div class="separador-horizontal"></div>
                      </div>
               </a>
             </div>
             <div class="col-lg-3 col-md-4">
	           <a href="#">
                      <div class="box">
                          <i class="fas fa-user-md"></i>
                          <h4 class="title">Dr. Mengueche</h4>
                          <div class="separador-horizontal"></div>
                      </div>
               </a>
             </div>
             <div class="col-lg-3 col-md-4">
	           <a href="#">
                      <div class="box">
                          <i class="fas fa-user-md"></i>
                          <h4 class="title">Dr. Mengueche</h4>
                          <div class="separador-horizontal"></div>
                      </div>
               </a>
             </div>
             <div class="col-lg-3 col-md-4">
	           <a href="#">
                      <div class="box">
                          <i class="fas fa-user-md"></i>
                          <h4 class="title">Dr. Mengueche</h4>
                          <div class="separador-horizontal"></div>
                      </div>
               </a>
             </div>
             <div class="col-lg-3 col-md-4">
	           <a href="#">
                      <div class="box">
                          <i class="fas fa-user-md"></i>
                          <h4 class="title">Dr. Mengueche</h4>
                          <div class="separador-horizontal"></div>
                      </div>
               </a>
             </div>
             <div class="col-lg-3 col-md-4">
	           <a href="#">
                      <div class="box">
                          <i class="fas fa-user-md"></i>
                          <h4 class="title">Dr. Mengueche</h4>
                          <div class="separador-horizontal"></div>
                      </div>
               </a>
             </div>
             <div class="col-lg-3 col-md-4">
	           <a href="#">
                      <div class="box">
                          <i class="fas fa-user-md"></i>
                          <h4 class="title">Dr. Mengueche</h4>
                          <div class="separador-horizontal"></div>
                      </div>
               </a>
             </div>
	        <!-- / caja doctores -->
        
        
        </div>

	</jsp:body>

</t:pacientepagestemplate>