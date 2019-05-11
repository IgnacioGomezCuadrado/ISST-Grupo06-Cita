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
		
		String especialidades[] = {"Alergolog�a","An�lisis Cl�nicos","Anatom�a Patol�gica","Anestesiolog�a y Reanimaci�n","Cardiolog�a",
				"Cardiolog�a Pedi�trica","Cirug�a Card�aca Pedi�trica","Cirug�a Cardiovascular","Cirug�a General y del Aparato Digestivo","Cirug�a Oral y Maxilofacial","Cirug�a Pedi�trica",
				"Cirug�a Pl�stica y Reparadora","Cirug�a Tor�cica","Cirug�a Vascular y Angiolog�a","Dermatolog�a M�dico-Quir�rgica y Venereolog�a",
				"Electrofisiolog�a Card�aca","Endocrinolog�a Pedi�trica","Endocrinolog�a y Nutrici�n","Enfermedades Infecciosas e Inmunodeficiencias","Gastroenterolog�a - Aparato Digestivo",
				"Gastroenterolog�a Pedi�trica","Gen�tica Cl�nica","Ginecolog�a y Obstetricia","Hematolog�a y Hemoterapia","Hematolog�a y Oncolog�a Pedi�trica",
				"Hemodin�mica Card�aca","Inmunolog�a","Logopedia","Medicina del Deporte","Medicina Est�tica y Unidad L�ser","Medicina Familiar y Comunitaria",
				"Medicina F�sica y Rehabilitaci�n","Medicina General","Medicina Intensiva","Medicina Interna","Medicina Nuclear","Medicina Preventiva","Nefrolog�a",
				"Nefrolog�a Pedi�trica","Neumolog�a","Neumolog�a Pedi�trica","Neurocirug�a","Neurofisiolog�a","Neurolog�a","Neurolog�a Pedi�trica","Neuropsicolog�a","Neurorradiolog�a",
				"Nutrici�n","Odontolog�a/Estomatolog�a","Oftalmolog�a","Oncolog�a M�dica","Oncolog�a Radioter�pica","Otorrinolaringolog�a","Pediatr�a y �reas Espec�ficas Salud Infantil","Podolog�a",
				"Psicolog�a Cl�nica","Psiquiatr�a","Radiodiagn�stico - Diagn�stico por imagen","Radiolog�a Pedi�trica",
				"Radiologia Vascular e Intervencionista","Reumatolog�a","Traumatolog�a infantil","Traumatolog�a y Cirug�a Ortop�dica","Unidad de broncoscopias",
				"Unidad del Dolor","Urolog�a"};
		
		String nombres[] = {"Sof�a", "Martina","Daniela","Valeria","Noa","Luc�a","Mar�a", "Emma", "Julia", "Paula", "Alba", "Carla",
				"Alma", "Valentina", "Sara", "Carmen", "Claudia", "Elena", "Adriana", "Lola", "Vega", "Leyre", "Alejandra", "Candela",
				"Vera", "Olivia", "Laia", "Ana", "Jimena", "Triana", "Laura", "Aitana", "Irene", "Ariadna", "Marina" , "Victoria", "Alicia", "Carlota", "Ainara", "Marta",
				"Clara", "Lara" ,"Zoe", "In�s", "Roc�o", "Andrea", "�ngela", "Blanca", "Ainhoa", "Nora", "Eva", "Natalia", "Elsa", "Nerea" , "Aina", "Gala", "�frica", "Celia",
				 "Iria", "Adara", "Ona", "Aroa", "Carolina", "Iris", "Gabriela", "Mara", "Isabella", "Cayetana" , "India", "Hugo", "Lucas", "Mart�n", "Mateo", "Daniel", "Alejandro", "Pablo", "Eric", "Leo" ,"Enzo",
				 "Adri�n", "�lvaro", "Manuel", "Mario", "David", "Izan", "Oliver" ,"Marco", "Marcos", "Marc","Sergio", "Javier", "Luca", "Gonzalo", "Carlos", "Nicol�s", "Iv�n", "Antonio", "�ngel",
				 "Miguel", "H�ctor", "Gabriel", "Jorge", "Juan", "Rodrigo", "Jes�s" ,"Samuel", "Jos�", "Aar�n", "Rub�n", "Aitor", "Dar�o", "Alan", "Pau", "Joel" , "Alberto",
				 "Pol", "Jaime", "Nil",  "Francisco", "Luis" ,"Pedro" ,"Asier", "Sa�l" ,"Aleix", "Unai", "Guillermo", "Santiago", "V�ctor", "Alonso", "Ra�l", "Andr�s", "Gerard", "Jordi"};
		
		String apellidos[] = {"Garc�a","Rodr�guez","Gonz�lez","Fern�ndez","L�pez","Mart�nez","S�nchez","P�rez","G�mez","Mart�n","Jim�nez","Ruiz","Hern�ndez","D�az","Moreno",
				"Mu�oz","�lvarez","Romero","Alonso","Guti�rrez","Navarro","Torres","Dom�nguez","Ramos","V�zquez","Gil","Serrano","Ram�rez","Blanco","Molina","Morales","Ortega",
				"Su�rez","Delgado","Castro","Ortiz","Rubio","Mar�n","Sanz","Iglesias","Medina","N��ez","Garrido","Castillo","Cort�s","Lozano","Guerrero","Santos","Cano",
				"Prieto","Calvo","Vidal","M�ndez","Cruz","Gallego","Herrera","Cabrera","Pe�a","Flores","Le�n","M�rquez","Campos","Vega","Fuentes","Carrasco","D�ez","Caballero",
				"Nieto","Pascual","Reyes","Aguilar","Herrero","Santana","Ferrer","Lorenzo","Hidalgo","Montero","Gim�nez","Ib��ez","Mora","Vicente","Santiago","Dur�n","Arias",
				"Vargas","Ben�tez","Carmona","Crespo","Pastor","Soto","Soler","Velasco","Roman","S�ez","Moya","Esteban","Parra","Bravo","Gallardo","Pardo","Rojas","Merino",
				"Franco","Espinosa","Lara","Izquierdo","Rivas","Rivera","Casado","Arroyo","Redondo","Camacho","Rey","Segura","Luque","Sierra","Silva","Montes","Otero","Carrillo",
				"Marcos","Galan","R�os","Soriano","Marti","Mendoza","Vila","Valero","Robles","Palacios","Benito","Guerra","Varela","Mateo","Bueno","Exp�sito","Mac�as","Villar",
				"Rold�n","Miranda","Mateos","Escudero","Pereira","Guill�n","Casas","Aguilera","Rivero","Gracia","Padilla","Abad","Beltr�n","Men�ndez","Salas","Quintana","Conde",
				"Roca","Est�vez","Jurado","Acosta","Plaza","Serra","Aranda","Aparicio","Salazar","Guzm�n","Cuesta","Villanueva","Pons","Bl�zquez","Hurtado","Rueda","Pacheco","�vila",
				"Mesa","Blasco","Escobar","L�zaro","Salvador"};
		
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
				m.setPassword(new Sha256Hash("1234").toString()); //la contrase�a es 1234 para todos
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
