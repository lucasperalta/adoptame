package ar.edu.davinci.adoptame.controller.mobile;


import ar.edu.davinci.adoptame.DTO.MailMascotaDTO;
import ar.edu.davinci.adoptame.constantes.Constantes;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.exception.EmailException;
import ar.edu.davinci.adoptame.service.EmailService;
import ar.edu.davinci.adoptame.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping(path="/mobile")
public class EmailController {


    @Autowired
    private EmailService emailService;

    @Autowired
    private MascotaService mascotaService;


    /**
     * envia mail cuando se adopta una mascotas
     * @param emailObject
     * @return
     */
    /** @PostMapping(path="/enviarMailMascota")
    public @ResponseBody ResponseEntity<String> createMail(@RequestBody  MailMascotaDTO emailObject){

        try {
            Mascota mascota= mascotaService.findById(emailObject.getIdMascota());
            StringBuilder sb = new StringBuilder(Constantes.TE_CONTACTAMOS_PORQUE_ALGUIEN);
            sb.append(Constantes.ESTA_INTERESADO_EN_TU_MASCOTA);
            sb.append(mascota.getNombre());
            sb.append(" ");
            sb.append(mascota.getDescripcion());
            sb.append(Constantes.POR_FAVOR_PONETE_EN_CONTACTO_CON_EL_A_TRAVES_DE);
            sb.append(emailObject.getSenderName());
            emailObject.setText(sb.toString());
            emailObject.setTo(mascota.getRescatista().getEmail());
            emailObject.setSubject(Constantes.ALGUIEN_QUIERE_ADOPTAR_TU_MASCOTA);
            emailService.sendSimpleMessage(emailObject.getTo(),emailObject.getSubject(),emailObject.getText());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Ha ocurrido un error al enviar el mail");

        }

        return ResponseEntity.ok().body("Email Enviado");
    }
    **/


}
