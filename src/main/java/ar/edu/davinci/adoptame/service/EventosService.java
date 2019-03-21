package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Eventos;
import ar.edu.davinci.adoptame.domain.Mascota;

import java.util.Date;
import java.util.List;

public interface EventosService {

	List<Eventos> findByDiasBetween(Date diasStart, Date diasEnd);


}