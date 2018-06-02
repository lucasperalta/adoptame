package ar.edu.davinci.adoptame.DTO;


import java.util.Date;

public class PrestadorDTO extends PersonaDTO  {

    private String tipoServicio;
    private Integer vigencia;
    private String urlPago;
    private Date fechaVinculacion;

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public String getUrlPago() {
        return urlPago;
    }

    public void setUrlPago(String urlPago) {
        this.urlPago = urlPago;
    }

    public Date getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(Date fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }
}
