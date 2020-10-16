package ar.edu.davinci.adoptame.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MailMascotaDTO {


    @Email
    @NotNull
    @Size(min = 1, message = "El email es invalido")
    private String to;
    private String recipientName;
    private String subject;
    private String text;
    private String senderName;
    private Long idMascota;
    private Long idAdoptante;

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public Long getIdAdoptante() {
        return idAdoptante;
    }

    public void setIdAdoptante(Long idAdoptante) {
        this.idAdoptante = idAdoptante;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }




}
