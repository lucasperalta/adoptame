package ar.edu.davinci.adoptame.controller.mobile;

import ar.edu.davinci.adoptame.DTO.ResponseDTO;
import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.constantes.Constantes;
import ar.edu.davinci.adoptame.domain.Rol;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.exception.NotFoundException;
import ar.edu.davinci.adoptame.service.RolService;
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

	@Autowired
	RolService rolService;

	@PostMapping(path="/modifyUser") // Map ONLY GET Requests
	public @ResponseBody UsuarioDTO modifyPersona (@RequestBody UsuarioDTO usuarioDTO)  {

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
	UsuarioDTO usuarioResponse= new UsuarioDTO(usuario);

	return usuarioResponse;
	}

	@PostMapping("/signInUser")
	public  @ResponseBody
	ResponseDTO guardarUsuario(@RequestBody UsuarioDTO usuarioDTO  ) {

		ResponseDTO responseDTO= new ResponseDTO();
		Usuario usuario= usuarioService.buscarUsuarioByEmail(usuarioDTO.getEmail());
		if(usuario!= null){
			responseDTO.setStatus("FAIL");
			responseDTO.setResult("Ya existe un usuario registrado con ese email");
			return responseDTO;
		}

		usuario= new Usuario();
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setApellido(usuarioDTO.getApellido());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setTelefono(usuarioDTO.getTelefono());
		usuario.setUbicacion(usuarioDTO.getUbicacion());

		usuario.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
		Rol rol=rolService.findRolById(Constantes.ROL_USER);
		usuario.setRol(rol);
		usuarioService.addUsuario(usuario);
		responseDTO.setStatus("SUCESS");
		responseDTO.setResult("Usuario dado de alta exitosamente");
		return responseDTO;
	}
}
