package ar.edu.davinci.adoptame.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="prestadores")
public class Prestador  implements Serializable {


    private static final long serialVersionUID = 7042244211641519912L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;


    @Column(name="email", nullable = false, length = 45)
    private String email;




    @Column(name="fecha_vinculacion")
    private Date fechaVinculacion;



    @Column(name="tipo_servicio")

    private String tipoServicio;

    @Column(name="telefono")

    private String telefono;

    public Prestador(){

    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
