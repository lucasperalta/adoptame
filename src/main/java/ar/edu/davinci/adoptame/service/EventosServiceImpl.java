package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Eventos;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.repository.EventosRepository;
import ar.edu.davinci.adoptame.repository.MascotaRepository;
import org.springframework.data.domain.Sort;
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

	@Override
	public Eventos addEvento(Eventos evento) {
		return eventosRepository.save(evento);
	}

	@Override
	public List<Eventos> listarEventos() {
		return eventosRepository.findAll(sortByIdDesc());
	}

	@Override
	public Eventos findOne(Long id) {
		return eventosRepository.getOne(id);
	}

	@Override
	public void borrarEvento(Eventos evento) {
		eventosRepository.delete(evento);
	}

	private Sort sortByIdDesc() {
		return new Sort(Sort.Direction.DESC, "id");
	}
}
