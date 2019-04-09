package es.upm.dit.isst.grupo06.cita.dao;

import java.util.Collection;

import es.upm.dit.isst.grupo06.cita.model.Cita;


public interface CitaDAO {
	public void create(Cita cita);

	public Cita read(int id); //Hay que ver la clave primaria, id genérica de momento

	public void update(Cita cita);

	public void delete(Cita cita);

	public Collection<Cita> readAll();
}
