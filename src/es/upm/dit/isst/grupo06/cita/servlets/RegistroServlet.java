package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.grupo06.cita.dao.PacienteDAO;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Paciente;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String dni = req.getParameter("dni");
		String tlf = req.getParameter("telefono");
		String sociedad = req.getParameter("sociedad");
		String tarjeta = req.getParameter("tarjeta");

		Paciente pac = new Paciente();
		pac.setNombre(nombre);
		pac.setApellidos(apellidos);
		pac.setEmail(email);
		pac.setDni(dni);
		pac.setTelefono(Integer.parseInt(tlf));
		pac.setSociedadMedica(sociedad);
		pac.setTarjetaSanitaria(tarjeta);

		pac.setPassword(new Sha256Hash(password).toString());

		PacienteDAO pacdao = PacienteDAOImplementation.getInstance();
		pacdao.create(pac);

		resp.sendRedirect(req.getContextPath() + "/LoginServlet");
	}
}
