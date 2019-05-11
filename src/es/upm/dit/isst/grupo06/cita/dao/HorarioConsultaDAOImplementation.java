package es.upm.dit.isst.grupo06.cita.dao;

import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.grupo06.cita.model.HorarioConsulta;

public class HorarioConsultaDAOImplementation implements HorarioConsultaDAO{
	private static HorarioConsultaDAOImplementation instancia = null;

	private HorarioConsultaDAOImplementation() {
	}

	public static HorarioConsultaDAOImplementation getInstance() {
		if (null == instancia)
			instancia = new HorarioConsultaDAOImplementation();
		return instancia;
	}
	
	@Override
	public void create(HorarioConsulta horarioConsulta) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.save(horarioConsulta);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@Override
	public HorarioConsulta read(int id) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			HorarioConsulta horarioConsulta = session.get(HorarioConsulta.class, id);
			session.getTransaction().commit();
			return horarioConsulta;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void update(HorarioConsulta horarioConsulta) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.saveOrUpdate(horarioConsulta);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(HorarioConsulta horarioConsulta) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.delete(horarioConsulta);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void deleteAll() {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.createQuery("DELETE FROM HorarioConsulta").executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<HorarioConsulta> readAll() {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			Collection<HorarioConsulta> horarios = session.createQuery("from HorarioConsulta").list();
			session.getTransaction().commit();
			return horarios;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

}
