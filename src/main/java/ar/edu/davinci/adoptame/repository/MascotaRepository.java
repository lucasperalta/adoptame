package ar.edu.davinci.adoptame.repository;

import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//import org.springframework.data.repository.CrudRepository;


public interface MascotaRepository extends JpaRepository<Mascota, Long> {

     List<Mascota> findAllByEstadoOrderByIdDesc(@Param("estado")String estado);

    @Query(value="SELECT * FROM mascotas where estado=:estado ORDER BY  RANDOM() LIMIT 3", nativeQuery = true)
    List<Mascota> findTop3ByEstadoOrderByRandom(@Param("estado")String estado);


     List<Mascota> findAllByRescatista(Usuario usuario);


    List<Mascota> findAllByEstadoAndSexoInAndEdadLessThanEqualAndTamanioIn(@Param("estado") String estado,
                                                                       @Param("sexo") List<String> sexo,
                                                                       @Param("edad") Integer edad,
                                                                        @Param("tamanio") List<String> tamanio);

    @Query(value="SELECT * FROM mascotas where estado=:estado and activa = true and sexo in :sexo and edad <= :edad and tamanio in :tamanio " +
            "and tipo_mascota in :tipoMascota ORDER BY  RANDOM() LIMIT 20", nativeQuery = true)
    List<Mascota> findFiltros(@Param("estado") String estado,
                              @Param("sexo") List<String> sexo,
                              @Param("edad") Integer edad,
                              @Param("tamanio") List<String> tamanio,
                              @Param("tipoMascota") List<String> tipoMascota);

    void deleteById(@Param("id") Long id);


}