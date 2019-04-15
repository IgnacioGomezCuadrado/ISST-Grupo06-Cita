package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.grupo06.cita.dao.CitaDAO;
import es.upm.dit.isst.grupo06.cita.dao.CitaDAOImplementation;

import es.upm.dit.isst.grupo06.cita.model.Cita;
import es.upm.dit.isst.grupo06.cita.model.Medico;
import es.upm.dit.isst.grupo06.cita.model.Paciente;

@WebServlet("/GuardarCitaServlet")
public class GuardarCitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String horaStr = req.getParameter("hora");

		// Creamos un objeto cita
		Cita cita = new Cita();
		
		// Recuperamos el objeto paciente de la sesión y lo añadimos a la cita
		Paciente paciente = (Paciente) req.getSession().getAttribute("paciente");
		cita.setPaciente(paciente);
		
		// Recuperamos el objeto medico de la sesión y lo añadimos a la cita
		Medico medico = (Medico) req.getSession().getAttribute("medico");
		cita.setMedico(medico);
		
		// Recuperamos el objeto fecha de la sesión
		Date fecha = (Date) req.getSession().getAttribute("fecha");
		// Creamos un objeto sql.Date (para que concuerde con el tipo del modelo)
		java.sql.Date fechaSql = new java.sql.Date(fecha.getTime());
		cita.setFecha(fechaSql); // y lo añadimos a la cita
		
		// Creamos una fecha a partir del string recibido como parámetro
		Date hora = null;
		try {
			hora = new SimpleDateFormat("HH:mm").parse(horaStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Creamos un objeto sql.Time (para que concuerde con el tipo del modelo) a
		// partir del util.Date parseado anteriormente
		java.sql.Time horaSql = new Time(hora.getTime());
		cita.setHora(horaSql);
		
		// Añadir consulta?
		
		// Creamos la cita en la base de datos
		CitaDAO citdao = CitaDAOImplementation.getInstance();
		citdao.create(cita);
		
		// Redirigimos al paciente a la pantalla inicial donde puede ver las citas
		resp.sendRedirect(req.getContextPath() + "/PacienteServlet?id=" + paciente.getEmail());
	}

}
