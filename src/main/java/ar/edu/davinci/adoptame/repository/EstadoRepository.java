package ar.edu.davinci.adoptame.repository;

import ar.edu.davinci.adoptame.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


// This will be AUTO IMPLEMENTED by Spring into a Bean called personaRepository
// CRUD refers Create, Read, Update, Delete

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    public Estado findEstadoByDescripcion(@Param("descripcion")String descripcion) ;



}