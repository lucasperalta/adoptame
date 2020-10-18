package ar.edu.davinci.adoptame.repository;

import ar.edu.davinci.adoptame.domain.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called personaRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {


    List<Servicio> findAllByFechaFinAfter(Date fechaFin);

}