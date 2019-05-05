<%@tag description="DocApp Page Template" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="head" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="scripts" fragment="true" %>

 <shiro:guest> 
  <c:redirect url = "/"/>
 </shiro:guest> 


  <shiro:user>
	<!DOCTYPE html>
	<html lang="es" class="h-100">
	   <head>
		  <meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		  <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
		  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
		  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pacientes.css" />
		  <jsp:invoke fragment="head"/>
	   </head>
		
	   <body class="d-flex flex-column h-100">
		   <t:headertemplate>
		      <jsp:invoke fragment="header"/>
		   </t:headertemplate>
		  
	   <div class="container-fluid">
	      <div class="row">
		    <t:usersidebar/>
		    <main role="main" class="col-9 col-sm-9 col-md-9 ml-sm-auto col-lg-10 flex-shrink-0">
			   <jsp:doBody/>   
		    </main>
		  </div> <!-- </row> -->
	  </div> 
		    
			
		<t:footertemplate>
		  <jsp:invoke fragment="footer"/>
	    </t:footertemplate>     	
		
		<!-- JS -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>	
	    <jsp:invoke fragment="scripts"/>
	    <script src="${pageContext.request.contextPath}/js/theme_js.js"></script>
	  </body>
</html>			  
			  
			  
			  	  
</shiro:user>
