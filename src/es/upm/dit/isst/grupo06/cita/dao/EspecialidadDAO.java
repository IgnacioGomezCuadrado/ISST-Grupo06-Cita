package es.upm.dit.isst.grupo06.cita.dao;

import java.util.Collection;

import es.upm.dit.isst.grupo06.cita.model.Especialidad;

public interface EspecialidadDAO {

	public void create(Especialidad especialidad);

	public Especialidad read(int id);

	public void update(Especialidad especialidad);

	public void delete(Especialidad especialidad);

	public Collection<Especialidad> readAll();
}
