package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.DTO.MascotaDTO;
import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.constantes.Constantes;
import ar.edu.davinci.adoptame.domain.Estado;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.domain.Rol;
import ar.edu.davinci.adoptame.domain.Usuario;

import ar.edu.davinci.adoptame.service.MascotaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/mascotas") // This means URL's start with /demo (after Application path)
public class MascotaController {
    private static final Logger logger = LoggerFactory.getLogger(MascotaController.class);



    @Autowired
    private MascotaService mascotaService;


    /**
     * Lista el top 3 de mascotas
     *
     */
    @GetMapping("/mascotasEnAdopcion")
    public @ResponseBody Iterable<MascotaDTO> mascotasEnAdopcion( ) {
       List<Mascota> mascotas=mascotaService.findTop3ByEstadoRandom("DISPONIBLE");
        List<MascotaDTO> mascotaDTOS= new ArrayList<>();
        for (Mascota mascota:mascotas) {
            String[] arrayPath= mascota.getFoto_url().split("/",4);
            String newUrl = ServletUriComponentsBuilder.fromCurrentContextPath().replacePath(null).build().toUriString()+"/"+arrayPath[3];
           mascota.setFoto_url(newUrl);
            MascotaDTO mascotaDTO= new MascotaDTO(mascota);
            mascotaDTOS.add(mascotaDTO);
        }
        return mascotaDTOS;
    }

    @GetMapping("/mascotasAdoptadas")
    public @ResponseBody Iterable<MascotaDTO> mascotasAdoptadas( ) {
        List<Mascota> mascotas=mascotaService.findAllByEstadoOrderByIdDesc("ADOPTADA");
        List<MascotaDTO> mascotaDTOS= new ArrayList<>();
        for (Mascota mascota:mascotas) {
            String[] arrayPath= mascota.getFoto_url().split("/",4);
            String newUrl = ServletUriComponentsBuilder.fromCurrentContextPath().replacePath(null).build().toUriString()+"/"+arrayPath[3];
            mascota.setFoto_url(newUrl);
            MascotaDTO mascotaDTO= new MascotaDTO(mascota);
            mascotaDTOS.add(mascotaDTO);
        }
        return mascotaDTOS;
    }


}
