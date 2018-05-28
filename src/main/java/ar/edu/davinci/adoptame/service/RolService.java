package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Estado;
import ar.edu.davinci.adoptame.domain.Rol;

import java.util.List;

public interface RolService {

	public List<Rol> listaRoles();



	public Rol findRolById(Rol rol);

	public Rol findRolByNombreRol(String nombreRol);




}