package ar.edu.davinci.adoptame.repository;

import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.domain.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called personaRepository
// CRUD refers Create, Read, Update, Delete

public interface PermisoRepository extends JpaRepository<Permiso, Long> {


}