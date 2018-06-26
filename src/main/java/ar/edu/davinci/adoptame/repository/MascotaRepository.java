package ar.edu.davinci.adoptame.repository;

import ar.edu.davinci.adoptame.domain.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called personaRepository
// CRUD refers Create, Read, Update, Delete

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    public List<Mascota> findAllByEstado(@Param("estado")String estado);

}