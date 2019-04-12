<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:loginpagetemplate>
    
	<jsp:attribute name="head">
		<title>Login - DocApp</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
	</jsp:attribute>
	
    <jsp:body>
    
		<shiro:user>
	    Welcome back <shiro:principal />! Click <a href="LogoutServlet">here</a> to logout.
		</shiro:user>
		
		<shiro:guest>
		 
		<div class="row pt-5">
        	<div class="col-sm-12 section-title">
            	<h1 class="text-center my-auto">Acceso</h1>
        	</div>
    	</div>
    	
    	<div class="card card-container">
	        <form class="form-signin" action="LoginServlet" method="post">
	            <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Dirección email" required autofocus>
	            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Contraseña" required>
	            <button class="btn btn-lg btn-block btn-signin" type="submit">&nbsp Entrar</button>
	        </form><!-- /form -->
	        <a href="#" class="sign-up text-center">Registrarse en la plataforma</a>
	        <a href="#" class="forgot-password text-center">¿Olvidó la Contraseña?</a>
	         
    	</div>
			
		</shiro:guest>
	
	</jsp:body>
	
</t:loginpagetemplate>	




