package es.upm.dit.isst.grupo06.cita.dao;

import java.util.Date;
import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.grupo06.cita.model.Cita;
import es.upm.dit.isst.grupo06.cita.model.Medico;
import es.upm.dit.isst.grupo06.cita.model.Paciente;
import es.upm.dit.isst.grupo06.cita.dao.SessionFactoryService;

public class CitaDAOImplementation implements CitaDAO {
	private static CitaDAOImplementation instancia = null;

	private CitaDAOImplementation() {
	}

	public static CitaDAOImplementation getInstance() {
		if (null == instancia)
			instancia = new CitaDAOImplementation();
		return instancia;
	}

	@Override
	public void create(Cita cita) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.save(cita);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Cita read(int id) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			Cita cita = session.get(Cita.class, id);
			session.getTransaction().commit();
			return cita;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void update(Cita cita) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.saveOrUpdate(cita);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Cita cita) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			session.delete(cita);
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
	public Collection<Cita> readAll() {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			// operaciones
			Collection<Cita> citas = session.createQuery("from Cita").list();
			session.getTransaction().commit();
			return citas;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

	// Metodo para consultar las citas asignadas a un medico un dia concreto
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Cita> getCitasDelDia(Medico medico, Date fecha) {
		Session session = SessionFactoryService.get().openSession();
		java.sql.Date fechaSql = new java.sql.Date(fecha.getTime()); // Pasar a fecha sql
		try {
			session.beginTransaction();
			// operaciones
			Collection<Cita> citas = session.createQuery("from Cita c where c.fecha = :fecha and c.medico = :medico")
					.setParameter("fecha", fechaSql).setParameter("medico", medico).list();
			session.getTransaction().commit();
			return citas;
		} catch (Exception e) {
			// manejar excepciones
			System.out.println(e);
		} finally {
			session.close();
		}
		return null;
	}

	// Metodo para la consulta de citas por parte del PAS
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Cita> getCitasPAS(Paciente paciente, Medico medico, Date fecha) {
		Session session = SessionFactoryService.get().openSession();
		java.sql.Date fechaSql = null;
		String pac;
		String med;
		String fec;
		if (paciente != null) {
			pac = "1";
		} else {
			pac = "0";
		}
		if (medico != null) {
			med = "1";
		} else {
			med = "0";
		}
		if (fecha != null) {
			fec = "1";
			fechaSql = new java.sql.Date(fecha.getTime()); // Pasar a fecha sql
		} else {
			fec = "0";
		}
		switch (pac + med + fec) {
		case "111":
			try {
				session.beginTransaction();
				// operaciones
				Collection<Cita> citas = session
						.createQuery(
								"from Cita c where c.paciente = :paciente and c.medico = :medico and c.fecha = :fecha")
						.setParameter("paciente", paciente).setParameter("medico", medico)
						.setParameter("fecha", fechaSql).list();
				session.getTransaction().commit();
				return citas;
			} catch (Exception e) {
				// manejar excepciones
				System.out.println(e);
			} finally {
				session.close();
			}
		case "110":
			try {
				session.beginTransaction();
				// operaciones
				Collection<Cita> citas = session
						.createQuery("from Cita c where c.paciente = :paciente and c.medico = :medico")
						.setParameter("paciente", paciente).setParameter("medico", medico).list();
				session.getTransaction().commit();
				return citas;
			} catch (Exception e) {
				// manejar excepciones
				System.out.println(e);
			} finally {
				session.close();
			}
		case "101":
			try {
				session.beginTransaction();
				// operaciones
				Collection<Cita> citas = session
						.createQuery("from Cita c where c.paciente = :paciente and c.fecha = :fecha")
						.setParameter("paciente", paciente).setParameter("fecha", fechaSql).list();
				session.getTransaction().commit();
				return citas;
			} catch (Exception e) {
				// manejar excepciones
				System.out.println(e);
			} finally {
				session.close();
			}
		case "100":
			try {
				session.beginTransaction();
				// operaciones
				Collection<Cita> citas = session.createQuery("from Cita c where c.paciente = :paciente")
						.setParameter("paciente", paciente).list();
				session.getTransaction().commit();
				return citas;
			} catch (Exception e) {
				// manejar excepciones
				System.out.println(e);
			} finally {
				session.close();
			}
		case "011":
			try {
				session.beginTransaction();
				// operaciones
				Collection<Cita> citas = session
						.createQuery("from Cita c where c.medico = :medico and c.fecha = :fecha")
						.setParameter("medico", medico).setParameter("fecha", fechaSql).list();
				session.getTransaction().commit();
				return citas;
			} catch (Exception e) {
				// manejar excepciones
				System.out.println(e);
			} finally {
				session.close();
			}
		case "010":
			try {
				session.beginTransaction();
				// operaciones
				Collection<Cita> citas = session.createQuery("from Cita c where c.medico = :medico")
						.setParameter("medico", medico).list();
				session.getTransaction().commit();
				return citas;
			} catch (Exception e) {
				// manejar excepciones
				System.out.println(e);
			} finally {
				session.close();
			}
		case "001":
			try {
				session.beginTransaction();
				// operaciones
				Collection<Cita> citas = session.createQuery("from Cita c where c.fecha = :fecha")
						.setParameter("fecha", fechaSql).list();
				session.getTransaction().commit();
				return citas;
			} catch (Exception e) {
				// manejar excepciones
				System.out.println(e);
			} finally {
				session.close();
			}
		default:
			return null;
		}
	}
}
