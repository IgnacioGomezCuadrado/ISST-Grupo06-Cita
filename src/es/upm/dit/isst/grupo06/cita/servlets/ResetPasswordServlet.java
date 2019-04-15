package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.grupo06.cita.dao.PacienteDAO;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Paciente;

@WebServlet ("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String dni = req.getParameter("dni");
        String passwordActual = req.getParameter("passwordActual");
        String passwordNueva = req.getParameter("passwordNueva");
        String passwordNuevaRep = req.getParameter("passwordNuevaRep");

        //Actualizar ddbb
        
        PacienteDAO dao = PacienteDAOImplementation.getInstance();
        Paciente paciente = dao.read(dni);

        if (dni.equals(paciente.getDni()) && passwordActual.equals(paciente.getPassword())){

            if(passwordNueva.equals(passwordNuevaRep)) {
                paciente.setPassword(passwordNueva);
                dao.update(paciente);
                System.out.println("ContraseÃ±a cambiada con Ã©xito");
                resp.sendRedirect(req.getContextPath() + "/LoginView.jsp");
                //Notificacion mediante correo
            }else {
             System.out.println("Las contraseÃ±as nuevas no coinciden");
                resp.sendRedirect(req.getContextPath());
            }
        } else{
            System.out.println("Usuario o contraseÃ±a incorrectos");
            resp.sendRedirect(req.getContextPath());
        }
    }
}


      

