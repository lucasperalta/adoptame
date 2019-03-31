package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.DTO.EventosDTO;
import ar.edu.davinci.adoptame.DTO.PersonaDTO;
import ar.edu.davinci.adoptame.DTO.PrestadorDTO;
import ar.edu.davinci.adoptame.domain.Eventos;
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

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/prestador") // This means URL's start with /demo (after Application path)
public class PrestadorController {
    private static final Logger logger = LoggerFactory.getLogger(PrestadorController.class);

    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");


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
    public @ResponseBody Prestador buscarEmail( @RequestBody PrestadorDTO prestadorDTO) {
        Prestador  prestador= prestadorService.encontrarPrestadorPorEmail(prestadorDTO.getEmail());
        return prestador;
    }


    @PostMapping("/guardarPrestador")
    public  @ResponseBody  String  guardarPrestador(@RequestBody PrestadorDTO prestadorDTO  ) {

        Prestador prestador=null;

        prestador= prestadorService.encontrarPrestadorPorEmail(prestadorDTO.getEmail());

        if(prestador==null){
            prestador  = new Prestador();
        }
            prestador.setNombre(prestadorDTO.getNombre());
            prestador.setApellido(prestadorDTO.getApellido());
            prestador.setEmail(prestadorDTO.getEmail());
            prestador.setFechaVinculacion(new Date());
            prestador.setTipoServicio(prestadorDTO.getTipoServicio());
            prestador.setTelefono(prestadorDTO.getTelefono());
            prestador.setDireccion(prestadorDTO.getDireccion());
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
        servicio.setUrlPago(prestadorDTO.getUrlPago());
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
    public @ResponseBody Iterable<PrestadorDTO> listarServicios( ) {
        List<Servicio> servicios =servicioService.listarServicios();
        List<PrestadorDTO> prestadoresDTO= new ArrayList<>();
        for (Servicio serv:servicios) {
            PrestadorDTO prestadorDTO = new PrestadorDTO();
            prestadorDTO.setId(serv.getPrestador().getId());
            prestadorDTO.setNombre(serv.getPrestador().getNombre());
            prestadorDTO.setApellido(serv.getPrestador().getApellido());
            prestadorDTO.setEmail(serv.getPrestador().getEmail());
            prestadorDTO.setFechaVinculacion(serv.getFechaInicio());
            prestadorDTO.setFechaFin(format.format(serv.getFechaFin()));
            prestadorDTO.setTitulo(serv.getTitulo());
            prestadorDTO.setIdServicio(serv.getId_servicio());
            prestadorDTO.setCosto(serv.getCosto());
            prestadorDTO.setDescripcion(serv.getDescripcion());
            prestadorDTO.setUrlPago(serv.getUrlPago());
            prestadorDTO.setTipoServicio(serv.getTipoServicio());
            prestadoresDTO.add(prestadorDTO);
            }
        return prestadoresDTO;
    }


    @PostMapping("/borrar")
    public @ResponseBody String borrarServicio( @RequestBody PrestadorDTO prestadorDTO) {

        Servicio servicio =servicioService.findOne(prestadorDTO.getIdServicio());
        if(servicio!=null){
            logger.info("servicio a borrar "+ servicio.getId_servicio());

            servicioService.borrarServicio(servicio);

        }else{
            logger.info("Servicio no encontrado");

            return "Servicio no encontrado";
        }
        return "Servicio borrado";
    }



    @PostMapping("/editarServicio")
    public  @ResponseBody  String editarServicio(@RequestBody PrestadorDTO prestadorDTO  ) {


        Servicio servicio= servicioService.findOne(prestadorDTO.getIdServicio());
        if(servicio!= null){

            servicio.setTitulo(prestadorDTO.getTitulo());
            servicio.setCosto(prestadorDTO.getCosto());
            servicio.setDescripcion(prestadorDTO.getDescripcion());
            servicio.setUrlPago(prestadorDTO.getUrlPago());
            try {
                servicio.setFechaFin(format.parse(prestadorDTO.getFechaFin()) );
            } catch (ParseException e) {
                //si falla ponemos la fecha de hoy
                servicio.setFechaFin(new Date() );
            }
            servicioService.addServicio(servicio);//si existe lo actualiza sino lo inserta
            return "Servicio Modificado exitosamente";
        }
        return "Hubo un error al modificar el servicio";

    }


}
