package ar.edu.davinci.adoptame.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="prestadores")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("USUARIO")
//@NamedQueries({
//        @NamedQuery(name = "Usuario.buscarUsuarioByEmail", query = "select p from Usuario p where p.email = :email"),
//        @NamedQuery(name = "Usuario.findAdmin", query = "select p from Usuario p where p.email = :email and p.password=:password and rol=1")
//})

public class Prestador extends Persona implements Serializable {


    private static final long serialVersionUID = 7042244211641519912L;


    @Column(name="url_pago")
    private String urlPago;

    @Column(name="fecha_vinculacion")
    private Date fechaVinculacion;

    @Column(name="tipo_servicio")
    private String tipoServicio;


    public Prestador(){

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

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}
