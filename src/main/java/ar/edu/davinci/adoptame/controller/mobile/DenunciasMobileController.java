package ar.edu.davinci.adoptame.controller.mobile;

import ar.edu.davinci.adoptame.DTO.DenunciaDTO;
import ar.edu.davinci.adoptame.DTO.MotivosDenunciaDTO;
import ar.edu.davinci.adoptame.controller.EventosController;
import ar.edu.davinci.adoptame.domain.Denuncias;
import ar.edu.davinci.adoptame.domain.MotivosDenuncia;
import ar.edu.davinci.adoptame.service.DenunciasService;
import ar.edu.davinci.adoptame.service.MotivosDenunciaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(path="/mobile")
public class DenunciasMobileController {


    private static final Logger logger = LoggerFactory.getLogger(EventosController.class);
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    @Autowired
    MotivosDenunciaService motivosDenunciaService;

    @Autowired
    DenunciasService denunciasService;

    /**
     * listo todos los eventos desde el dia actual a un mes
     * @param params
     * @return
     */

    @PostMapping("/addDenuncia")
    public @ResponseBody String addDenuncia(@ModelAttribute DenunciaDTO params) {
        if(params.getIdMotivo() == 0) //otro motivo
        {
            MotivosDenunciaDTO motivo = new MotivosDenunciaDTO();
            motivo.setPublico(false);
            motivo.setMotivo(params.getOtro());
            MotivosDenuncia nuevoMotivo = motivosDenunciaService.addMotivo(motivo); //agrego el motivo
            params.setIdMotivo(nuevoMotivo.getIdMotivo());
        }

        DenunciaDTO denuncia = new DenunciaDTO();
        denuncia.setIdMascota(params.getIdMascota());
        denuncia.setIdPersona(params.getIdPersona());
        denuncia.setIdMotivo(params.getIdMotivo());
        denuncia.setFecha(new Date());

        denunciasService.addDenuncias(denuncia);

        return "Ok";
    }

    /**
     * agrego denuncia
     * @param model
     * @return
     */

    @GetMapping("/motivosDenuncia")
    public @ResponseBody  List<MotivosDenunciaDTO> listarMotivos(Model model) {

        List<MotivosDenuncia> motivos = motivosDenunciaService.listarMotivosDenuncia();
        List<MotivosDenunciaDTO> motivosDTOS= new ArrayList<>();
        for (MotivosDenuncia motivo:motivos) {
            MotivosDenunciaDTO motivoDTO = new MotivosDenunciaDTO(motivo);
            motivosDTOS.add(motivoDTO);
        }
        logger.info("eventos"+motivosDTOS);
        return motivosDTOS;
    }



}
