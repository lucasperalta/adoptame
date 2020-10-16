package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Usuario;

import java.util.List;

public interface UsuarioService  {

	public List<Usuario> listarUsuarios();

	public Usuario addUsuario(Usuario usuario);

	public void borrarUsuario(Usuario usuario);

	public Usuario buscarUsuarioByEmail(String email);

	public Usuario buscarUsuarioByID(Integer id);


}