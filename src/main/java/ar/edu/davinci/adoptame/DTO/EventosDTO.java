package ar.edu.davinci.adoptame.DTO;



import ar.edu.davinci.adoptame.domain.Eventos;


import java.text.SimpleDateFormat;

public class EventosDTO {


    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public EventosDTO() {
    }

    public EventosDTO(Eventos eventos) {
        id=eventos.getId();
       direccion=eventos.getDireccion();
       dias=format.format(eventos.getDias()) ;
       horarios=eventos.getHorarios();
       lugar=eventos.getLugar();
       barrio=eventos.getBarrio();
       consultas=eventos.getConsultas();

    }


    private Long id;

    private String direccion;


    private String dias;

    private String horarios;


    private String lugar;

    private String barrio;

    private String consultas;



    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getConsultas() {
        return consultas;
    }

    public void setConsultas(String consultas) {
        this.consultas = consultas;
    }
}
