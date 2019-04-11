package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.grupo06.cita.dao.MedicoDAO;
import es.upm.dit.isst.grupo06.cita.dao.MedicoDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Medico;

@WebServlet("/FechaServlet")
public class FechaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idMedico = req.getParameter("medico");
		
		MedicoDAO meddao = MedicoDAOImplementation.getInstance();
		Medico medico = meddao.read(idMedico);

		req.getSession().setAttribute("medico", medico);

		getServletContext().getRequestDispatcher("/FechaView.jsp").forward(req, resp);
	}

}
