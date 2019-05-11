package es.upm.dit.isst.grupo06.cita.dao;

import java.util.Collection;

import es.upm.dit.isst.grupo06.cita.model.HorarioConsulta;

public interface HorarioConsultaDAO {
	
	public void create(HorarioConsulta horarioConsulta);

	public HorarioConsulta read(int id);

	public void update(HorarioConsulta horarioConsulta);

	public void delete(HorarioConsulta horarioConsulta);
	
	public void deleteAll();

	public Collection<HorarioConsulta> readAll();
}
