package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.domain.Usuario;

import java.util.List;

public interface MascotaService {

	public List<Mascota> listarMascotas();


	public Mascota addMascotas(Mascota usuario);

	public void borrarUsuario(Mascota usuario);



}