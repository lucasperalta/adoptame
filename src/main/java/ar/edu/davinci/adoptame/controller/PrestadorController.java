package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.DTO.PrestadorDTO;
import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.constantes.Constantes;
import ar.edu.davinci.adoptame.domain.Estado;
import ar.edu.davinci.adoptame.domain.Prestador;
import ar.edu.davinci.adoptame.domain.Rol;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.service.EstadoService;
import ar.edu.davinci.adoptame.service.PrestadorService;
import ar.edu.davinci.adoptame.service.RolService;
import ar.edu.davinci.adoptame.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/prestador") // This means URL's start with /demo (after Application path)
public class PrestadorController {
    private static final Logger logger = LoggerFactory.getLogger(PrestadorController.class);



    @Autowired
    private EstadoService estadoService;


    @Autowired
    private PrestadorService prestadorService;


    @GetMapping("/nuevoPrestador")
    public String nuevoPrestador(Model model) {
        model.addAttribute("prestadorDTO", new PrestadorDTO());
        return "prestador/alta";
    }


    @PostMapping("/guardarPrestador")
	public String guardarPrestador(@ModelAttribute PrestadorDTO prestadorDTO  ) {

        Prestador prestador= new Prestador();
        prestador.setNombre(prestadorDTO.getNombre());
        prestador.setApellido(prestadorDTO.getApellido());
        prestador.setEmail(prestadorDTO.getEmail());
        prestador.setTipoServicio(prestadorDTO.getTipoServicio());
        prestador.setFechaVinculacion(new Date());
        prestador.setVigencia(30);
        prestador.setUrlPago(prestadorDTO.getUrlPago());
        prestadorService.addPrestador(prestador);
		return "prestador/sucess";
	}

    /**
     * Lista todos los usuarios segun los filtros pasados por parametros
     * devuelve un json con todos los usuarios, se llama via ajax esta funcion
     * @return
     */
    @GetMapping("/todos")
    public @ResponseBody Iterable<Prestador> listarPrestadores( ) { //TODO hay filtros en la pantalla de busqueda?
        return prestadorService.listarPrestadores();
    }

    @GetMapping("/borrar")
    public @ResponseBody String borrarPrestador( @RequestParam String email) {

        Prestador prestador =prestadorService.buscarPrestadorByEmail(email);
        logger.info("prestador a borrar "+ prestador.toString());
        if(prestador!=null){
            prestadorService.borrarPrestador(prestador);

        }else{
            return "Prestador no encontrado";
        }
        return "prestador borrado";
    }

}
