package es.upm.dit.isst.grupo6.cita.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.grupo06.cita.dao.EspecialidadDAO;
import es.upm.dit.isst.grupo06.cita.dao.EspecialidadDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Especialidad;

class EspecialidadDAOImplementationTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void testCreate() {
		Especialidad especialidad = new Especialidad();
		
		EspecialidadDAO especialidaddao = EspecialidadDAOImplementation.getInstance();
		especialidaddao.create(especialidad);
		Especialidad esp = especialidaddao.read(especialidad.getId());
		assertEquals(esp.getId(), especialidad.getId());
		
		especialidaddao.delete(especialidad);
	
	}

	@Test
	void testRead() {
		Especialidad especialidad = new Especialidad();
		
		EspecialidadDAO especialidaddao = EspecialidadDAOImplementation.getInstance();
		especialidaddao.create(especialidad);
		Especialidad esp = especialidaddao.read(especialidad.getId());
		System.out.println(esp.getId());
		assertEquals(esp.getId(), especialidad.getId());
		
		especialidaddao.delete(especialidad);
		
	}

	@Test
	void testUpdate() {
		Especialidad especialidad = new Especialidad();
		
		EspecialidadDAO especialidaddao = EspecialidadDAOImplementation.getInstance();
		especialidaddao.create(especialidad);
		
		especialidad.setNombre("Oftalmologia");
		especialidaddao.update(especialidad);
		
		Especialidad esp = especialidaddao.read(especialidad.getId());
		assertEquals(esp.getNombre(), especialidad.getNombre());
		
		especialidaddao.delete(especialidad);
	}

	@Test
	void testDelete() {
		Especialidad especialidad = new Especialidad();
		
		EspecialidadDAO especialidaddao = EspecialidadDAOImplementation.getInstance();
		especialidaddao.create(especialidad);
		Collection<Especialidad> esp = especialidaddao.readAll();
		
		int nesp = esp.size();
		especialidaddao.delete(especialidad);
		esp = especialidaddao.readAll();
		
		assertEquals(esp.size(), nesp - 1);
		
	}

	@Test
	void testReadAll() {
		Especialidad especialidad = new Especialidad();
		
		EspecialidadDAO especialidaddao = EspecialidadDAOImplementation.getInstance();
		especialidaddao.create(especialidad);
		Collection<Especialidad> esp = especialidaddao.readAll();
		
		for(Especialidad e:esp) {
			if(e.getId() == especialidad.getId()) {
				assertEquals(e.getId(), especialidad.getId());
			}
		}
		
		especialidaddao.delete(especialidad);
		
	}

}
