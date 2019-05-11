package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

@WebServlet({ "/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(email, pass);
			try {
				currentUser.login(token);
				if (currentUser.hasRole("paciente")) {
					resp.sendRedirect(req.getContextPath() + "/PacienteServlet?id=" + currentUser.getPrincipal());
				} else if (currentUser.hasRole("medico")) {
					resp.sendRedirect(req.getContextPath() + "/MedicoServlet?id=" + currentUser.getPrincipal());
				} else if (currentUser.hasRole("pas")) {
					resp.sendRedirect(req.getContextPath() + "/PasServlet?id=" + currentUser.getPrincipal());
				}
			} catch (Exception e) {
				resp.sendRedirect(req.getContextPath() + "/LoginServlet");
			}
		} else
			resp.sendRedirect(req.getContextPath() + "/LoginServlet");
	}
}
