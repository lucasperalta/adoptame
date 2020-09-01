package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Servicio;
import ar.edu.davinci.adoptame.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    ServicioRepository servicioRepository;

    @Override
    public Servicio addServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    @Override
    public void borrarServicio(Servicio servicio) { servicioRepository.delete(servicio); }

    @Override
    public Servicio findOne(Integer id) {
        return servicioRepository.getOne(id);
    }

    @Override
    public List<Servicio> listarServiciosVigentes(Date fechaFin) {
        return servicioRepository.findAllByFechaFinAfter(fechaFin);
    }
}
