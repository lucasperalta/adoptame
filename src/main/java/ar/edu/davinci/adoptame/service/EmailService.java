package ar.edu.davinci.adoptame.service;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text) ;
}
