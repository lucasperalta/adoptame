package ar.edu.davinci.adoptame.controller.mobile;

import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.domain.Persona;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.exception.NotFoundException;
import ar.edu.davinci.adoptame.repository.PersonaRepository;
import ar.edu.davinci.adoptame.service.PersonaService;
import ar.edu.davinci.adoptame.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/mobile") // This means URL's start with /demo (after Application path)
public class UsuarioMobileController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping(path="/modifyUser") // Map ONLY GET Requests
	public @ResponseBody Usuario modifyPersona (@RequestBody UsuarioDTO usuarioDTO)  {

	 Usuario usuario=	usuarioService.buscarUsuarioByEmail(usuarioDTO.getEmail());

	 if(usuario==null){
	 	throw new NotFoundException();
	 }

	if(usuarioDTO.getNombre()!=null){
		usuario.setNombre(usuarioDTO.getNombre());

	}
	if(usuarioDTO.getApellido()!=null){
		usuario.setApellido(usuarioDTO.getApellido());

	}
	if(usuarioDTO.getTelefono()!=null){
	 usuario.setTelefono(usuarioDTO.getTelefono());

	}
	if(usuarioDTO.getUbicacion()!=null){
		usuario.setUbicacion(usuarioDTO.getUbicacion());

	}

	if(usuarioDTO.getPassword()!=null){
		usuario.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
	}

	usuarioService.addUsuario(usuario);



	return usuario;
	}
	

}
