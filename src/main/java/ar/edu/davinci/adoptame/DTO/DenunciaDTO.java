package ar.edu.davinci.adoptame.DTO;


import ar.edu.davinci.adoptame.domain.Denuncias;

import java.util.Date;

public class DenunciaDTO {

    public DenunciaDTO() {
    }

    public DenunciaDTO(Denuncias denuncias) {
        //this.idDenuncia = denuncias.getIdDenuncia();
        this.idMascota = denuncias.getIdMascota();
        this.idPersona = denuncias.getIdPersona();
        this.idMotivo = denuncias.getIdMotivo();
        //this.fecha = denuncias.getFecha();
    }


    private int idMotivo;
    private Long idDenuncia;
    private Long idMascota;
    private Long idPersona;
    private Date fecha;
    private String otro;


    public Long getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(Long idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(int idMotivo) {
        this.idMotivo = idMotivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }
}
