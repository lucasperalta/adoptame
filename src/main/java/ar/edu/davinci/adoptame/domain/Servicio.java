package ar.edu.davinci.adoptame.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="servicios")
//@NamedQueries({
//        @NamedQuery(name = "Usuario.buscarUsuarioByEmail", query = "select p from Usuario p where p.email = :email"),
//        @NamedQuery(name = "Usuario.findAdmin", query = "select p from Usuario p where p.email = :email and p.password=:password and rol=1")
//})

public class Servicio implements Serializable {


    private static final long serialVersionUID = 7042244211641519912L;

    @ManyToOne
    @JoinColumn(name = "id")
    private Prestador prestador;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer id_servicio;

    @Column(name="titulo")
    private String titulo;

    @Column(name="tipo_servicio")
    private String tipo_servicio;

    @Column(name="fechaInicio")
    private Date fechaInicio;

    @Column(name="fechaFin")
    private Date fechaFin;

    @Column(name="costo")
    private Float costo;

    @Column(name="vigencia")
    private String vigencia;

    @Column(name="descripcion")
    private String descripcion;

    public Servicio() {

    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public Integer getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



}
