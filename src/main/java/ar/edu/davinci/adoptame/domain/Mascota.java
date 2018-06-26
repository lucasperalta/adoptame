package ar.edu.davinci.adoptame.domain;

import javax.persistence.*;
import java.io.Serializable;

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
	private Integer id;

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
    @JoinColumn(name="id")
    private Usuario rescatista;

    @ManyToOne
    @JoinColumn(name="id_coordenada")
    private Coordenada coordenadas;




    public Mascota() {

	}

    public Mascota(String nombre, String sexo, String tipoMascota, String raza, Integer edad, String foto_url, String estado, String descripcion, String tamanio, Usuario rescatista, Coordenada coordenadas) {
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

    public Coordenada getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }
}
