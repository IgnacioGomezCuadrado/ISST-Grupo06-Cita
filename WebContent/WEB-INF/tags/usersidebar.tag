<%@tag description="User Status Bar" pageEncoding="UTF-8"%>

    <nav class="col-3 col-sm-3 col-md-3 col-lg-2  d-sm-block sidebar">
      <div class="sidebar-sticky">
       <h6 id="bienvenida" class="text-center">Hola, Nombre</h6>
       <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          CITAS MÉDICAS
        </h6>
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" href="#">
             <i class="far fa-clock mr-2"></i>
              Citas Pendientes <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="EspecialidadServlet">
             <i class="fas fa-plus-circle mr-2"></i>
              Pedir Nueva Cita
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <i class="far fa-file mr-2"></i>
              Historial de Citas
            </a>
          </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          INFORMACIÓN DE CUENTA
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a class="nav-link" href="#">
           <i class="fas fa-user mr-2"></i>
              Datos Personales
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
        </ul>
        
      </div>
    </nav>