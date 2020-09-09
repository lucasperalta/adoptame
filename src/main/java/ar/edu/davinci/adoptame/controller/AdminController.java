package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.service.EstadoService;
import ar.edu.davinci.adoptame.service.MascotaService;
import ar.edu.davinci.adoptame.service.RolService;
import ar.edu.davinci.adoptame.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/admin") // This means URL's start with /demo (after Application path)
public class AdminController {
	


	@Autowired
    private EstadoService estadoService;

    @Autowired
    private RolService rolService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MascotaService mascotaService;


    @GetMapping("/eventos")
    public String admEventos(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "admin/admEventos";
    }

    @GetMapping("/servicios")
    public String admServicios(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "admin/admServicios";
    }

    @GetMapping("/usuarios")
    public String admUsuarios(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "admin/admUsuarios";
    }

    @RequestMapping(value = "/chart", method= RequestMethod.GET)
    public String chart(Model model) {


        List<Mascota> mascotasDisponibles =mascotaService.findAllByEstadoOrderByIdDesc("DISPONIBLE");
        List<Mascota> mascotasAdoptadas =mascotaService.findAllByEstadoOrderByIdDesc("ADOPTADA");
        List<Mascota> mascotas=  new ArrayList<>();

        mascotas.addAll(mascotasDisponibles);
        mascotas.addAll(mascotasAdoptadas);

        Map<String,List<Mascota>> mascotasBySexo = mascotas.stream()
                .collect(Collectors.groupingBy(Mascota::getSexo));


        //first, add the regional sales
        Integer mascotasDisponiblesCant = mascotasDisponibles.size();
        Integer mascotasAdoptadasCant = mascotasAdoptadas.size();
        model.addAttribute("mascotasMacho", mascotasBySexo.get("MACHO").size());
        model.addAttribute("mascotasHembra", mascotasBySexo.get("HEMBRA").size());


        model.addAttribute("mascotasDisponibles", mascotasDisponiblesCant);
        model.addAttribute("mascotasAdpotadas", mascotasAdoptadasCant);


        //now add sales by lure type
        List<Integer> inshoreSales = Arrays.asList(4074, 3455, 4112);
        List<Integer> nearshoreSales = Arrays.asList(3222, 3011, 3788);
        List<Integer> offshoreSales = Arrays.asList(7811, 7098, 6455);

        model.addAttribute("inshoreSales", inshoreSales);
        model.addAttribute("nearshoreSales", nearshoreSales);
        model.addAttribute("offshoreSales", offshoreSales);

        return "statistics/chart";
    }

}
