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

	/**
	 * busca eventos entre dias
	 * @param diasStart
	 * @param diasEnd
	 * @return
	 */
	@Override
	public List<Eventos> findByDiasBetween(Date diasStart, Date diasEnd) {
		return eventosRepository.findByDiasBetween(diasStart,diasEnd);
	}

	/**
	 * agrego evento
	 * @param evento
	 * @return
	 */
	@Override
	public Eventos addEvento(Eventos evento) {
		return eventosRepository.save(evento);
	}

	/**
	 * listo eventos
	 * @return
	 */
	@Override
	public List<Eventos> listarEventos() {
		return eventosRepository.findAll(sortByIdDesc());
	}

	/**
	 * encuentro un evento
	 * @param id
	 * @return
	 */
	@Override
	public Eventos findOne(Long id) {
		return eventosRepository.getOne(id);
	}

	/**
	 * borro evento
	 * @param evento
	 */
	@Override
	public void borrarEvento(Eventos evento) {
		eventosRepository.delete(evento);
	}


	/**
	 * ordento de forma descendente por id
	 * @return
	 */
	private Sort sortByIdDesc() {
		return new Sort(Sort.Direction.DESC, "id");
	}
}
