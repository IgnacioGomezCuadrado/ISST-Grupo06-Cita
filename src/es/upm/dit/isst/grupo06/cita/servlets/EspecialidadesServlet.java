package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.grupo06.cita.dao.EspecialidadDAO;
import es.upm.dit.isst.grupo06.cita.dao.EspecialidadDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Especialidad;

@WebServlet("/EspecialidadServlet")
public class EspecialidadesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//EspecialidadDAO espdao = EspecialidadDAOImplementation.getInstance();
		//Collection<Especialidad> especialidades = espdao.readAll();

		//req.getSession().setAttribute("especialidades", especialidades);

		getServletContext().getRequestDispatcher("/SeleccionEspecialidadPaciente.jsp").forward(req, resp);
	}

}
