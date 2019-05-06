package es.upm.dit.isst.grupo06.cita.dao;

import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.grupo06.cita.model.Medico;

public class MedicoDAOImplementation implements MedicoDAO{
	private static MedicoDAOImplementation instancia = null;

	private MedicoDAOImplementation() {
	}

	public static MedicoDAOImplementation getInstance() {
		if (null == instancia)
			instancia = new MedicoDAOImplementation();
		return instancia;
	}
	
	@Override
	public void create(Medico medico) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.save(medico);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Medico read(String email) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			Medico medico = session.get(Medico.class, email);
			session.getTransaction().commit();
			return medico;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void update(Medico medico) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.saveOrUpdate(medico);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Medico medico) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.delete(medico);
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
	public Collection<Medico> readAll() {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			Collection<Medico> medicos = session.createQuery("from Medico").list();
			session.getTransaction().commit();
			return medicos;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Collection<Medico> read(String nombre, String apellidos) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			@SuppressWarnings("unchecked")
			Collection<Medico> medicos = session.createQuery("from Medicos m where m.nombre = :nombre and m.apellidos = :apellidos")  
										.setParameter("nombre", nombre)
										.setParameter("apellidos", apellidos) 
										.list();
			session.getTransaction().commit();
			return medicos;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

}
