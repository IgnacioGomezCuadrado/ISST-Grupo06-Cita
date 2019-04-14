package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import es.upm.dit.isst.grupo06.cita.dao.CitaDAO;
import es.upm.dit.isst.grupo06.cita.dao.CitaDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.MedicoDAO;
import es.upm.dit.isst.grupo06.cita.dao.MedicoDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAO;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Cita;
import es.upm.dit.isst.grupo06.cita.model.Medico;
import es.upm.dit.isst.grupo06.cita.model.Paciente;

@WebServlet("/GuardarCitaServlet")
public class GuardarCitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idMedico = req.getParameter("medico");
		String horaStr = req.getParameter("hora");
		String fechaStr = req.getParameter("fecha");

		// Obtenemos la id del paciente logueado
		Subject currentUser = SecurityUtils.getSubject();
		String idPaciente = (String) currentUser.getPrincipal();

		// Creamos un objeto cita
		Cita cita = new Cita();

		// Creamos una fecha a partir del string recibido como parámetro
		java.util.Date fechaU = null;
		try {
			fechaU = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Creamos un objeto sql.Date (para que concuerde con el tipo del modelo) a
		// partir del util.Date parseado anteriormente
		java.sql.Date fecha = new java.sql.Date(fechaU.getTime());
		cita.setFecha(fecha);
		
		// Creamos una fecha a partir del string recibido como parámetro
		java.util.Date horaU = null;
		try {
			horaU = new SimpleDateFormat("HH:mm").parse(horaStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Creamos un objeto sql.Time (para que concuerde con el tipo del modelo) a
		// partir del util.Date parseado anteriormente
		java.sql.Time hora = new Time(horaU.getTime());
		cita.setHora(hora);
		
		// Buscamos el médico elegido y lo añadimos a la cita
		MedicoDAO meddao = MedicoDAOImplementation.getInstance();
		Medico medico = meddao.read(idMedico);
		cita.setMedico(medico);
		
		// Buscamos el paciente que está pidiendo la cita y lo añadimos
		PacienteDAO pacdao = PacienteDAOImplementation.getInstance();
		Paciente paciente = pacdao.read(idPaciente);
		cita.setPaciente(paciente);

		// Añadir consulta?
		
		// Creamos la cita en la base de datos
		CitaDAO citdao = CitaDAOImplementation.getInstance();
		citdao.create(cita);
		
		// Redirigimos al paciente a la pantalla inicial donde puede ver las citas
		resp.sendRedirect(req.getContextPath() + "/PacienteServlet?id=" + idPaciente);
	}

}
