package es.upm.dit.isst.grupo06.cita.servlets;

import java.io.IOException;
import java.text.Normalizer;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.grupo06.cita.dao.CitaDAO;
import es.upm.dit.isst.grupo06.cita.dao.CitaDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.EspecialidadDAO;
import es.upm.dit.isst.grupo06.cita.dao.EspecialidadDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.HorarioConsultaDAO;
import es.upm.dit.isst.grupo06.cita.dao.HorarioConsultaDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.MedicoDAO;
import es.upm.dit.isst.grupo06.cita.dao.MedicoDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.PASDAO;
import es.upm.dit.isst.grupo06.cita.dao.PASDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAO;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Especialidad;
import es.upm.dit.isst.grupo06.cita.model.Medico;
import es.upm.dit.isst.grupo06.cita.model.PAS;
import es.upm.dit.isst.grupo06.cita.model.Paciente;


@WebServlet("/CrearPersonalServlet")
public class CrearPersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Lleno base de datos con estos datos de prueba
		
		CitaDAO citadao = CitaDAOImplementation.getInstance();
		EspecialidadDAO espdao = EspecialidadDAOImplementation.getInstance();
		HorarioConsultaDAO hcdao = HorarioConsultaDAOImplementation.getInstance();
		MedicoDAO meddao = MedicoDAOImplementation.getInstance();
		PacienteDAO pdao = PacienteDAOImplementation.getInstance();
		PASDAO pasdao = PASDAOImplementation.getInstance();
		
		//Dejo las tablas limpias
		citadao.deleteAll();
		espdao.deleteAll();
		hcdao.deleteAll();
		meddao.deleteAll();
		pdao.deleteAll();
		pasdao.deleteAll();
		
		String especialidades[] = {"Alergología","Análisis Clínicos","Anatomía Patológica","Anestesiología y Reanimación","Cardiología",
				"Cardiología Pediátrica","Cirugía Cardíaca Pediátrica","Cirugía Cardiovascular","Cirugía General y del Aparato Digestivo","Cirugía Oral y Maxilofacial","Cirugía Pediátrica",
				"Cirugía Plástica y Reparadora","Cirugía Torácica","Cirugía Vascular y Angiología","Dermatología Médico-Quirúrgica y Venereología",
				"Electrofisiología Cardíaca","Endocrinología Pediátrica","Endocrinología y Nutrición","Enfermedades Infecciosas e Inmunodeficiencias","Gastroenterología - Aparato Digestivo",
				"Gastroenterología Pediátrica","Genética Clínica","Ginecología y Obstetricia","Hematología y Hemoterapia","Hematología y Oncología Pediátrica",
				"Hemodinámica Cardíaca","Inmunología","Logopedia","Medicina del Deporte","Medicina Estética y Unidad Láser","Medicina Familiar y Comunitaria",
				"Medicina Física y Rehabilitación","Medicina General","Medicina Intensiva","Medicina Interna","Medicina Nuclear","Medicina Preventiva","Nefrología",
				"Nefrología Pediátrica","Neumología","Neumología Pediátrica","Neurocirugía","Neurofisiología","Neurología","Neurología Pediátrica","Neuropsicología","Neurorradiología",
				"Nutrición","Odontología/Estomatología","Oftalmología","Oncología Médica","Oncología Radioterápica","Otorrinolaringología","Pediatría y Áreas Específicas Salud Infantil","Podología",
				"Psicología Clínica","Psiquiatría","Radiodiagnóstico - Diagnóstico por imagen","Radiología Pediátrica",
				"Radiologia Vascular e Intervencionista","Reumatología","Traumatología infantil","Traumatología y Cirugía Ortopédica","Unidad de broncoscopias",
				"Unidad del Dolor","Urología"};
		
		String nombres[] = {"Sofía", "Martina","Daniela","Valeria","Noa","Lucía","María", "Emma", "Julia", "Paula", "Alba", "Carla",
				"Alma", "Valentina", "Sara", "Carmen", "Claudia", "Elena", "Adriana", "Lola", "Vega", "Leyre", "Alejandra", "Candela",
				"Vera", "Olivia", "Laia", "Ana", "Jimena", "Triana", "Laura", "Aitana", "Irene", "Ariadna", "Marina" , "Victoria", "Alicia", "Carlota", "Ainara", "Marta",
				"Clara", "Lara" ,"Zoe", "Inés", "Rocío", "Andrea", "Ángela", "Blanca", "Ainhoa", "Nora", "Eva", "Natalia", "Elsa", "Nerea" , "Aina", "Gala", "África", "Celia",
				 "Iria", "Adara", "Ona", "Aroa", "Carolina", "Iris", "Gabriela", "Mara", "Isabella", "Cayetana" , "India", "Hugo", "Lucas", "Martín", "Mateo", "Daniel", "Alejandro", "Pablo", "Eric", "Leo" ,"Enzo",
				 "Adrián", "Álvaro", "Manuel", "Mario", "David", "Izan", "Oliver" ,"Marco", "Marcos", "Marc","Sergio", "Javier", "Luca", "Gonzalo", "Carlos", "Nicolás", "Iván", "Antonio", "Ángel",
				 "Miguel", "Héctor", "Gabriel", "Jorge", "Juan", "Rodrigo", "Jesús" ,"Samuel", "José", "Aarón", "Rubén", "Aitor", "Darío", "Alan", "Pau", "Joel" , "Alberto",
				 "Pol", "Jaime", "Nil",  "Francisco", "Luis" ,"Pedro" ,"Asier", "Saúl" ,"Aleix", "Unai", "Guillermo", "Santiago", "Víctor", "Alonso", "Raúl", "Andrés", "Gerard", "Jordi"};
		
		String apellidos[] = {"García","Rodríguez","González","Fernández","López","Martínez","Sánchez","Pérez","Gómez","Martín","Jiménez","Ruiz","Hernández","Díaz","Moreno",
				"Muñoz","Álvarez","Romero","Alonso","Gutiérrez","Navarro","Torres","Domínguez","Ramos","Vázquez","Gil","Serrano","Ramírez","Blanco","Molina","Morales","Ortega",
				"Suárez","Delgado","Castro","Ortiz","Rubio","Marín","Sanz","Iglesias","Medina","Núñez","Garrido","Castillo","Cortés","Lozano","Guerrero","Santos","Cano",
				"Prieto","Calvo","Vidal","Méndez","Cruz","Gallego","Herrera","Cabrera","Peña","Flores","León","Márquez","Campos","Vega","Fuentes","Carrasco","Díez","Caballero",
				"Nieto","Pascual","Reyes","Aguilar","Herrero","Santana","Ferrer","Lorenzo","Hidalgo","Montero","Giménez","Ibáñez","Mora","Vicente","Santiago","Durán","Arias",
				"Vargas","Benítez","Carmona","Crespo","Pastor","Soto","Soler","Velasco","Roman","Sáez","Moya","Esteban","Parra","Bravo","Gallardo","Pardo","Rojas","Merino",
				"Franco","Espinosa","Lara","Izquierdo","Rivas","Rivera","Casado","Arroyo","Redondo","Camacho","Rey","Segura","Luque","Sierra","Silva","Montes","Otero","Carrillo",
				"Marcos","Galan","Ríos","Soriano","Marti","Mendoza","Vila","Valero","Robles","Palacios","Benito","Guerra","Varela","Mateo","Bueno","Expósito","Macías","Villar",
				"Roldán","Miranda","Mateos","Escudero","Pereira","Guillén","Casas","Aguilera","Rivero","Gracia","Padilla","Abad","Beltrán","Menéndez","Salas","Quintana","Conde",
				"Roca","Estévez","Jurado","Acosta","Plaza","Serra","Aranda","Aparicio","Salazar","Guzmán","Cuesta","Villanueva","Pons","Blázquez","Hurtado","Rueda","Pacheco","Ávila",
				"Mesa","Blasco","Escobar","Lázaro","Salvador"};
		
		
		
		//Creacion de especialidades y 3  medicos por especialidad
		for(String esp:especialidades) {
			Especialidad e = new Especialidad();
			e.setNombre(esp);
			espdao.create(e);
			for(int i = 0;i<3; i++) {	
				int x = (int)(Math.random()*((nombres.length-1)));
				String chosen_name = nombres[x];
				x = (int)(Math.random()*((apellidos.length-1)));
				String sur1 = apellidos[x];
				x = (int)(Math.random()*((apellidos.length-1)));
				String sur2 = apellidos[x];
				
				Medico m = new Medico();
				m.setNombre(chosen_name);
				m.setApellidos(sur1+" "+sur2);
				m.setEspecialidad(e);
				String s = Normalizer.normalize(chosen_name.toLowerCase()+"."+sur1.toLowerCase()+"."+sur2.toLowerCase()+"@medicos.hospital.es", Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
				m.setEmail(s);
				m.setPassword(new Sha256Hash("1234").toString()); //la contraseña es 1234 para todos
				meddao.create(m);
				
			}
			
		}
		
		//Creacion de pacientes
		for(int i = 0;i<20; i++) {
			int x = (int)(Math.random()*((nombres.length-1)));
			String chosen_name = nombres[x];
			x = (int)(Math.random()*((apellidos.length-1)));
			String sur1 = apellidos[x];
			x = (int)(Math.random()*((apellidos.length-1)));
			String sur2 = apellidos[x];
			
			Paciente pat = new Paciente();
			
			pat.setNombre(chosen_name);
			pat.setApellidos(sur1+" "+sur2);
			
			String s = Normalizer.normalize(chosen_name.toLowerCase()+"."+sur1.toLowerCase()+"."+sur2.toLowerCase()+"@gmail.com", Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
			pat.setEmail(s);
			
			pat.setPassword(new Sha256Hash("1234").toString());
			
			x = (int)(Math.random()*(90000000)+10000000);
			String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			Random rnd = new Random();
			char letter = abc.charAt(rnd.nextInt(abc.length()));
			String pref = Integer.toString(x);
			pat.setDni(pref+letter);
			
			String beg ="6";
			x = (int)(Math.random()*(90000000)+10000000);
			int tlf = Integer.parseInt(beg+Integer.toString(x));
			pat.setTelefono(tlf);
			
			pat.setSociedadMedica("SANITAS");
			x = (int)(Math.random()*(900000)+100000); 
			pat.setTarjetaSanitaria(Integer.toString(x));
			
			pdao.create(pat);
			
			
		}
		
		//Creacion de algunos PAS
		for(int i = 0;i<5; i++) {
			int x = (int)(Math.random()*((nombres.length-1)));
			String chosen_name = nombres[x];
			x = (int)(Math.random()*((apellidos.length-1)));
			String sur1 = apellidos[x];
			x = (int)(Math.random()*((apellidos.length-1)));
			String sur2 = apellidos[x];
			
			PAS p = new PAS();
			p.setNombre(chosen_name);
			p.setApellidos(sur1+" "+sur2);
			
			String s = Normalizer.normalize(chosen_name.toLowerCase()+"."+sur1.toLowerCase()+"."+sur2.toLowerCase()+"@pas.hospital.es", Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
			p.setEmail(s);
			
			p.setPassword(new Sha256Hash("1234").toString());
			pasdao.create(p);

		}

		/*String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		
		int val = Integer.parseInt(req.getParameter("personaltype"));
		if (val == 0) {
			Medico med = new Medico();
			med.setNombre(nombre);
			med.setApellidos(apellidos);
			med.setEmail(email);

			med.setPassword(new Sha256Hash(password).toString());

			
			meddao.create(med);
		}
		else if (val == 1){
			PAS pas = new PAS();
			pas.setNombre(nombre);
			pas.setApellidos(apellidos);
			pas.setEmail(email);
			pas.setPassword(new Sha256Hash(password).toString());

			PASDAO pasdao = PASDAOImplementation.getInstance();
			pasdao.create(pas);
		} */
		
		resp.sendRedirect(req.getContextPath() + "/LoginServlet");
	}
}
