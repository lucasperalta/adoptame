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

import java.util.ArrayList;
import java.util.List;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/mascotas") // This means URL's start with /demo (after Application path)
public class MascotaController {
    private static final Logger logger = LoggerFactory.getLogger(MascotaController.class);



    @Autowired
    private MascotaService mascotaService;





    /**
     * Lista todos los usuarios segun los filtros pasados por parametros
     * devuelve un json con todos los usuarios, se llama via ajax esta funcion
     * @return
     */
    @GetMapping("/todos")
    public @ResponseBody Iterable<MascotaDTO> listarUsuarios( ) { //TODO hay filtros en la pantalla de busqueda?
       List<Mascota> mascotas=mascotaService.findAllByEstado("DISPONIBLE");
        List<MascotaDTO> mascotaDTOS= new ArrayList<>();
        for (Mascota mascota:mascotas) {
            MascotaDTO mascotaDTO= new MascotaDTO();
            mascotaDTO.setId(mascota.getId());
            mascotaDTO.setDescripcion(mascota.getDescripcion());
            mascotaDTO.setEdad(mascota.getEdad());
            mascotaDTO.setEstado(mascota.getEstado());
            mascotaDTO.setFoto_url(mascota.getFoto_url());
            mascotaDTO.setNombre(mascota.getNombre());
            mascotaDTO.setRaza(mascota.getRaza());
            mascotaDTO.setRescatista(mascota.getRescatista().getEmail());
            mascotaDTO.setSexo(mascota.getSexo());
            mascotaDTO.setTamanio(mascota.getTamanio());
            mascotaDTO.setTipoMascota(mascota.getTipoMascota());
            mascotaDTOS.add(mascotaDTO);
        }
        return mascotaDTOS;
    }



}
