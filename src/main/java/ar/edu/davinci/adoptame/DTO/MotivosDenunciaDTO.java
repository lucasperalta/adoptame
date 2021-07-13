package ar.edu.davinci.adoptame.DTO;


import ar.edu.davinci.adoptame.domain.MotivosDenuncia;

import java.text.SimpleDateFormat;

public class MotivosDenunciaDTO {

    public MotivosDenunciaDTO() {
    }

    public MotivosDenunciaDTO(MotivosDenuncia motivosDenuncia) {
        this.idMotivo = motivosDenuncia.getIdMotivo();
        this.motivo = motivosDenuncia.getMotivo();
        this.publico = motivosDenuncia.getPublico();
    }


    private int idMotivo;
    private String motivo;
    private Boolean publico;


    public int getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(int idMotivo) {
        this.idMotivo = idMotivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Boolean getPublico() {
        return publico;
    }

    public void setPublico(Boolean publico) {
        this.publico = publico;
    }
}
