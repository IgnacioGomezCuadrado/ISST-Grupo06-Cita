package es.upm.dit.isst.grupo06.cita.dao;
import org.hibernate.Session;
import es.upm.dit.isst.grupo06.cita.model.PAS;

public class PASDAOImplementation implements PASDAO{
	private static PASDAOImplementation instancia = null;

	private PASDAOImplementation() {
	}

	public static PASDAOImplementation getInstance() {
		if (null == instancia)
			instancia = new PASDAOImplementation();
		return instancia;
	}

	@Override
	public void create(PAS pas) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.save(pas);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@Override
	public PAS read(String email) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			PAS medico = session.get(PAS.class, email);
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
	public void update(PAS pas) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.saveOrUpdate(pas);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(PAS pas) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.delete(pas);
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
			session.createQuery("DELETE FROM PAS").executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}
}
