package ar.edu.davinci.adoptame.DTO;


import java.util.Date;

public class PrestadorDTO extends PersonaDTO  {

    private String tipoServicio;
    private Integer vigencia;
    private String urlPago;
    private Date fechaVinculacion;
    private String fechaFin;
    private String descripcion;
    private Float costo;
    private String titulo;
    private Integer id;
    private String telefono;
    private String direccion;
    private Integer idServicio;

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getDireccion() {
        return direccion;
    }



    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public Integer getId() { return id; }

    @Override
    public void setId(Integer id) { this.id = id; }


    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Float getCosto() { return costo; }

    public void setCosto(Float costo) { this.costo = costo; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String costo) { this.descripcion = costo; }

    public String getTipoServicio() { return tipoServicio; }

    public void setTipoServicio(String tipoServicio) { this.tipoServicio = tipoServicio; }

    public Integer getVigencia() { return vigencia; }

    public void setVigencia(Integer vigencia) { this.vigencia = vigencia; }

    public String getUrlPago() {return urlPago;}

    public void setUrlPago(String urlPago) { this.urlPago = urlPago; }

    public Date getFechaVinculacion() {return fechaVinculacion; }

    public void setFechaVinculacion(Date fechaVinculacion) { this.fechaVinculacion = fechaVinculacion; }
}
