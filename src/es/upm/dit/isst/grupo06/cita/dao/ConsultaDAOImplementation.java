package es.upm.dit.isst.grupo06.cita.dao;

import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.grupo06.cita.model.Consulta;

public class ConsultaDAOImplementation implements ConsultaDAO{
	private static ConsultaDAOImplementation instancia = null;
	
	private ConsultaDAOImplementation() {
	}

	public static ConsultaDAOImplementation getInstance() {
		if (null == instancia)
			instancia = new ConsultaDAOImplementation();
		return instancia;
	}

	@Override
	public void create(Consulta consulta) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.save(consulta);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		
	}

	@Override
	public Consulta read(int numero) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			Consulta consulta = session.get(Consulta.class, numero);
			session.getTransaction().commit();
			return consulta;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void update(Consulta consulta) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.saveOrUpdate(consulta);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(Consulta consulta) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.delete(consulta);
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
	public Collection<Consulta> readAll() {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			Collection<Consulta> consultas = session.createQuery("from Consulta").list();
			session.getTransaction().commit();
			return consultas;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

	

}
