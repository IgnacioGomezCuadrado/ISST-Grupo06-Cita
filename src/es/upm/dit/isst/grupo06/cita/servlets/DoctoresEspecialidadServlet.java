package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.grupo06.cita.dao.EspecialidadDAO;
import es.upm.dit.isst.grupo06.cita.dao.EspecialidadDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Especialidad;

@WebServlet("/DoctoresEspecialidadServlet")
public class DoctoresEspecialidadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idEsp = req.getParameter("esp");
		EspecialidadDAO espdao = EspecialidadDAOImplementation.getInstance();
		Especialidad especialidad = espdao.read(Integer.parseInt(idEsp));

		req.getSession().setAttribute("especialidad", especialidad);

		getServletContext().getRequestDispatcher("/SeleccionDoctorCita.jsp").forward(req, resp);
	}

}
