package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.grupo06.cita.dao.CitaDAO;
import es.upm.dit.isst.grupo06.cita.dao.CitaDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Cita;
import es.upm.dit.isst.grupo06.cita.model.Medico;

/**
 * Servlet implementation class HorarioServlet
 */
@WebServlet("/HorarioServlet")
public class HorarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fechaStr = req.getParameter("fecha");
		
		// Establecemos la fecha elegida como atributo de la sesión
		req.getSession().setAttribute("fechaStr", fechaStr);

		// Recuperamos el medico elegido
		Medico medico = (Medico) req.getSession().getAttribute("medico");

		// Creamos un objeto fecha con el string pasado como parámetro
		Date fecha = null;
		try {
			// Independientemente de lo que muestre el navegador, el input date
			// siempre tiene este formato
			fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// Establecemos la fecha elegida como atributo de la sesión
		req.getSession().setAttribute("fecha", fecha);
		
		// Sacamos el día de la semana (L,M,X...) que es la fecha elegida
//		Calendar c = Calendar.getInstance();
//		c.setTime(fecha);
//		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK); // 1: Domingo ... 7:Sabado

		// Sacamos la collection de horarios del medico (uno por cada día de la semana)
//		Collection<HorarioConsulta> horariosConsulta = medico.getHorarioConsulta();

		// Buscamos el horario correspondiente al día de la semana de la fecha elegida
		// Ej: Si esa fecha cae en lunes, buscamos el horario de los lunes del medico
//		HorarioConsulta horMedDiaElegido = null;
//		for (HorarioConsulta horCon : horariosConsulta) {
//			if (horCon.getDiaSemana() == dayOfWeek) {
//				horMedDiaElegido = horCon;
//			}
//		}

		/*
		 * Diccionario clave-valor con el horario general de citas. Clave (String): la
		 * hora de la cita. Valor (Boolean): true si ya hay una cita a esa hora. false
		 * si está libre.
		 */
		Map<String, Boolean> horasCitas = new LinkedHashMap<String, Boolean>();
		horasCitas.put("08:00", false);
		horasCitas.put("08:30", false);
		horasCitas.put("09:00", false);
		horasCitas.put("09:30", false);
		horasCitas.put("10:00", false);
		horasCitas.put("10:30", false);
		horasCitas.put("11:00", false);
		horasCitas.put("11:30", false);
		horasCitas.put("12:00", false);
		horasCitas.put("12:30", false);
		horasCitas.put("13:00", false);
		horasCitas.put("13:30", false);
		horasCitas.put("14:00", false);

//		Time hora = horMedDiaElegido.getHoraComienzoM(); // Hora inicial
//		c.setTime(hora);
//		int duracionCita = 30; // Duración de las citas en minutos
//
//		while (c.getTime() < horMedDiaElegido.getHoraFinM()) { // Mientras no llegue la hora final
//			String horaStr = formatoHora.format(hora.getTime());
//			horasCitas.put(horaStr, false); // Añadimos la hora como vacía
//			c.add(Calendar.MINUTE, duracionCita); // Y sumamos la duración de la cita
//		}

		// Sacamos las citas del medico ese día
		CitaDAO citadao = CitaDAOImplementation.getInstance();
		Collection<Cita> citasMedico = citadao.getCitasDelDia(medico, fecha);

		// Formato para pasar de Time a un String tipo HH:mm
		DateFormat formatoHora = new SimpleDateFormat("HH:mm");

		// Marcamos las horas en las que ya hay cita como ocupadas
		for (Cita cita : citasMedico) {
			System.out.println(cita);
			horasCitas.put(formatoHora.format(cita.getHora().getTime()), true);
		}

		// Pasamos el horario a la vista
		req.getSession().setAttribute("horario", horasCitas);

		getServletContext().getRequestDispatcher("/SeleccionHoraPaciente.jsp").forward(req, resp);
	}

}
