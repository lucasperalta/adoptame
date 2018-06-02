package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.constantes.Constantes;
import ar.edu.davinci.adoptame.domain.Estado;
import ar.edu.davinci.adoptame.domain.Persona;
import ar.edu.davinci.adoptame.domain.Rol;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.repository.PersonaRepository;
import ar.edu.davinci.adoptame.repository.UsuarioRepository;
import ar.edu.davinci.adoptame.service.EstadoService;
import ar.edu.davinci.adoptame.service.RolService;
import ar.edu.davinci.adoptame.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.core.ConstantException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/usuarios") // This means URL's start with /demo (after Application path)
public class UsuarioController {
	


	@Autowired
    private EstadoService estadoService;

    @Autowired
    private RolService rolService;

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/nuevoUsuario")
    public String greetingForm(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "usuarios/alta";
    }

    @PostMapping("/guardarUsuario")
	public String nuevoUsuario(@ModelAttribute UsuarioDTO usuarioDTO  ) {

        Usuario usuario= new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setEmail(usuarioDTO.getEmail());
        Estado estado= estadoService.findEstadoByDescripcion(Constantes.ESTADO_ACTIVO);
        usuario.setEstado(estado);

        usuario.setPassword(usuarioDTO.getPassword());
        Rol rol=rolService.findRolByNombreRol(usuarioDTO.getRol());
        usuario.setRol(rol);
        usuarioService.addUsuario(usuario);
		return "usuarios/sucess";
	}

    /**
     * Lista todos los usuarios segun los filtros pasados por parametros
     * devuelve un json con todos los usuarios, se llama via ajax esta funcion
     * @return
     */
    @GetMapping("/usuarios")
    public @ResponseBody Iterable<Usuario> listarUsuarios( ) { //TODO hay filtros en la pantalla de busqueda?


        return usuarioService.listarUsuarios();//TODO me deberia devolver un DTO donde no muestre el passw ???
    }


}
