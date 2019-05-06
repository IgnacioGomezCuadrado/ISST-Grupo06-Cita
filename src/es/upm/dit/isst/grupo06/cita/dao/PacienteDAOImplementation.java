package es.upm.dit.isst.grupo06.cita.dao;

import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.grupo06.cita.model.Paciente;

public class PacienteDAOImplementation implements PacienteDAO{
	private static PacienteDAOImplementation instancia = null;

	private PacienteDAOImplementation() {
	}

	public static PacienteDAOImplementation getInstance() {
		if (null == instancia)
			instancia = new PacienteDAOImplementation();
		return instancia;
	}
	
	@Override
	public void create(Paciente paciente) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.save(paciente);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Paciente read(String dni) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			Paciente paciente = session.get(Paciente.class, dni);
			session.getTransaction().commit();
			return paciente;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void update(Paciente paciente) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.saveOrUpdate(paciente);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Paciente paciente) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.delete(paciente);
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
	public Collection<Paciente> readAll() {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			Collection<Paciente> pacientes = session.createQuery("from Paciente").list();
			session.getTransaction().commit();
			return pacientes;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Collection<Paciente> read(String nombre, String apellidos) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			@SuppressWarnings("unchecked")
			Collection<Paciente> pacientes = session.createQuery("from Pacientes p where p.nombre = :nombre and p.apellidos = :apellidos")  
										.setParameter("nombre", nombre)
										.setParameter("apellidos", apellidos) 
										.list();
			session.getTransaction().commit();
			return pacientes;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}
	
}
