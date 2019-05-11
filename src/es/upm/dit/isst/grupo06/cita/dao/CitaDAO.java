package es.upm.dit.isst.grupo06.cita.dao;

import java.util.Date;
import java.util.Collection;

import es.upm.dit.isst.grupo06.cita.model.Cita;
import es.upm.dit.isst.grupo06.cita.model.Medico;
import es.upm.dit.isst.grupo06.cita.model.Paciente;

public interface CitaDAO {
	
	public void create(Cita cita);

	public Cita read(int id);

	public void update(Cita cita);

	public void delete(Cita cita);

	public Collection<Cita> readAll();
	
	public Collection<Cita> getCitasDelDia(Medico medico, Date fecha);

	public Collection<Cita> getCitasPAS(Paciente paciente, Medico medico, Date fecha);
}
