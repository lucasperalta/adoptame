package ar.edu.davinci.adoptame.DTO;


import ar.edu.davinci.adoptame.domain.Mascota;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MascotaDTO {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public MascotaDTO() {
    }

    public MascotaDTO(Mascota mascota) {
        this.id = mascota.getId();
        this.nombre = mascota.getNombre();
        this.sexo = mascota.getSexo();
        this.tipoMascota = mascota.getTipoMascota();
        this.raza = mascota.getRaza();
        this.edad = mascota.getEdad();
        this.foto_url = mascota.getFoto_url();
        this.estado = mascota.getEstado();
        this.descripcion = mascota.getDescripcion();
        this.tamanio = mascota.getTamanio();
        this.rescatista = mascota.getRescatista().getNombre();
        this.activa = mascota.getActiva();
        this.fechaFin = mascota.getFechaFin();
        this.fechaInicio = mascota.getFechaInicio();
        this.idAdoptante = mascota.getIdAdoptante();
        this.latitud=mascota.getCoordenadas()!=null?mascota.getCoordenadas().getLatitud():null;
        this.longitud=mascota.getCoordenadas()!=null?mascota.getCoordenadas().getLongitud():null;
        this.fechaInicioS = format.format(mascota.getFechaInicio());
    }


    private Long id;

    private String nombre;

    private String sexo;



    private String tipoMascota;

    private String raza;

    private Integer edad;

    private String foto_url;

    private String estado;

    private String descripcion;

    private String tamanio;

    private String rescatista;

    private Boolean cambioFoto;

    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    private Double longitud;
    private Double latitud;

    private Boolean activa;
    private Integer idAdoptante;
    private Date fechaFin;
    private Date fechaInicio;
    private String fechaInicioS;

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

    public Boolean getCambioFoto() {
        return cambioFoto;
    }

    public void setCambioFoto(Boolean cambioFoto) {
        this.cambioFoto = cambioFoto;
    }

}
