package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.DTO.DenunciaDTO;
import ar.edu.davinci.adoptame.DTO.MascotaDTO;
import ar.edu.davinci.adoptame.domain.Coordenada;
import ar.edu.davinci.adoptame.domain.Denuncias;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.repository.DenunciasRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class DenunciasServiceImpl implements DenunciasService{

	@Resource
	DenunciasRepository denunciasRepository;
	/**
	 * agrego evento
	 * @param denuncia
	 * @return
	 */
	@Override
	public Denuncias addDenuncias(DenunciaDTO denuncia) {
		Denuncias denunciaModel = new Denuncias(denuncia.getIdMascota(),denuncia.getIdPersona(),
				denuncia.getIdMotivo(), denuncia.getFecha());
		return denunciasRepository.save(denunciaModel);
	}

}
