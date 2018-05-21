package ar.edu.davinci.adoptame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.davinci.adoptame.domain.Persona;

// This will be AUTO IMPLEMENTED by Spring into a Bean called personaRepository
// CRUD refers Create, Read, Update, Delete

public interface PersonaRepository extends JpaRepository<Persona, Long> {

	List<Persona> findByApellido(@Param("apellido") String apellido);

	Persona findByEmail(@Param("email") String email);

}