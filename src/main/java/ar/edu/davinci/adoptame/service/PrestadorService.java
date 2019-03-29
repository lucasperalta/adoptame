package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Prestador;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.exception.NotFoundException;

import java.util.List;

public interface PrestadorService {

	public List<Prestador> listarPrestadores();


	public Prestador addPrestador(Prestador prestador);

	public Prestador encontrarPrestadorPorEmail(String email);


	}