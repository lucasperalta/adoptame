package ar.edu.davinci.adoptame.domain;

import ar.edu.davinci.adoptame.DTO.MascotaDTO;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mascotas")
@NamedQueries({
        @NamedQuery(name = "Mascota.findAllByEstado", query = "select p from Mascota p where p.estado = :estado"),

})
public class Mascota implements Serializable {


    private static final long serialVersionUID = 4293421164107278076L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long id;

    @Column(name="nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "sexo", nullable = false, length = 45)
    private String sexo;

    @Column(name = "tipo_mascota", length = 45)
    private String tipoMascota;

    @Column(name="raza", nullable = false, length = 45)
    private String raza;

    @Column(name="edad")
    private Integer edad;

    @Column(name="foto_url")
    private String foto_url;

    @Column(name="estado")
    private String estado;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="tamanio")
    private String tamanio;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="id")
    private Usuario rescatista;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_coordenada")
    private Coordenada coordenadas;

    @Column(name="activa")
    private Boolean activa;

    @Column(name="fecha_inicio")
    private Date fechaInicio;

    @Column(name="fecha_fin")
    private Date fechaFin;

    @Column(name="id_adpotante")
    private Integer idAdoptante;


    public Mascota() {

    }

    public Mascota(String nombre, String sexo, String tipoMascota, String raza, Integer edad, String foto_url, String estado, String descripcion,
                   String tamanio, Usuario rescatista, Coordenada coordenadas, Boolean activa, Date fechaInicio, Date fechaFin, Integer idAdoptante) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.tipoMascota = tipoMascota;
        this.raza = raza;
        this.edad = edad;
        this.foto_url = foto_url;
        this.estado = estado;
        this.descripcion = descripcion;
        this.tamanio = tamanio;
        this.rescatista = rescatista;
        this.coordenadas = coordenadas;
        this.activa = activa;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idAdoptante = idAdoptante;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getFoto_url() {
        return foto_url;
    }

    public void setFoto_url(String foto_url) {
        this.foto_url = foto_url;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public Usuario getRescatista() {
        return rescatista;
    }

    public void setRescatista(Usuario rescatista) {
        this.rescatista = rescatista;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
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


    public Integer getIdAdoptante() {
        return idAdoptante;
    }

    public void setIdAdoptante(Integer idAdoptante) {
        this.idAdoptante = idAdoptante;
    }

    public Coordenada getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }
}
