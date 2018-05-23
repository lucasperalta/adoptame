package ar.edu.davinci.adoptame.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="prestadores")

public class Prestador extends Persona implements Serializable {


    private static final long serialVersionUID = 7042244211641519912L;

    @Column(name="tipo_servicio")
	private String tipoServicio;

	@Column(name = "vigencia")
	private Integer vigencia;

    @Column(name="url_pago")
    private String urlPago;

    @Column(name="fechaVinculacion")
    private Date fechaVinculacion;


    public Prestador(){

    }


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
