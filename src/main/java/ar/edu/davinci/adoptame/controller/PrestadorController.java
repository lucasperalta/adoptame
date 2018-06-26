package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.DTO.PersonaDTO;
import ar.edu.davinci.adoptame.DTO.PrestadorDTO;
import ar.edu.davinci.adoptame.domain.Persona;
import ar.edu.davinci.adoptame.domain.Prestador;
import ar.edu.davinci.adoptame.domain.Servicio;
import ar.edu.davinci.adoptame.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/prestador") // This means URL's start with /demo (after Application path)
public class PrestadorController {
    private static final Logger logger = LoggerFactory.getLogger(PrestadorController.class);



    @Autowired
    private ServicioService servicioService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private PrestadorService prestadorService;


    @GetMapping("/nuevoPrestador")
    public String nuevoPrestador(Model model) {
        model.addAttribute("prestadorDTO", new PrestadorDTO());
        model.addAttribute("personaDTO", new PersonaDTO());
        return "prestador/admServicios";
    }


    @PostMapping("/buscarEmail")
    public @ResponseBody String buscarEmail( @RequestBody PersonaDTO personaDTO) {
     //   Persona persona = personaService.econtrarPersonaPorEmail(personaDTO.getEmail());
        return "persona.toString()";
    }


    @PostMapping("/guardarPrestador")
    public  @ResponseBody  String  guardarPrestador(@RequestBody PrestadorDTO prestadorDTO  ) {

        Prestador prestador= new Prestador();
        prestador.setNombre(prestadorDTO.getNombre());
        prestador.setApellido(prestadorDTO.getApellido());
        prestador.setEmail(prestadorDTO.getEmail());
        prestador.setFechaVinculacion(new Date());
        prestador.setUrlPago(prestadorDTO.getUrlPago());
        prestador.setTipoServicio(prestadorDTO.getTipoServicio());
        prestadorService.addPrestador(prestador);



        Servicio servicio= new Servicio();
        servicio.setPrestador(prestador);
        servicio.setTitulo(prestadorDTO.getTitulo());
        servicio.setTipoServicio(prestadorDTO.getTipoServicio());
        servicio.setFechaInicio(new Date());
        servicio.setVigencia(prestadorDTO.getVigencia().toString());
        servicio.setDescripcion(prestadorDTO.getDescripcion());
        servicio.setCosto(prestadorDTO.getCosto());
        servicio.setFechaFin(AddFecha(prestadorDTO.getVigencia()));
        servicioService.addServicio(servicio);

		return "Prestador dado de alta exitosamente";
	}

	public Date AddFecha (int dias){
     Calendar calendar = Calendar.getInstance();
     calendar.setTime(new Date());
     calendar.add(Calendar.DAY_OF_YEAR,dias);
     return calendar.getTime();
    }

    @GetMapping("/todos")
    public @ResponseBody Iterable<PrestadorDTO> listarServicios( ) { //TODO hay filtros en la pantalla de busqueda?
        List<Servicio> servicios =servicioService.listarServicios();
        List<PrestadorDTO> prestadoresDTO= new ArrayList<>();
        for (Servicio serv:servicios) {
            PrestadorDTO prestadorDTO = new PrestadorDTO();
            prestadorDTO.setId(serv.getPrestador().getId());
            prestadorDTO.setNombre(serv.getPrestador().getNombre());
            prestadorDTO.setApellido(serv.getPrestador().getApellido());
            prestadorDTO.setEmail(serv.getPrestador().getEmail());
            prestadorDTO.setFechaVinculacion(serv.getFechaInicio());
            prestadorDTO.setFechaFin(serv.getFechaFin());
            prestadorDTO.setTitulo(serv.getTitulo());
            prestadoresDTO.add(prestadorDTO);
            }
        return prestadoresDTO;
    }


}
