package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.DTO.EventosDTO;
import ar.edu.davinci.adoptame.DTO.MascotaDTO;
import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.domain.Eventos;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.service.EventosService;
import ar.edu.davinci.adoptame.service.MascotaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Cleaner;

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

 

}
