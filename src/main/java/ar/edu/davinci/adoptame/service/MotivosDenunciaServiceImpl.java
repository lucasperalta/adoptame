package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.DTO.MotivosDenunciaDTO;
import ar.edu.davinci.adoptame.domain.Denuncias;
import ar.edu.davinci.adoptame.domain.MotivosDenuncia;
import ar.edu.davinci.adoptame.repository.MotivoDenunciaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class MotivosDenunciaServiceImpl implements MotivosDenunciaService{

	@Resource
	MotivoDenunciaRepository motivoDenunciaRepository;
	/**
	 * lista motivos de denuncia
	 * @return
	 */
	@Override
	public List<MotivosDenuncia> listarMotivosDenuncia() {
		return motivoDenunciaRepository.findAllByPublico(true);
	}

	/**
	 * agrego motivo
	 * @param motivo
	 * @return
	 */
	@Override
	public MotivosDenuncia addMotivo(MotivosDenunciaDTO motivo) {
		MotivosDenuncia motivoModel = new MotivosDenuncia(motivo.getMotivo(), motivo.getPublico());
		return motivoDenunciaRepository.save(motivoModel);
	}
}