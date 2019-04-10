package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PacienteServlet")
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		PacienteDAO pacientedao = PacienteDAOImplementation.getInstance();
		Paciente paciente = pacientedao.read(id);

		req.getSession().setAttribute("paciente", paciente);

		getServletContext().getRequestDispatcher("/PacienteView.jsp").forward(req, resp);
	}

}
