package ar.edu.davinci.adoptame.DTO;


import java.util.Date;

public class PrestadorDTO extends PersonaDTO  {

    private String tipoServicio;
    private Integer vigencia;
    private String urlPago;
    private Date fechaVinculacion;
    private Date fechaFin;
    private String descripcion;
    private Float costo;
    private String titulo;
    private Integer id;
    private String telefono;

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

    public Date getFechaFin() { return fechaFin; }

    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }

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
