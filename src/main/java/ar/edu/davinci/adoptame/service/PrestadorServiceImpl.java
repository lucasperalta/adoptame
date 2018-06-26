package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Prestador;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.repository.PrestadorRepository;
import ar.edu.davinci.adoptame.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class PrestadorServiceImpl implements PrestadorService{

	@Resource
	PrestadorRepository prestadorRepository;


	@Override
	public List<Prestador> listarPrestadores() {
		return prestadorRepository.findAll();
	}

	@Override
	public Prestador addPrestador(Prestador prestador) {
		return prestadorRepository.save(prestador);
	}

}
