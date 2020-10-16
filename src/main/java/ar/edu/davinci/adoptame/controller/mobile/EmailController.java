package ar.edu.davinci.adoptame.controller.mobile;


import ar.edu.davinci.adoptame.DTO.MailMascotaDTO;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.service.EmailService;
import ar.edu.davinci.adoptame.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/mobile")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private MascotaService mascotaService;

    @PostMapping(path="/enviarMailMascota")
    public @ResponseBody ResponseEntity<String> createMail(@RequestBody  MailMascotaDTO emailObject){

        Mascota mascota= mascotaService.findById(emailObject.getIdMascota());
        StringBuilder sb = new StringBuilder("Te contactamos porque alguien");
        sb.append(" esta interesado en tu mascota ");
        sb.append(mascota.getNombre());
        sb.append(" ");
        sb.append(mascota.getDescripcion());
        sb.append(" por favor ponete en contacto con el a traves de ");
        sb.append(emailObject.getSenderName());
        emailObject.setText(sb.toString());
        emailObject.setTo(mascota.getRescatista().getEmail());
        emailObject.setSubject("Alguien quiere adoptar tu mascota");

        emailService.sendSimpleMessage(emailObject.getTo(),emailObject.getSubject(),emailObject.getText());

        return ResponseEntity.ok().body("Email Enviado");
    }


}
