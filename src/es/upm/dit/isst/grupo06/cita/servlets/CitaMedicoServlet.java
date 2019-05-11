package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.grupo06.cita.dao.MedicoDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.MedicoDAO;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAO;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Medico;
import es.upm.dit.isst.grupo06.cita.model.Paciente;

@WebServlet("/CitaMedicoServlet")
public class CitaMedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idMedico = req.getParameter("idMedico");
		String idPaciente = req.getParameter("idPaciente");
		
		PacienteDAO pacientedao = PacienteDAOImplementation.getInstance();
		Paciente paciente = pacientedao.read(idPaciente);
		
		MedicoDAO medicodao = MedicoDAOImplementation.getInstance();
		Medico medico = medicodao.read(idMedico);

		req.getSession().setAttribute("paciente", paciente);
		req.getSession().setAttribute("medico", medico);
		req.getSession().setAttribute("citamedico", true);
		
		getServletContext().getRequestDispatcher("/SeleccionFechaCita.jsp").forward(req, resp);
	}
	
}
