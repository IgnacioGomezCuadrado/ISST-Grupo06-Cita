<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/pas" %>


 
<t:paspagestemplate>

	<jsp:attribute name="head">
		<title>Buscador de Pacientes - DocApp</title>
	</jsp:attribute>
	
	<jsp:attribute name="scripts">
		<script src="${pageContext.request.contextPath}/js/jquery.autocomplete.js"></script>
		<script>
		var patients = ${pacientes};
		$('#inputPaciente').devbridgeAutocomplete({
		    lookup: patients,
		    onSelect: function (suggestion) {
		       document.getElementById("mailPaciente").value = suggestion.data;
		      // console.log('You selected: ' + suggestion.value + ', ' + suggestion.data);
		    }
		});
			var today = new Date().toISOString().split('T')[0];
			document.getElementsByName("fechacita")[0].setAttribute('min', today);
		</script>
	</jsp:attribute>
		
	
	<jsp:body>
	   
	    
	    
	    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
		        <h1 class="pacientestitle">Selección de paciente</h1>
		</div>
            <p>Selecciona al paciente:</p>
		
		<div class="card w-50">
		  <div class="card-body">
	       <form class="form-signin" action="NuevaCitaPasServlet" method="post">
	            
	            <div class="form-row mt-1 mb-2 pb-4 border-bottom">
	             <div class="col-sm-6">
	                <label for="nombre">Paciente</label>
	                <input type="text" name="paciente" id="inputPaciente"
							class="form-control" placeholder="Nombre y apellidos" autocomplete="off" autofocus>
							<input type="hidden" name="mailpaciente" id="mailPaciente" value="">
	             </div>
	              <div class="col-sm-6 align-self-center">
	                <button class="btn btn-block btn-signin" type="submit">Seleccionar Paciente</button>
	              </div>
	             </div> <!-- /row -->
	                   
	       </form>
					<!-- /form -->
		 </div>
	  </div>
	  

		
	</jsp:body>

</t:paspagestemplate>
   