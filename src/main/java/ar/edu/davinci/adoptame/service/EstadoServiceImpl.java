package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Estado;
import ar.edu.davinci.adoptame.domain.Persona;
import ar.edu.davinci.adoptame.exception.NotFoundException;
import ar.edu.davinci.adoptame.repository.EstadoRepository;
import ar.edu.davinci.adoptame.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class EstadoServiceImpl implements EstadoService{

	@Resource
	EstadoRepository estadoRepository;
	


	@Override
	@Transactional
	public List<Estado> listarEstados() {
        return (List<Estado>) estadoRepository.findAll();
    }

	@Override
    @Transactional
	public Estado findEstadoById(Estado estado) {
		return estadoRepository.findOne(estado.getId().longValue());
	}

	@Override
	public Estado findEstadoByDescripcion(String descripcion) {
		return estadoRepository.findEstadoByDescripcion(descripcion);
	}

	@Override
    @Transactional
	public Estado addEstado(Estado estado) {
		return estadoRepository.save(estado);
	}




}
