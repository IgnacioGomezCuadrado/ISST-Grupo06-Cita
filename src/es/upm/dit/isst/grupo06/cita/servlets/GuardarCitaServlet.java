package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import es.upm.dit.isst.grupo06.cita.model.Cita;


@WebServlet("/GuardarCitaServlet")
public class GuardarCitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idMedico = req.getParameter("medico");
		String horaStr = req.getParameter("hora");
		String fechaStr = req.getParameter("fecha");
		
		Subject currentUser = SecurityUtils.getSubject();
		String idPaciente = (String) currentUser.getPrincipal();
		
		Cita cita = new Cita();
		
		java.util.Date fechaU = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
		java.sql.Date fecha = new java.sql.Date(fechaU.getTime());
		cita.setFecha(fecha);
		
		java.util.Date horaU = new SimpleDateFormat("HH:mm").parse(horaStr);
		java.sql.Time hora = new Time(horaU.getTime());
		cita.setHora(hora);
		
		MedicoDAO meddao = MedicoDAOImplementation.getInstance();
		Medico medico = meddao.read(idMedico);
		cita.setMedico(medico);
		
		PacienteDAO pacdao = PacienteDAOImplementation.getInstance();
		Paciente paciente = meddao.read(idPaciente);
		cita.setPaciente(paciente);
		
		// Añadir consulta?
		
		CitaDAO citdao = CitaDAOImplementation.getInstance();
		citdao.create(cita);
		
		resp.sendRedirect(req.getContextPath() + "/PacienteServlet?id=" + idPaciente);
	}

}
