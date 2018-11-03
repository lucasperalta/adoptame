package ar.edu.davinci.adoptame.repository;

import ar.edu.davinci.adoptame.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

//import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called personaRepository
// CRUD refers Create, Read, Update, Delete

public interface LoginRepository extends JpaRepository<Usuario, Long> {

    public Usuario findAdmin(@Param("email") String email,@Param("password") String password);
    public Usuario buscarUsuarioByEmail(@Param("email") String email);


}