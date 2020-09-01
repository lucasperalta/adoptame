package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.DTO.MascotaDTO;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.domain.Usuario;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MascotaService {

	 List<Mascota> listarMascotas();


	 Mascota addMascotas(MascotaDTO mascota);


	 List<Mascota> findAllByEstadoOrderByIdDesc(String estado);
	 List<Mascota> findTop3ByEstadoRandom(String estado) ;

	 List<Mascota> findAllByEstadoAndSexoAndTamanioAndEdad(Mascota mascota) ;

	 List<Mascota> findAllByRescatista(Usuario usuario) ;

	 Mascota findById(Long id);

	 Mascota save (Mascota mascota);




}