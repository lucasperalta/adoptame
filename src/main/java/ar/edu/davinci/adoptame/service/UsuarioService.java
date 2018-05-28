package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.domain.Estado;
import ar.edu.davinci.adoptame.domain.Usuario;

import java.util.List;

public interface UsuarioService {

	public List<Usuario> listarUsuarios();






	public Usuario addUsuario(Usuario usuario);



}