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



/**
 * Servlet implementation class NuevaCitaPasServlet
 */
@WebServlet("/NuevaCitaPasServlet")
public class NuevaCitaPasServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		getServletContext().getRequestDispatcher("/CitaPacientePas.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String idPaciente = req.getParameter("mailpaciente");
		PacienteDAO pacdao = PacienteDAOImplementation.getInstance();
		Paciente pac = pacdao.read(idPaciente);
		req.getSession().setAttribute("paciente", pac);
		req.getSession().setAttribute("nuevaCitaPAS", true);
		
		resp.sendRedirect(req.getContextPath() + "/EspecialidadesServlet");
	}


}
