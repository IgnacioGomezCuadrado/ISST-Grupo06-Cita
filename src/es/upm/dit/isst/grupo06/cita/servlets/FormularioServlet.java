package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.grupo06.cita.dao.*;
import es.upm.dit.isst.grupo06.cita.model.Especialidad;
import es.upm.dit.isst.grupo06.cita.model.Medico;
import es.upm.dit.isst.grupo06.cita.model.PAS;
import es.upm.dit.isst.grupo06.cita.model.Paciente;
import es.upm.dit.isst.grupo06.cita.model.Cita;
import es.upm.dit.isst.grupo06.cita.model.HorarioConsulta;

@WebServlet("/FormularioServlet")
public class FormularioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pacEmail = req.getParameter("mailpaciente");

        String medEmail = req.getParameter("medico");

        String fecha = req.getParameter("fechacita");

        PacienteDAO pacdao = PacienteDAOImplementation.getInstance();
        Paciente pac = pacdao.read(pacEmail);

        MedicoDAO meddao = MedicoDAOImplementation.getInstance();
        Medico med = meddao.read(medEmail);

        Date fech = null;

        try {
            fech = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        } catch (ParseException e) {

            e.printStackTrace();
        }

        CitaDAO citdao = CitaDAOImplementation.getInstance();
        Collection<Cita> cit = citdao.getCitasPAS(pac,med,fech);

        req.getSession().setAttribute("citas", cit);
        PAS pas = (PAS) req.getSession().getAttribute("pas");
        
        getServletContext().getRequestDispatcher("/PasServlet?id=" + pas.getEmail() ).forward(req, resp);
    }
} 
