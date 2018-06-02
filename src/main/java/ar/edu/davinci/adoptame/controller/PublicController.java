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
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class PublicController {

@RequestMapping("/")
public String index(){
    return "public/index";

    }

    @GetMapping("/eventos")
    public String listarEventos(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "public/eventos";
    }

    @GetMapping("/eventoDetalle")
    public String detalleEventos(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "public/evento_det";
    }

}
