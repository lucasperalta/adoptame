package ar.edu.davinci.adoptame.controller.mobile;


import ar.edu.davinci.adoptame.DTO.MailDTO;
import ar.edu.davinci.adoptame.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/mobile")
public class EmailController {

    @Autowired
    private EmailService emailService;



    @PostMapping(path="/enviarMail")
    public @ResponseBody ResponseEntity<String> createMail(@RequestBody @Valid MailDTO emailObject){

        emailService.sendSimpleMessage(emailObject.getTo(),emailObject.getSubject(),emailObject.getText());

        return ResponseEntity.ok().body("Email Enviado");
    }


}
