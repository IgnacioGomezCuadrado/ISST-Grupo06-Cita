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

@WebServlet("/MedicoServlet")
public class MedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		MedicoDAO meddao = MedicoDAOImplementation.getInstance();
		Medico medico = meddao.read(id);

		req.getSession().setAttribute("medicomismo", medico);

		getServletContext().getRequestDispatcher("/ListaCitasMedico.jsp").forward(req, resp);
	}

}
