package ar.edu.davinci.adoptame.controller.mobile;

import ar.edu.davinci.adoptame.DTO.EventosDTO;
import ar.edu.davinci.adoptame.DTO.PrestadorDTO;
import ar.edu.davinci.adoptame.controller.EventosController;
import ar.edu.davinci.adoptame.domain.Eventos;
import ar.edu.davinci.adoptame.domain.Servicio;
import ar.edu.davinci.adoptame.service.EventosService;
import ar.edu.davinci.adoptame.service.ServicioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(path="/mobile")
public class EventosMobileController {


    private static final Logger logger = LoggerFactory.getLogger(EventosController.class);
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    @Autowired
    EventosService eventosService;


    @Autowired
    private ServicioService servicioService;

    /**
     * listo todos los eventos desde el dia actual a un mes
     * @param model
     * @return
     */

    @GetMapping("/eventos")
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
