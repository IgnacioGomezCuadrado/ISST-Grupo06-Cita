package es.upm.dit.isst.grupo06.cita.dao;

import java.util.Collection;

import es.upm.dit.isst.grupo06.cita.model.Cita;

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
		// TODO Auto-generated method stub

	}

	@Override
	public Cita read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cita cita) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Cita cita) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Cita> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
