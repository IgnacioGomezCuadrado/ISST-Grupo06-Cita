<%@tag description="User Status Bar" pageEncoding="UTF-8"%>

    <nav class="col-3 col-sm-3 col-md-3 col-lg-2  d-sm-block sidebar">
      <div class="sidebar-sticky">
      <h6 class="sidebar-type text-center pb-1 text-muted border-bottom">
          <i>SOPORTE ADMINISTRATIVO</i>
      </h6>
        
       <h6 id="bienvenida" class="text-center">Hola, ${pas.nombre} </h6>
       <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          GESTÓN CITAS DE PACIENTES
        </h6>
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" href="PacienteServlet?id=${paciente.email}">
             <i class="fas fa-search mr-2"></i>
              Buscar citas <span class="sr-only">(current)</span>
            </a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="#">
              <i class="fas fa-plus mr-2"></i>
              Nueva cita para paciente
            </a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="#">
              <i class="fas fa-ambulance mr-2"></i>
              Agendar cita urgente
            </a>
          </li>
         </ul>

         <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          CONFIGURACIÓN
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a id="passwordchange"class="nav-link" href="#">
              <i class="fas fa-lock mr-2"></i>
              Cambiar Contraseña
            </a>
          </li>
          <li class="nav-item">
            <a id="logout"class="nav-link" href="LogoutServlet">
              <i class="fas fa-sign-out-alt mr-2"></i>
              Cerrar sesión
            </a>
          </li>
        </ul>
        
      </div>
    </nav>