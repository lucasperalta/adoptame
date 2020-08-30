package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.DTO.MascotaDTO;
import ar.edu.davinci.adoptame.domain.Coordenada;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class MascotaServiceImpl implements MascotaService{

	@Resource
	MascotaRepository mascotaRepository;
	@Autowired
	UsuarioService usuarioService;

	@Override
	public List<Mascota> listarMascotas() {
		return mascotaRepository.findAll();
	}

	@Override
	public Mascota addMascotas(MascotaDTO mascota) {

	Usuario rescatista=	usuarioService.buscarUsuarioByID(new Integer(mascota.getRescatista()));
	//TODO sacar este hardcodeo de aca
	Coordenada coordenada= new Coordenada(new Double("-34.6131500"),new Double("-58.3772300"));

		Mascota mascotaModel= new Mascota(mascota.getNombre(),mascota.getSexo(),
				mascota.getTipoMascota(),mascota.getRaza(),
				mascota.getEdad(),mascota.getFoto_url(),mascota.getEstado(),
				mascota.getDescripcion(),mascota.getTamanio(),rescatista,coordenada);
		return mascotaRepository.save(mascotaModel);
	}


	public List<Mascota> findAllByEstadoOrderByIdDesc(String estado) {
		return mascotaRepository.findAllByEstadoOrderByIdDesc(estado);
	}
	@Override
	public List<Mascota> findTop3ByEstadoRandom(String estado) {

		return mascotaRepository.findTop3ByEstadoOrderByRandom(estado);
	}


	@Override
	public List<Mascota> findAllByEstadoAndSexoAndTamanioAndEdad(Mascota mascota) {
		return mascotaRepository.findAll(Example.of(mascota));
	}

	@Override
	public List<Mascota> findAllByRescatista(Usuario usuario) {
		return mascotaRepository.findAllByRescatista(usuario);
	}
}
