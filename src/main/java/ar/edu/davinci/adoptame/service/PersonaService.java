package ar.edu.davinci.adoptame.service;

import java.util.List;

import ar.edu.davinci.adoptame.domain.Persona;

import ar.edu.davinci.adoptame.exception.NotFoundException;

public interface PersonaService {
	public List<Persona> listarPersonas();

	public List<Persona> listarPersonasPorApellido(String apellido);

	public Persona encontrarPersonaPorId(Persona persona);

	public Persona econtrarPersonaPorEmail(String email) throws NotFoundException;

	public Persona registrarPersona(Persona persona);

	public Persona modificarPersona(Persona persona) throws NotFoundException;

	public Persona eliminarPersona(Persona persona) throws NotFoundException;

}