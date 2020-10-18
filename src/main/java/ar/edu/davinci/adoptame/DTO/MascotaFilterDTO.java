package ar.edu.davinci.adoptame.DTO;


import ar.edu.davinci.adoptame.domain.Mascota;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class MascotaFilterDTO {

    public MascotaFilterDTO() {
    }

    public MascotaFilterDTO(Mascota mascota) {


    }


    private Long id;

    private String nombre;

    private List<String> sexo;

    private String tipoMascota;

    private String raza;

    private Integer edad;

    private String foto_url;

    private String estado;

    private String descripcion;

    private List<String> tamanio;

    private String rescatista;

    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    private Double longitud;
    private Double latitud;
    private Integer distancia;

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
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

    public List<String> getSexo() {
        return sexo;
    }

    public void setSexo(List<String> sexo) {
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

    public List<String> getTamanio() {
        return tamanio;
    }

    public void setTamanio(List<String> tamanio) {
        this.tamanio = tamanio;
    }

    public String getRescatista() {
        return rescatista;
    }

    public void setRescatista(String rescatista) {
        this.rescatista = rescatista;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }





}
