package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.repository.MascotaRepository;
import ar.edu.davinci.adoptame.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class MascotaServiceImpl implements MascotaService{

	@Resource
	MascotaRepository mascotaRepository;


	@Override
	public List<Mascota> listarMascotas() {
		return mascotaRepository.findAll();
	}

	@Override
	public Mascota addMascotas(Mascota mascota) {
		return mascotaRepository.save(mascota);
	}

	@Override
	public List<Mascota> findAllByEstadoOrderByIdDesc(String estado) {
		return mascotaRepository.findAllByEstadoOrderByIdDesc(estado);
	}

}
