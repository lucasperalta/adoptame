package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Estado;


import java.util.List;

public interface EstadoService {

	public List<Estado> listarEstados();



	public Estado findEstadoById(int id);

	public Estado findEstadoByDescripcion(String descripcion);

	public Estado addEstado(Estado estado);



}