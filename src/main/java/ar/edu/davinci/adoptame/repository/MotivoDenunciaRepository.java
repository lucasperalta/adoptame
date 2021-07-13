package ar.edu.davinci.adoptame.repository;

import ar.edu.davinci.adoptame.domain.MotivosDenuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called personaRepository
// CRUD refers Create, Read, Update, Delete

public interface MotivoDenunciaRepository extends JpaRepository<MotivosDenuncia, Long> {

    List<MotivosDenuncia> findAllByPublico(Boolean publico);
}