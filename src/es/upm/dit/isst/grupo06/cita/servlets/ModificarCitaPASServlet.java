package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.grupo06.cita.dao.CitaDAO;
import es.upm.dit.isst.grupo06.cita.dao.CitaDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAO;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Cita;
import es.upm.dit.isst.grupo06.cita.model.Paciente;

/**
 * Servlet implementation class BorrarCitaServlet
 */
@WebServlet("/ModificarCitaPASServlet")
public class ModificarCitaPASServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idCita = req.getParameter("cita");
		System.out.println(idCita);
		String idPaciente = req.getParameter("idPaciente");
		
// Pedimos la cita en la base de datos	
		CitaDAO citdao = CitaDAOImplementation.getInstance();
		Cita cita = citdao.read(Integer.parseInt(idCita));
		PacienteDAO pacientedao = PacienteDAOImplementation.getInstance();
		Paciente paciente = pacientedao.read(idPaciente);

		req.getSession().setAttribute("paciente", paciente);
		req.getSession().setAttribute("modificando", true);
		req.getSession().setAttribute("citaAModificar", cita);
		req.getSession().setAttribute("citaPAS", true);
	
		
		// Redirigimos al paciente a la pantalla inicial donde puede ver las citas
		resp.sendRedirect(req.getContextPath() + "/DoctoresEspecialidadServlet?esp=" + cita.getMedico().getEspecialidad().getId());
	}


}
