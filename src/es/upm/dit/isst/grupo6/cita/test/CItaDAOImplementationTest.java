package es.upm.dit.isst.grupo6.cita.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.grupo06.cita.dao.CitaDAO;
import es.upm.dit.isst.grupo06.cita.dao.CitaDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.MedicoDAO;
import es.upm.dit.isst.grupo06.cita.dao.MedicoDAOImplementation;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAO;
import es.upm.dit.isst.grupo06.cita.dao.PacienteDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.Cita;
import es.upm.dit.isst.grupo06.cita.model.Medico;
import es.upm.dit.isst.grupo06.cita.model.Paciente;

class CItaDAOImplementationTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreate() {
		Cita cita = new Cita();
		
		CitaDAO citadao = CitaDAOImplementation.getInstance();
		citadao.create(cita);
		Cita cit = citadao.read(cita.getId());
		assertEquals(cit.getId(), cita.getId());
		
		citadao.delete(cita);
	}

	@Test
	void testRead() {
		Cita cita = new Cita();
		
		CitaDAO citadao = CitaDAOImplementation.getInstance();
		citadao.create(cita);
		Cita cit = citadao.read(cita.getId());
		assertEquals(cit.getId(), cita.getId());
		
		citadao.delete(cita);
	}

	@Test
	void testUpdate() {
		Cita cita = new Cita();
		
		CitaDAO citadao = CitaDAOImplementation.getInstance();
		citadao.create(cita);
		Date fecha = Date.valueOf("2019-5-10");
		cita.setFecha(fecha);
		citadao.update(cita);
		
		Cita cit = citadao.read(cita.getId());
		assertEquals(cit.getFecha(), cita.getFecha());
		
		citadao.delete(cita);
	}

	@Test
	void testDelete() {
		Cita cita = new Cita();
		
		CitaDAO citadao = CitaDAOImplementation.getInstance();
		citadao.create(cita);
		Collection<Cita> cit = citadao.readAll();
		
		int nesp = cit.size();
		citadao.delete(cita);
		cit = citadao.readAll();
		
		assertEquals(cit.size(), nesp - 1);
	}

	@Test
	void testReadAll() {
		Cita cita = new Cita();
		
		CitaDAO citadao = CitaDAOImplementation.getInstance();
		citadao.create(cita);
		Collection<Cita> cit = citadao.readAll();
		
		for(Cita c:cit) {
			if(c.getId() == cita.getId()) {
				assertEquals(c.getId(), cita.getId());
			}
		}
		
		citadao.delete(cita);
	
	}

	@Test
	void testGetCitasDelDia() {
		Cita cita = new Cita();
		Medico medico = new Medico();
		medico.setEmail("medico@email.com");
		Date fecha = Date.valueOf("2019-5-10");
		cita.setFecha(fecha);
		cita.setMedico(medico);
		MedicoDAO medicodao = MedicoDAOImplementation.getInstance();
		medicodao.create(medico);
		CitaDAO citadao = CitaDAOImplementation.getInstance();
		citadao.create(cita);
		Collection<Cita> cit = citadao.getCitasDelDia(medico, fecha);
		System.out.println(cita);
		for(Cita c:cit) {
			if(c.getId() == cita.getId()) {
				assertEquals(c.getId(), cita.getId());
			}
		}
		
		citadao.delete(cita);
		medicodao.delete(medico);
	}

	@Test
	void testGetCitasPAS() {
		Cita cita = new Cita();
		Medico medico = new Medico();
		Paciente paciente = new Paciente();
		Date fecha = Date.valueOf("2019-5-10");
		CitaDAO citadao = CitaDAOImplementation.getInstance();
		MedicoDAO medicodao = MedicoDAOImplementation.getInstance();
		PacienteDAO pacientedao = PacienteDAOImplementation.getInstance();
		
		paciente.setEmail("paciente2@email.com");
		medico.setEmail("medico2@email.com");
		
		pacientedao.create(paciente);
		medicodao.create(medico);
		cita.setFecha(fecha);
		citadao.create(cita);
		
		Collection<Cita> cit = citadao.getCitasPAS(null,null, fecha);
		
		for(Cita c:cit) {
			if(c.getId() == cita.getId()) {
				assertEquals(c.getId(), cita.getId());
			}
		}
		
		cita.setMedico(medico);
		citadao.update(cita);
		
		cit = citadao.getCitasPAS(null,medico, fecha);
		for(Cita c:cit) {
			if(c.getId() == cita.getId()) {
				assertEquals(c.getId(), cita.getId());
			}
		}
		
		cita.setPaciente(paciente);
		citadao.update(cita);
		
		cit = citadao.getCitasPAS(paciente,medico, fecha);
		for(Cita c:cit) {
			if(c.getId() == cita.getId()) {
				assertEquals(c.getId(), cita.getId());
			}
		}
		
		cit = citadao.getCitasPAS(paciente,null, fecha);
		for(Cita c:cit) {
			if(c.getId() == cita.getId()) {
				assertEquals(c.getId(), cita.getId());
			}
		}
		
		cit = citadao.getCitasPAS(paciente,medico, null);
		for(Cita c:cit) {
			if(c.getId() == cita.getId()) {
				assertEquals(c.getId(), cita.getId());
			}
		}
		
		cit = citadao.getCitasPAS(paciente,null, null);
		for(Cita c:cit) {
			if(c.getId() == cita.getId()) {
				assertEquals(c.getId(), cita.getId());
			}
		}
		
		cit = citadao.getCitasPAS(null,medico, null);
		for(Cita c:cit) {
			if(c.getId() == cita.getId()) {
				assertEquals(c.getId(), cita.getId());
			}
		}
		
		citadao.delete(cita);
		medicodao.delete(medico);
		pacientedao.delete(paciente);
		
	}

}
