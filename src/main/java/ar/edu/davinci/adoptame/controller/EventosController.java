package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.DTO.EventosDTO;
import ar.edu.davinci.adoptame.DTO.MascotaDTO;
import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.constantes.Constantes;
import ar.edu.davinci.adoptame.domain.*;
import ar.edu.davinci.adoptame.service.EventosService;
import ar.edu.davinci.adoptame.service.MascotaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.misc.Cleaner;

import javax.validation.Valid;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(path="/eventos")
public class EventosController {

    private static final Logger logger = LoggerFactory.getLogger(EventosController.class);

    @Autowired
    EventosService eventosService;


    /**
     * listo todos los eventos desde el dia actual a un mes
     * @param model
     * @return
     */

    @GetMapping("/listarProximos")
    public @ResponseBody  List<EventosDTO> listarEventos(Model model) {
        Date start = Calendar.getInstance().getTime();
       Calendar stopCalendar= Calendar.getInstance();
       stopCalendar.add(Calendar.MONTH,1);

        Date stop =stopCalendar.getTime();
        List<Eventos> eventos=eventosService.findByDiasBetween(start,stop);
        List<EventosDTO> eventosDTOS= new ArrayList<>();
        for (Eventos evento:eventos) {
            EventosDTO eventoDTO= new EventosDTO(evento);
            eventosDTOS.add(eventoDTO);
        }
        logger.info("eventos"+eventosDTOS);
        return eventosDTOS;
    }
    @PostMapping("/guardarEvento")
    public  @ResponseBody  String guardarEvento(@RequestBody @Valid EventosDTO eventosDTO , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("BINDING RESULT ERROR");
            return "errores";
        }

        Eventos evento = new Eventos(eventosDTO);
        eventosService.addEvento(evento);
        return "Evento dado de alta exitosamente";
    }


    /**
     * Lista todos los eventos segun los filtros pasados por parametros
     * devuelve un json con todos los usuarios, se llama via ajax esta funcion
     * @return
     */
    @GetMapping("/todos")
    public @ResponseBody Iterable<EventosDTO> listarEventos( ) { //TODO hay filtros en la pantalla de busqueda?
        List<Eventos> eventos=eventosService.listarEventos();
        List<EventosDTO> eventosDTOS= new ArrayList<>();
        for (Eventos evento:eventos) {
            EventosDTO eventosDTO= new EventosDTO();
            eventosDTO.setId(evento.getId());
            eventosDTO.setBarrio(evento.getBarrio());
            eventosDTO.setConsultas(evento.getConsultas());
            eventosDTO.setDireccion(evento.getDireccion());
            eventosDTO.setHorarios(evento.getHorarios());
            eventosDTO.setLugar(evento.getLugar());
            eventosDTO.setDias(evento.getDias());
            eventosDTOS.add(eventosDTO);
        }
        return eventosDTOS;
    }


}
