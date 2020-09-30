package ar.edu.davinci.adoptame.controller.mobile;

import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.constantes.Constantes;
import ar.edu.davinci.adoptame.domain.Estado;
import ar.edu.davinci.adoptame.domain.Rol;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.exception.NotFoundException;
import ar.edu.davinci.adoptame.service.EstadoService;
import ar.edu.davinci.adoptame.service.LoginService;
import ar.edu.davinci.adoptame.service.RolService;
import ar.edu.davinci.adoptame.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/mobile") // This means URL's start with /demo (after Application path)
public class LoginMobile {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RolService rolService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    PasswordEncoder passwordEncoder;

    Boolean loggedWithFb;

    @PostMapping("/ingresarMobile")
    public @ResponseBody
    UsuarioDTO findUser(HttpServletRequest request,
                        HttpServletResponse response,@RequestBody Map<String, Object> params) {

        loggedWithFb=false;
        Usuario usuarioExiste = null;
        String usuario= (String)params.get("usuario");
        String password= (String)params.get("password");
        String facebookId= (String)params.get("facebookId");

        if(facebookId!=null && !facebookId.isEmpty()){
            System.out.println("entre con facebook");
            loggedWithFb=true;

        }
        try {


            usuarioExiste = loginService.buscarUsuarioByEmail(usuario);


        } catch (NotFoundException e) {
            if(!loggedWithFb){
                return new UsuarioDTO();
            }else{
                System.out.println("se logueo con fb y no existe tengo que crear un user");
                usuarioExiste= new Usuario();
                usuarioExiste.setNombre("pocho");
                usuarioExiste.setApellido("lopez");
                usuarioExiste.setEmail(usuario);
                usuarioExiste.setTelefono(" ");
                usuarioExiste.setUbicacion(" ");
                Estado estado= estadoService.findEstadoByDescripcion(Constantes.ESTADO_ACTIVO);
                usuarioExiste.setEstado(estado);
                usuarioExiste.setPassword(passwordEncoder.encode("12345678"));//por default
                Rol rol=rolService.findRolById(Constantes.ROL_USER);
                usuarioExiste.setRol(rol);
                usuarioExiste= usuarioService.addUsuario(usuarioExiste);
            }

        }


        UsuarioDTO usuarioDTO = new UsuarioDTO();
        if (loggedWithFb || (!loggedWithFb && passwordEncoder.matches(password,usuarioExiste.getPassword())) ) {
            usuarioDTO.setId(usuarioExiste.getId());
            usuarioDTO.setEmail(usuarioExiste.getEmail());
            usuarioDTO.setPassword(usuarioExiste.getPassword());
            usuarioDTO.setNombre(usuarioExiste.getNombre());
            usuarioDTO.setApellido(usuarioExiste.getApellido());
            usuarioDTO.setEstado(usuarioExiste.getEstado().getEstado());
            usuarioDTO.setRol(usuarioExiste.getRol().getNombreRol());
            usuarioDTO.setUbicacion(usuarioExiste.getUbicacion());
            usuarioDTO.setTelefono(usuarioExiste.getTelefono());
        }
        return usuarioDTO;
    }

}