package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Servicio;

import java.util.Date;
import java.util.List;

public interface ServicioService {

	 Servicio addServicio(Servicio servicio);

	List<Servicio> listarServicios();

	 void borrarServicio(Servicio servicio);

	 Servicio findOne(Integer id) ;

	 List<Servicio> listarServiciosVigentes(Date fechaFin) ;



	}