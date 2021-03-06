package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.constantes.Constantes;
import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailServiceImpl implements EmailService {


    @Value("LALALA")
    private String sendGridApiKey;


    /**
     * envia mail usando java mail a traves de SENDGRID usando una cuenta de gmail
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

            System.out.println("api key sendgrid"+ sendGridApiKey);
            SendGrid sg = new SendGrid(sendGridApiKey);
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

            System.out.println(exception.getStackTrace());
            exception.printStackTrace();
        }
    }
}
