package ar.edu.davinci.adoptame.service;

import java.io.IOException;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text) throws IOException;
}
