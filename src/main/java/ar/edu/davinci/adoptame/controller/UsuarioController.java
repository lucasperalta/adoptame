package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.DTO.ResponseDTO;
import ar.edu.davinci.adoptame.DTO.RolDTO;
import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.domain.Rol;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.service.RolService;
import ar.edu.davinci.adoptame.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/usuarios") // This means URL's start with /demo (after Application path)
public class UsuarioController {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);





    @Autowired
    private RolService rolService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping("/nuevoUsuario")
    public String nuevoUsuario(Model model) {
        List<Rol> roles=rolService.listaRoles();
        List<RolDTO> rolesDto= new ArrayList<>();
        for (Rol rol:roles ) {
            RolDTO rolDTO= new RolDTO();
            rolDTO.setId(rol.getId());
            rolDTO.setNombreRol(rol.getNombreRol());
            rolesDto.add(rolDTO);
        }


        model.addAttribute("usuarioDTO", new UsuarioDTO());

        model.addAttribute("roles", rolesDto);

        return "usuarios/admUsuarios";
    }


    @PostMapping("/guardarUsuario")
	public  @ResponseBody  ResponseDTO guardarUsuario(@RequestBody UsuarioDTO usuarioDTO  ) {

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
        usuario.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
        Rol rol=rolService.findRolById(new Integer(usuarioDTO.getRol()));
        usuario.setRol(rol);
        usuarioService.addUsuario(usuario);
        responseDTO.setStatus("SUCESS");
        responseDTO.setResult("Usuario dado de alta exitosamente");
		return responseDTO;
	}

    @PostMapping("/editarUsuario")
    public  @ResponseBody  ResponseDTO editarUsuario(@RequestBody UsuarioDTO usuarioDTO  ) {

        ResponseDTO responseDTO= new ResponseDTO();

        Usuario usuario= usuarioService.buscarUsuarioByID(usuarioDTO.getId());
       if(usuario!= null){
           usuario.setNombre(usuarioDTO.getNombre());
           usuario.setApellido(usuarioDTO.getApellido());
           usuario.setEmail(usuarioDTO.getEmail());

           Rol rol=rolService.findRolById(new Integer(usuarioDTO.getRol()));
           usuario.setRol(rol);
           usuarioService.addUsuario(usuario);
           responseDTO.setStatus("SUCESS");
           responseDTO.setResult("Usuario Modificado exitosamente");
           return responseDTO;
       }

        responseDTO.setStatus("FAIL");
        responseDTO.setResult("Hubo un error al modificar el usuario");
       return responseDTO;

    }

    /**
     * Lista todos los usuarios segun los filtros pasados por parametros
     * devuelve un json con todos los usuarios, se llama via ajax esta funcion
     * @return
     */
    @GetMapping("/todos")
    public @ResponseBody Iterable<UsuarioDTO> listarUsuarios( ) { //TODO hay filtros en la pantalla de busqueda?
           List<Usuario> usuarios=usuarioService.listarUsuarios();
        List<UsuarioDTO> usuariosDTO= new ArrayList<>();
        for (Usuario user:usuarios) {
            UsuarioDTO usuarioDTO= new UsuarioDTO();
            usuarioDTO.setId(user.getId());
            usuarioDTO.setNombre(user.getNombre());
            usuarioDTO.setApellido(user.getApellido());
            usuarioDTO.setEmail(user.getEmail());
            usuarioDTO.setRol(user.getRol().getNombreRol());
            usuariosDTO.add(usuarioDTO);
        }
        return usuariosDTO;
    }

    @PostMapping("/borrar")
    public @ResponseBody String borrarUsuario( @RequestBody UsuarioDTO usuarioDTO) {

        Usuario usuario =usuarioService.buscarUsuarioByEmail(usuarioDTO.getEmail());
        logger.info("Usuario a borrar "+ usuario.toString());
        if(usuario!=null){
            usuarioService.borrarUsuario(usuario);

        }else{
            return "Usuario no encontrado";
        }
        return "usuario borrado";
    }

}
