package ar.edu.davinci.adoptame.controller.mobile;

import ar.edu.davinci.adoptame.DTO.PrestadorDTO;
import ar.edu.davinci.adoptame.domain.Servicio;
import ar.edu.davinci.adoptame.service.PrestadorService;
import ar.edu.davinci.adoptame.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(path="/mobile")
public class PrestadorMobileController {


    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");


    @Autowired
    private ServicioService servicioService;

    @GetMapping("/servicios")
    public @ResponseBody
    Iterable<PrestadorDTO> listarServicios( ) {
        List<Servicio> servicios =servicioService.listarServiciosVigentes(new Date());
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
}
