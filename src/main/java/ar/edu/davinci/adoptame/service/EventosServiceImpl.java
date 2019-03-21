package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Eventos;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.repository.EventosRepository;
import ar.edu.davinci.adoptame.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class EventosServiceImpl implements EventosService{

	@Resource
	EventosRepository eventosRepository;


	@Override
	public List<Eventos> findByDiasBetween(Date diasStart, Date diasEnd) {
		return eventosRepository.findByDiasBetween(diasStart,diasEnd);
	}
}
