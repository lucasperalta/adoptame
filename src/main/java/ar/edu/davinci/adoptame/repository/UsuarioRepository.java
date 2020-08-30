package ar.edu.davinci.adoptame.repository;

import ar.edu.davinci.adoptame.domain.Rol;
import ar.edu.davinci.adoptame.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

//import org.springframework.data.repository.CrudRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    public Usuario buscarUsuarioByEmail(@Param("email")String email);


}