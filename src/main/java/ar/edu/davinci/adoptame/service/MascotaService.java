package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.DTO.MascotaDTO;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.domain.Usuario;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MascotaService {

	public List<Mascota> listarMascotas();


	public Mascota addMascotas(MascotaDTO mascota);


	public List<Mascota> findAllByEstadoOrderByIdDesc(String estado);
	public List<Mascota> findTop3ByEstadoRandom(String estado) ;

	public List<Mascota> findAllBySexoOrTamanioOrEdad(String sexo,String tamanio,Integer edad) ;

	public List<Mascota> findAllByRescatista(Usuario usuario) ;




	}