package ar.edu.davinci.adoptame.service;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

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
	public Usuario findAdmin(Usuario usuario) throws NotFoundException {
		Usuario usuarioEncontrado = null;
//		}
		//usuarioEncontrado = LoginRepository.findAdmin(usuario.getEmail());
		if (usuarioEncontrado == null) {
			throw new NotFoundException();
		}
		return usuarioEncontrado;
	}
	}


