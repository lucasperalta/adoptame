package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Servicio;

import java.util.List;

public interface ServicioService {

	public Servicio addServicio(Servicio servicio);

	List<Servicio> listarServicios();

	public void borrarServicio(Servicio servicio);

}