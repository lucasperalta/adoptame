package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.domain.Estado;
import ar.edu.davinci.adoptame.domain.Persona;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.exception.NotFoundException;
import ar.edu.davinci.adoptame.repository.PersonaRepository;
import ar.edu.davinci.adoptame.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Resource
	UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional
	public Usuario addUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

    @Override
    public void borrarUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public Usuario buscarUsuarioByEmail(String email) {
        return usuarioRepository.buscarUsuarioByEmail(email);
    }
}
