package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.upm.dit.isst.grupo06.cita.model.Medico;
import es.upm.dit.isst.grupo06.cita.model.PAS;
import es.upm.dit.isst.grupo06.cita.dao.MedicoDAO;
import es.upm.dit.isst.grupo06.cita.dao.MedicoDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.PASDAO;
import es.upm.dit.isst.grupo06.cita.dao.PASDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Paciente;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAO;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAOImplementation;



//import es.upm.dit.isst.grupo06.cita.model.PAS;
//import es.upm.dit.isst.grupo06.cita.dao.PASDAO;
//import es.upm.dit.isst.grupo06.cita.dao.PASDAOImplementation;



@WebServlet({"/PasServlet"})
public class PasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		PASDAO pasdao = PASDAOImplementation.getInstance();
		PAS pas = pasdao.read(id);
		req.getSession().setAttribute("pas", pas);
		
		//Lista de pacientes en JSON, lo necesita asi el plugin de autocompletar
		PacienteDAO pdao = PacienteDAOImplementation.getInstance();
		Collection<Paciente> pacientes = pdao.readAll();
		ArrayList<JsonObject> pacientesobj = new ArrayList<JsonObject>();
		for(Paciente p:pacientes) {
			String namepac = p.getNombre() +" "+ p.getApellidos() +" - "+p.getDni();
			String emailpac = p.getEmail();
			 JsonObject jsonobject = Json.createObjectBuilder()
				     .add("value", namepac)
				     .add("data", emailpac)
				     .build();
			 pacientesobj.add(jsonobject);	
		}
		req.getSession().setAttribute("pacientes", pacientesobj);
		
		//Lista de medicos
		MedicoDAO meddao = MedicoDAOImplementation.getInstance();
		Collection<Medico> medicos = meddao.readAll();
		req.getSession().setAttribute("medicos", medicos);
		
		System.out.println(pas);
		System.out.println(id);
		
		getServletContext().getRequestDispatcher("/PASView.jsp").forward(req, resp);
	}

}
