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
		Coordenada coordenada= new Coordenada(mascota.getLatitud(),mascota.getLongitud());

		Mascota mascotaModel= new Mascota(mascota.getNombre(),mascota.getSexo(),
				mascota.getTipoMascota(),mascota.getRaza(),
				mascota.getEdad(),mascota.getFoto_url(),mascota.getEstado(),
				mascota.getDescripcion(),mascota.getTamanio(),rescatista,coordenada, mascota.getActiva(), mascota.getFechaInicio(),
				mascota.getFechaFin(), mascota.getIdAdoptante());
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
	public List<Mascota> findAllByEstadoAndSexoInAndEdadLessThanEqualAndTamanioIn(String estado, List<String> sexo, Integer edad, List<String> tamanio){
		//return mascotaRepository.findAll(Example.of(mascota));
		return mascotaRepository.findAllByEstadoAndSexoInAndEdadLessThanEqualAndTamanioIn(estado,sexo,edad,tamanio);
	}

	@Override
	public List<Mascota> findAllByRescatista(Usuario usuario) {
		return mascotaRepository.findAllByRescatista(usuario);
	}

	@Override
	public Mascota findById(Long id) {
		return mascotaRepository.findById(id).orElse(null);
	}

	@Override
	public Mascota save (Mascota mascota) {
		return mascotaRepository.save(mascota);
	}

	@Override
	public List<Mascota> findAll() {
		return mascotaRepository.findAll();
	}

	public List<Mascota> findFiltros(String estado, List<String> sexo,Integer edad, List<String> tamanio, List<String> tipoMascota){
		return mascotaRepository.findFiltros(estado, sexo, edad, tamanio, tipoMascota);
	}

}
