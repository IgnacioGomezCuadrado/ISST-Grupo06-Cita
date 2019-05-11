package es.upm.dit.isst.grupo6.cita.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.grupo06.cita.dao.PASDAO;
import es.upm.dit.isst.grupo06.cita.dao.PASDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.PAS;

class PASDAOImplementationTest {

	@BeforeEach
	void setUp() throws Exception {
		PAS pas = new PAS();
		pas.setEmail("pas@prueba.com");
		
		PASDAO pasdao = PASDAOImplementation.getInstance();
		pasdao.create(pas);
	}

	@AfterEach
	void tearDown() throws Exception {
		PAS pas = new PAS();
		pas.setEmail("pas@prueba.com");
		
		PASDAO pasdao = PASDAOImplementation.getInstance();
		pasdao.delete(pas);
	}

	@Test
	void testCreate() {
		
		PASDAO pasdao = PASDAOImplementation.getInstance();
		Collection<PAS> pa = pasdao.readAll();
		
		System.out.println(pa);
		for(PAS p:pa) {
			if(p.getEmail() == "pas@prueba.com"){
				assertEquals(p.getEmail(),"pas@prueba.com");
				System.out.println(p);
			}
		}
	
		
	}

	@Test
	void testRead() {
		PASDAO pasdao = PASDAOImplementation.getInstance();
		PAS pa = pasdao.read("pas@prueba.com");
		
			System.out.println(pa);
			assertEquals(pa.getEmail(),"pas@prueba.com");
		
	}

	@Test
	void testUpdate() {
		PASDAO pasdao = PASDAOImplementation.getInstance();
		Collection<PAS> pa = pasdao.readAll();
		
		System.out.println(pa);
		for(PAS p:pa) {
			if(p.getEmail() == "pas@prueba.com"){
				p.setApellidos("Ortega");
				pasdao.update(p);
			}
		}
		pa = pasdao.readAll();
		for(PAS p:pa) {
			if(p.getEmail() == "pas@prueba.com"){
				assertEquals(p.getApellidos(),"Ortega");
				System.out.println(p);
			}
		}
		
		
	}

	@Test
	void testDelete() {
		PAS pas = new PAS();
		pas.setEmail("pas@prueba.com");
		
		PASDAO pasdao = PASDAOImplementation.getInstance();
		Collection<PAS> pa = pasdao.readAll();
		int npa = pa.size();
		pasdao.delete(pas);
		pa = pasdao.readAll();
		
		System.out.println(pa);
		assertEquals(pa.size(),npa - 1);
		

	}
	
	@Test
	void testDeleteAll() {
		PAS pas2 = new PAS();
		pas2.setEmail("pas2@prueba.com");
				
		PASDAO pasdao = PASDAOImplementation.getInstance();
		pasdao.create(pas2);
		pasdao.deleteAll();
		
		Collection<PAS> pa = pasdao.readAll();
		pa = pasdao.readAll();
		
		assertEquals(pa.size(),0);
		

	}

	@Test
	void testReadAll() {
		PASDAO pasdao = PASDAOImplementation.getInstance();
		Collection<PAS> pa = pasdao.readAll();

		for(PAS p:pa) {
			if(p.getEmail() == "pas@prueba.com"){
				assertEquals(p.getEmail(),"pas@prueba.com");

			}
		}
	
	}

}
