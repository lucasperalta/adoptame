package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.MotivosDenuncia;
import ar.edu.davinci.adoptame.DTO.MotivosDenunciaDTO;

import java.util.Date;
import java.util.List;

public interface MotivosDenunciaService {

	public List<MotivosDenuncia> listarMotivosDenuncia();

	public MotivosDenuncia addMotivo(MotivosDenunciaDTO motivo);

}