package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.PacienteDAO;
import es.upm.dit.isst.webLab.dao.PacienteDAOImplementation;
import es.upm.dit.isst.webLab.model.Paciente;

@WebServlet ("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String dni = req.getParameter("dni");
        String passwordActual = req.getParameter("passwordActual");
        String passwordNueva = req.getParameter("passwordNueva");
        String passwordNuevaRep = req.getParameter("passwordNuevaRep");

        //Actualizar ddbb

      
}

}
