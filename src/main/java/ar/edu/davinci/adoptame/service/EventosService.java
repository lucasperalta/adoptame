package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Eventos;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.domain.Usuario;

import java.util.Date;
import java.util.List;

public interface EventosService {

	List<Eventos> findByDiasBetween(Date diasStart, Date diasEnd);

	public Eventos addEvento(Eventos evento);

	public List<Eventos> listarEventos();

	public Eventos findOne(Long id) ;

	void borrarEvento(Eventos evento);
}