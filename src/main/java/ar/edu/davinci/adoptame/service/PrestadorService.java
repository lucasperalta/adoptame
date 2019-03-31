package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Prestador;

import java.util.List;

public interface PrestadorService {

	public List<Prestador> listarPrestadores();


	public Prestador addPrestador(Prestador prestador);

	public Prestador encontrarPrestadorPorEmail(String email);




}