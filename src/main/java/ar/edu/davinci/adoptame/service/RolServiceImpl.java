package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Rol;
import ar.edu.davinci.adoptame.repository.RolRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class RolServiceImpl implements RolService{

	@Resource
	RolRepository rolRepository;


	@Override
	@Transactional
	public List<Rol> listaRoles() {
		return rolRepository.findAll();
	}

	@Override
    @Transactional
	public Rol findRolById(Rol rol) {
		return rolRepository.findOne(rol.getId().longValue());
	}



	@Override
    @Transactional
	public Rol findRolByNombreRol(String nombreRol) {
		return rolRepository.findRolByNombreRol(nombreRol);
	}
}
