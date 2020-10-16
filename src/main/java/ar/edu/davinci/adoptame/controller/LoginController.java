package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.DTO.RolDTO;
import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.domain.Rol;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.service.LoginService;
import ar.edu.davinci.adoptame.service.RolService;
import ar.edu.davinci.adoptame.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class LoginController {



	@Autowired
    private LoginService loginService;

    @Autowired
    private RolService rolService;

    @Autowired
    private UsuarioService usuarioService;




    @GetMapping("/login")
    public String loginAdmin(Model model,@RequestParam(value = "error", required = false) String error) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        if(error!=null ){
            model.addAttribute("error", "Verifique los datos ingresados");

        }
        return "login/login";
    }


    @GetMapping("/forbidden")
    public String accesssDenied(Model model ) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "public/403";
    }


    @PostMapping("/ingresar")
	public ModelAndView findAdmin(@ModelAttribute UsuarioDTO usuarioDTO ,Model model ) {
        Usuario usuario;

        List<Rol> roles=rolService.listaRoles();
        List<RolDTO> rolesDto= new ArrayList<>();
        for (Rol rol:roles ) {
            RolDTO rolDTO= new RolDTO();
            rolDTO.setId(rol.getId());
            rolDTO.setNombreRol(rol.getNombreRol());
            rolesDto.add(rolDTO);
        }



        model.addAttribute("roles", rolesDto);

        return new ModelAndView("redirect:/usuarios/nuevoUsuario");
	}



}
