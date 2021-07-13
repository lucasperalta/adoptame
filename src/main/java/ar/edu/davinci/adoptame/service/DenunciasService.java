package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.DTO.DenunciaDTO;
import ar.edu.davinci.adoptame.DTO.MascotaDTO;
import ar.edu.davinci.adoptame.domain.Denuncias;

import java.util.List;

public interface DenunciasService {

	public Denuncias addDenuncias(DenunciaDTO denuncia);

}