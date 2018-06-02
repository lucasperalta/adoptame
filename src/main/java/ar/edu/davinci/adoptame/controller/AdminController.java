package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.service.EstadoService;
import ar.edu.davinci.adoptame.service.RolService;
import ar.edu.davinci.adoptame.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/admin") // This means URL's start with /demo (after Application path)
public class AdminController {
	


	@Autowired
    private EstadoService estadoService;

    @Autowired
    private RolService rolService;

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/eventos")
    public String admEventos(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "admin/admEvento";
    }

    @GetMapping("/servicios")
    public String admServicios(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "admin/admServicios";
    }

    @GetMapping("/usuarios")
    public String admUsuarios(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "admin/admUsuarios";
    }



}
