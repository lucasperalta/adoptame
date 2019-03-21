package ar.edu.davinci.adoptame.DTO;



import ar.edu.davinci.adoptame.domain.Eventos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventosDTO {


    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public EventosDTO() {
    }

    public EventosDTO(Eventos eventos) {
       tipoAtencion=eventos.getTipoAtencion();
       direccion=eventos.getDireccion();
       dias=eventos.getDias();
       horarios=eventos.getHorarios();
       lugar=eventos.getLugar();
       barrio=eventos.getBarrio();
       comuna=eventos.getComuna();
       consultas=eventos.getConsultas();

    }
    private String tipoAtencion;

    private String direccion;

    private Date dias;

    private String horarios;

    private String lugar;

    private String barrio;

    private String comuna;

    private String consultas;

    public String getTipoAtencion() {
        return tipoAtencion;
    }

    public void setTipoAtencion(String tipoAtencion) {
        this.tipoAtencion = tipoAtencion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDias() {
//lo retorno como un String formateado
        return format.format(dias);
    }

    public void setDias(Date dias) {
        this.dias = dias;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getConsultas() {
        return consultas;
    }

    public void setConsultas(String consultas) {
        this.consultas = consultas;
    }
}
