package es.upm.dit.isst.grupo06.cita.dao;

import java.util.Collection;

import es.upm.dit.isst.grupo06.cita.model.Medico;

public interface MedicoDAO {

	public void create(Medico medico);

	public Medico read(String email);

	public void update(Medico medico);

	public void delete(Medico medico);
	
	public void deleteAll();

	public Collection<Medico> readAll();
	
}
