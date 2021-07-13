package ar.edu.davinci.adoptame.repository;

import ar.edu.davinci.adoptame.domain.Denuncias;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called personaRepository
// CRUD refers Create, Read, Update, Delete

public interface DenunciasRepository extends JpaRepository<Denuncias, Long> {


}