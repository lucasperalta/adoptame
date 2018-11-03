package ar.edu.davinci.adoptame.service;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import ar.edu.davinci.adoptame.constantes.Constantes;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.exception.NotFoundException;
import ar.edu.davinci.adoptame.repository.LoginRepository;
import org.springframework.stereotype.Service;

import ar.edu.davinci.adoptame.domain.Persona;


@Service
public class LoginServiceImpl implements LoginService{

	@Resource
	LoginRepository loginRepository;



	@Override
	@Transactional
	public Usuario findAdmin(String email,String password) throws NotFoundException {
		Usuario usuarioEncontrado = null;

		usuarioEncontrado = loginRepository.findAdmin(email,password);
		if (usuarioEncontrado == null) {
			throw new NotFoundException();
		}
		return usuarioEncontrado;
	}


	@Override
	@Transactional
	public Usuario buscarUsuarioByEmail(String email) throws NotFoundException {
		Usuario usuarioEncontrado = null;

		usuarioEncontrado = loginRepository.buscarUsuarioByEmail(email);
		if (usuarioEncontrado == null) {
			throw new NotFoundException();
		}
		return usuarioEncontrado;
	}
}


