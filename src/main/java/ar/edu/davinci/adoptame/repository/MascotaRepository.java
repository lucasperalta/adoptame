package ar.edu.davinci.adoptame.repository;

import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//import org.springframework.data.repository.CrudRepository;


public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    public List<Mascota> findAllByEstadoOrderByIdDesc(@Param("estado")String estado);

    @Query(value="SELECT * FROM mascotas where estado=:estado ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Mascota> findTop3ByEstadoOrderByRandom(@Param("estado")String estado);

    public List<Mascota> findAllBySexoOrTamanioOrEdad(String sexo,String tamanio,Integer edad);

    public List<Mascota> findAllByRescatista(Usuario usuario);

}