package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Rol;

import java.util.List;

public interface RolService {

	public List<Rol> listaRoles();



	public Rol findRolById(Integer id);

	public Rol findRolByNombre(String nombreRol);




}