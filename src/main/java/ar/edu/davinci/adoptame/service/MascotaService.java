package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.domain.Usuario;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MascotaService {

	public List<Mascota> listarMascotas();


	public Mascota addMascotas(Mascota mascota);


	public List<Mascota> findAllByEstado(String estado);


}