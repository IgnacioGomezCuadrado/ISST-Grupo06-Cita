package es.upm.dit.isst.grupo6.cita.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.grupo06.cita.dao.MedicoDAO;
import es.upm.dit.isst.grupo06.cita.dao.MedicoDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Medico;

class MedicoDAOImplementationTest {

	@BeforeEach
	void setUp() throws Exception {
		Medico medico = new Medico();
		medico.setEmail("medico@prueba.com");
		
		MedicoDAO medicodao = MedicoDAOImplementation.getInstance();
		medicodao.create(medico);
	}

	@AfterEach
	void tearDown() throws Exception {
		Medico medico = new Medico();
		medico.setEmail("medico@prueba.com");
		
		MedicoDAO medicodao = MedicoDAOImplementation.getInstance();
		medicodao.delete(medico);
	}

	@Test
	void testCreate() {
		
		MedicoDAO medicodao = MedicoDAOImplementation.getInstance();
		Collection<Medico> med = medicodao.readAll();
		
		System.out.println(med);
		for(Medico m:med) {
			if(m.getEmail() == "medico@prueba.com"){
				assertEquals(m.getEmail(),"medico@prueba.com");
				System.out.println(m);
			}
		}
	
		
	}

	@Test
	void testRead() {
		MedicoDAO medicodao = MedicoDAOImplementation.getInstance();
		Medico med = medicodao.read("medico@prueba.com");
		
			System.out.println(med);
			assertEquals(med.getEmail(),"medico@prueba.com");
		
	}

	@Test
	void testUpdate() {
		MedicoDAO medicodao = MedicoDAOImplementation.getInstance();
		Collection<Medico> med = medicodao.readAll();
		
		System.out.println(med);
		for(Medico m:med) {
			if(m.getEmail() == "medico@prueba.com"){
				m.setApellidos("Ortega");
				medicodao.update(m);
			}
		}
		med = medicodao.readAll();
		for(Medico m:med) {
			if(m.getEmail() == "medico@prueba.com"){
				assertEquals(m.getApellidos(),"Ortega");
				System.out.println(m);
			}
		}
		
		
	}

	@Test
	void testDelete() {
		Medico medico = new Medico();
		medico.setEmail("medico@prueba.com");
		
		MedicoDAO medicodao = MedicoDAOImplementation.getInstance();
		Collection<Medico> med = medicodao.readAll();
		int nmed = med.size();
		medicodao.delete(medico);
		med = medicodao.readAll();
		
		System.out.println(med);
		assertEquals(med.size(),nmed - 1);
		

	}

	@Test
	void testReadAll() {
		MedicoDAO medicodao = MedicoDAOImplementation.getInstance();
		Collection<Medico> med = medicodao.readAll();

		System.out.println(med);
		for(Medico m:med) {
			if(m.getEmail() == "medico@prueba.com"){
				assertEquals(m.getEmail(),"medico@prueba.com");
				System.out.println(m);
			}
		}
	
	}

}
