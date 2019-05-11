package es.upm.dit.isst.grupo6.cita.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.grupo06.cita.dao.HorarioConsultaDAO;
import es.upm.dit.isst.grupo06.cita.dao.HorarioConsultaDAOImplementation;
import es.upm.dit.isst.grupo06.cita.model.HorarioConsulta;

class HorarioHorarioConsultaDAOImplementationTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testCreate() {
		HorarioConsulta consulta = new HorarioConsulta();
		
		HorarioConsultaDAO consultadao = HorarioConsultaDAOImplementation.getInstance();
		consultadao.create(consulta);
		HorarioConsulta con = consultadao.read(consulta.getId());
		assertEquals(con.getId(), consulta.getId());
		
		consultadao.delete(consulta);
	
	}

	@Test
	void testRead() {
		HorarioConsulta consulta = new HorarioConsulta();
		
		HorarioConsultaDAO consultadao = HorarioConsultaDAOImplementation.getInstance();
		consultadao.create(consulta);
		HorarioConsulta con = consultadao.read(consulta.getId());
		System.out.println(con.getId());
		assertEquals(con.getId(), consulta.getId());
		
		consultadao.delete(consulta);
		
	}

	@Test
	void testUpdate() {
		HorarioConsulta consulta = new HorarioConsulta();
		
		HorarioConsultaDAO consultadao = HorarioConsultaDAOImplementation.getInstance();
		consultadao.create(consulta);
		
		consulta.setDiaSemana(3);
		consultadao.update(consulta);
		
		HorarioConsulta con = consultadao.read(consulta.getId());
		assertEquals(con.getDiaSemana(), consulta.getDiaSemana());
		
		consultadao.delete(consulta);
	}

	@Test
	void testDelete() {
		HorarioConsulta consulta = new HorarioConsulta();
		
		HorarioConsultaDAO consultadao = HorarioConsultaDAOImplementation.getInstance();
		consultadao.create(consulta);
		Collection<HorarioConsulta> con = consultadao.readAll();
		
		int nesp = con.size();
		consultadao.delete(consulta);
		con = consultadao.readAll();
		
		assertEquals(con.size(), nesp - 1);
		
	}

	@Test
	void testReadAll() {
		HorarioConsulta consulta = new HorarioConsulta();
		
		HorarioConsultaDAO consultadao = HorarioConsultaDAOImplementation.getInstance();
		consultadao.create(consulta);
		Collection<HorarioConsulta> con = consultadao.readAll();
		
		for(HorarioConsulta c:con) {
			if(c.getId() == consulta.getId()) {
				assertEquals(c.getId(), consulta.getId());
			}
		}
		
		consultadao.delete(consulta);
		
	}

}
