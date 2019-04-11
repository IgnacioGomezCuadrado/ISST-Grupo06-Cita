package es.upm.dit.isst.grupo06.cita.dao;

import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.grupo06.cita.model.Especialidad;

public class EspecialidadDAOImplementation implements EspecialidadDAO{
	private static EspecialidadDAOImplementation instancia = null;

	private EspecialidadDAOImplementation() {
	}

	public static EspecialidadDAOImplementation getInstance() {
		if (null == instancia)
			instancia = new EspecialidadDAOImplementation();
		return instancia;
	}

	@Override
	public void create(Especialidad especialidad) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.save(especialidad);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Especialidad read(String nombre) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			Especialidad especialidad = session.get(Especialidad.class, nombre);
			session.getTransaction().commit();
			return especialidad;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void update(Especialidad especialidad) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.saveOrUpdate(especialidad);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Especialidad especialidad) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.delete(especialidad);
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
	public Collection<Especialidad> readAll() {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			Collection<Especialidad> especialidades = session.createQuery("from Especialidad").list();
			session.getTransaction().commit();
			return especialidades;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}
	
}
