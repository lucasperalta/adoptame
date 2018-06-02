package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.DTO.RolDTO;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/login") // This means URL's start with /demo (after Application path)
public class LoginController {



	@Autowired
    private LoginService loginService;

    @Autowired
    private RolService rolService;

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/login")
    public String loginAdmin(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "login/login";
    }


    @PostMapping("/ingresar")
	public String findAdmin(@ModelAttribute UsuarioDTO usuarioDTO ,Model model ) {
        Usuario usuario;

        try {
            usuario = loginService.findAdmin(usuarioDTO.getEmail(),usuarioDTO.getPassword());
        } catch (NotFoundException e) {
            model.addAttribute("loginfail", "Usuario o password incorrectos");
            return "login/login";
        }
        //TODO  pasar el usuario a DTO y guardarlo usuario en session

        List<Rol> roles=rolService.listaRoles();
        List<RolDTO> rolesDto= new ArrayList<>();
        for (Rol rol:roles ) {
            RolDTO rolDTO= new RolDTO();
            rolDTO.setId(rol.getId());
            rolDTO.setNombreRol(rol.getNombreRol());
            rolesDto.add(rolDTO);
        }


        model.addAttribute("roles", rolesDto);

		return "usuarios/admUsuarios";
	}

}
