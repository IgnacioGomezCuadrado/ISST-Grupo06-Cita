package es.upm.dit.isst.grupo6.cita.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.grupo06.cita.dao.PacienteDAO;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Paciente;

class PacienteDAOImplementationTest {

	@BeforeEach
	void setUp() throws Exception {
		Paciente paciente = new Paciente();
		paciente.setDni("55555555X");
		paciente.setEmail("email@test.com");
		
		PacienteDAO pacientedao = PacienteDAOImplementation.getInstance();
		pacientedao.create(paciente);
	}

	@AfterEach
	void tearDown() throws Exception {
		Paciente paciente = new Paciente();
		paciente.setDni("55555555X");
		paciente.setEmail("email@test.com");
		
		PacienteDAO pacientedao = PacienteDAOImplementation.getInstance();
		pacientedao.delete(paciente);
	}

	@Test
	void testCreate() {
		
		PacienteDAO pacientedao = PacienteDAOImplementation.getInstance();
		Collection<Paciente> pac = pacientedao.readAll();
		
		System.out.println(pac);
		for(Paciente p:pac) {
			if(p.getDni() == "55555555X"){
				assertEquals(p.getDni(),"55555555X");
				System.out.println(p);
			}
		}
		
	}

	@Test
	void testRead() {
		PacienteDAO pacientedao = PacienteDAOImplementation.getInstance();
		Paciente pac = pacientedao.read("email@test.com");
		
		System.out.println(pac);
		assertEquals(pac.getDni(), "55555555X");
		
	}

	@Test
	void testUpdate() {
		PacienteDAO pacientedao = PacienteDAOImplementation.getInstance();
		Collection<Paciente> pac = pacientedao.readAll();

		System.out.println(pac);
		for(Paciente p:pac) {
			if(p.getDni() == "55555555X"){
				p.setApellidos("Ortega");
				pacientedao.update(p);
			}
		}
		pac = pacientedao.readAll();
		for(Paciente p:pac) {
			if(p.getDni() == "55555555X"){
				assertEquals(p.getApellidos(),"Ortega");
				System.out.println(p);
			}
		}
			
	}

	@Test
	void testDelete() {
		Paciente paciente = new Paciente();
		paciente.setDni("55555555X");
		paciente.setEmail("email@test.com");
		
		PacienteDAO pacientedao = PacienteDAOImplementation.getInstance();
		Collection<Paciente> pac = pacientedao.readAll();
		int npac = pac.size();
		pacientedao.delete(paciente);
		pac = pacientedao.readAll();
		
		System.out.println(pac);
		assertEquals(pac.size(),npac - 1);

	}

	@Test
	void testReadAll() {
		PacienteDAO pacientedao = PacienteDAOImplementation.getInstance();
		Collection<Paciente> pac = pacientedao.readAll();
	
		System.out.println(pac);
		for(Paciente p:pac) {
			if(p.getDni() == "55555555X"){
				assertEquals(p.getDni(),"55555555X");
				System.out.println(p);
			}
		}
		
	}

}
