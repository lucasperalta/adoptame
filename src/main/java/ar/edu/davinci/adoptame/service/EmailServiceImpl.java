package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.constantes.Constantes;
import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    /**
     * envia mail usando java mail a traves de GMAIL
     * @param to
     * @param subject
     * @param text
     */
    @Override
    public void sendSimpleMessage(String to, String subject, String text) throws IOException {
        try {


            Email from = new Email(Constantes.FROM_ADDRESS);

            Email to2 = new Email(to);
            Content content = new Content("text/plain", text);
            Mail mail = new Mail(from, subject, to2, content);

            SendGrid sg = new SendGrid("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");
            Request request = new Request();
            try {
                request.setMethod(Method.POST);
                request.setEndpoint("mail/send");
                request.setBody(mail.build());
                Response response = sg.api(request);
                System.out.println(response.getStatusCode());
                System.out.println(response.getBody());
                System.out.println(response.getHeaders());
            } catch (IOException ex) {
                throw ex;
            }


        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }
}
