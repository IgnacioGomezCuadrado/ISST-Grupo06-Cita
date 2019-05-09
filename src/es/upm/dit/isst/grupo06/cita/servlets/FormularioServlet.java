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
import es.upm.dit.isst.grupo06.cita.model.Paciente;
import es.upm.dit.isst.grupo06.cita.model.Cita;
import es.upm.dit.isst.grupo06.cita.model.HorarioConsulta;

@WebServlet("/FormularioServlet")
public class FormularioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("en el dopost");
        //String nombrePaciente = req.getParameter("nombrePaciente");
        //String apellidosPaciente = req.getParameter("apellidosPaciente");
        String dni = req.getParameter("dni");
        //String nombreMedico = req.getParameter("nombreMedico");
        //String apellidosMedico = req.getParameter("apellidosMedico");
        String email = req.getParameter("email");
        //String especialidad = req.getParameter("especialidad");
        String fecha = req.getParameter("fecha");
        //String consulta = req.getParameter("consulta");

        PacienteDAO pacdao = PacienteDAOImplementation.getInstance();
        //Collection<Paciente> pac = pacdao.read(nombrePaciente,apellidosPaciente);
        Paciente pac = pacdao.read(dni);

        MedicoDAO meddao = MedicoDAOImplementation.getInstance();
        //Collection<Medico> med = meddao.read(nombreMedico,apellidosMedico);
        Medico med = meddao.read(email);

        ///EspecialidadDAO espdao = EspecialidadDAOImplementation.getInstance();
        //Especialidad esp = espdao.read(Integer.parseInt(especialidad));

        //HorarioConsultaDAO condao = HorarioConsultaDAOImplementation.getInstance();
        //HorarioConsulta con = condao.read(Integer.parseInt(consulta));

        Date fech = null;


        try {
            fech = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
        } catch (ParseException e) {

            e.printStackTrace();
        }

        CitaDAO citdao = CitaDAOImplementation.getInstance();
        Collection<Cita> cit = citdao.getCitasPAS(pac,med,fech);

        req.getSession().setAttribute("citas", cit);

        getServletContext().getRequestDispatcher("/ListaCitasFormulario.jsp").forward(req, resp);
    }
}