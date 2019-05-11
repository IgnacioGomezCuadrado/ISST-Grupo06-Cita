package es.upm.dit.isst.grupo06.cita.dao;


import java.util.Collection;

import es.upm.dit.isst.grupo06.cita.model.PAS;



public interface PASDAO {
	
	public void create(PAS pas);

	public PAS read(String email);

	public void update(PAS pas);

	public void delete(PAS pas);
	
	public Collection<PAS> readAll();
	
	public void deleteAll();


}
