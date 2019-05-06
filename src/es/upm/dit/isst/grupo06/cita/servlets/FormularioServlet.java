package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.grupo06.cita.dao.CitaDAO;
import es.upm.dit.isst.grupo06.cita.dao.CitaDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.EspecialidadDAO;
import es.upm.dit.isst.grupo06.cita.dao.EspecialidadDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.MedicoDAO;
import es.upm.dit.isst.grupo06.cita.dao.MedicoDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAO;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Especialidad;
import es.upm.dit.isst.grupo06.cita.model.Medico;
import es.upm.dit.isst.grupo06.cita.model.Paciente;
import es.upm.dit.isst.grupo06.cita.model.Cita;

public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombrePaciente = req.getParameter("nombrePaciente");
		String apellidosPaciente = req.getParameter("apellidosPaciente");
		String nombreMedico = req.getParameter("nombreMedico");
		String apellidosMedico = req.getParameter("apellidosMedico");
		String especialidad = req.getParameter("especialidad");
		String fecha = req.getParameter("fecha");

		PacienteDAO pacdao = PacienteDAOImplementation.getInstance();
		Collection<Paciente> pac = pacdao.read(nombrePaciente,apellidosPaciente);
		
		MedicoDAO meddao = MedicoDAOImplementation.getInstance();
		Collection<Medico> med = meddao.read(nombreMedico,apellidosMedico);
		
		EspecialidadDAO espdao = EspecialidadDAOImplementation.getInstance();
		Especialidad esp = espdao.read(Integer.parseInt(especialidad));
		
		Date fech = null;
		
		try {
			fech = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		CitaDAO citdao = CitaDAOImplementation.getInstance();
		Collection<Cita> cit = citdao.getCitasFormulario(pac,med,esp,fech);
		
		req.getSession().setAttribute("citas", cit);
		
		getServletContext().getRequestDispatcher("/ListaCitasFormulario.jsp").forward(req, resp);
	}
}
