package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.constantes.Constantes;
import ar.edu.davinci.adoptame.domain.Mascota;
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


@Controller
@RequestMapping(path="/admin")
public class AdminController {
	




    @Autowired
    private RolService rolService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MascotaService mascotaService;


    /**
     * redirecciona a la pantalla para administrar eventos
     * @param model
     * @return
     */
    @GetMapping("/eventos")
    public String admEventos(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "admin/admEventos";
    }

    /**
     * redirecciona a la pantala para administrar los servicios
     * @param model
     * @return
     */
    @GetMapping("/servicios")
    public String admServicios(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "admin/admServicios";
    }

    /**
     * redirecciona a la pantalla para administrar usuarios
     * @param model
     * @return
     */
    @GetMapping("/usuarios")
    public String admUsuarios(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "admin/admUsuarios";
    }


    /**
     * servicio que devuelve los datos para las estadisticas mostradas en la pagina web
     * @param model
     * @return
     */
    @RequestMapping(value = "/chart", method= RequestMethod.GET)
    public String chart(Model model) {


        List<Mascota> mascotasDisponibles =mascotaService.findAllByEstadoOrderByIdDesc(Constantes.DISPONIBLE);
        List<Mascota> mascotasAdoptadas =mascotaService.findAllByEstadoOrderByIdDesc(Constantes.ADOPTADA);
        List<Mascota> mascotas=  new ArrayList<>();

        mascotas.addAll(mascotasDisponibles);
        mascotas.addAll(mascotasAdoptadas);

        Map<String,List<Mascota>> mascotasBySexo = mascotas.stream()
                .collect(Collectors.groupingBy(Mascota::getSexo));

        Map<Integer,List<Mascota>> mascotasByEdad = mascotas.stream()
                .collect(Collectors.groupingBy(Mascota::getEdad));

        Map<String,List<Mascota>> mascotasByTipo = mascotas.stream()
                .collect(Collectors.groupingBy(Mascota::getTipoMascota));


        List<Integer>mascotasByEdadList = new ArrayList<>(
                Arrays.asList(0,0,0,0));

        mascotasByEdad.forEach((k, v) -> {

                                            switch (k){
                                                case 0:
                                                case 1:
                                                case 2:
                                                case 3:
                                                case 4:
                                                    Integer cant =mascotasByEdadList.get(0);
                                                    cant+=v.size();
                                                    mascotasByEdadList.set(0,cant);
                                                    break;
                                                case 5:
                                                case 6:
                                                case 7:
                                                case 8:
                                                case 9:
                                                    Integer cant1 =mascotasByEdadList.get(1);
                                                    cant1+=v.size();
                                                    mascotasByEdadList.set(1,cant1);
                                                    break;
                                                case 10:
                                                case 11:
                                                case 12:
                                                case 13:
                                                case 14:
                                                    Integer cant2 =mascotasByEdadList.get(2);
                                                    cant2+=v.size();
                                                    mascotasByEdadList.set(2,cant2);
                                                    break;
                                                default:
                                                    Integer cant3 =mascotasByEdadList.get(3);
                                                    cant3+=v.size();
                                                    mascotasByEdadList.set(3,cant3);

                                            }
                                            });



        Integer mascotasDisponiblesCant = mascotasDisponibles.size();
        Integer mascotasAdoptadasCant = mascotasAdoptadas.size();
        model.addAttribute("mascotasMacho", mascotasBySexo.get("MACHO").size());
        model.addAttribute("mascotasHembra", mascotasBySexo.get("HEMBRA").size());


        model.addAttribute("mascotasDisponibles", mascotasDisponiblesCant);
        model.addAttribute("mascotasAdpotadas", mascotasAdoptadasCant);
        model.addAttribute("mascotasByEdad", mascotasByEdadList);

        List<Integer>mascotasPerro = new ArrayList<>(Arrays.asList(mascotasByTipo.get("PERRO").size()));
        List<Integer>mascotasGato = new ArrayList<>(Arrays.asList(mascotasByTipo.get("GATO").size()));

        model.addAttribute("mascotasPerro", mascotasPerro);
        model.addAttribute("mascotasGato",mascotasGato );


        return "statistics/chart";
    }

}
