package ar.edu.davinci.adoptame.domain;

import ar.edu.davinci.adoptame.DTO.EventosDTO;
import ar.edu.davinci.adoptame.controller.EventosController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="eventos")
public class Eventos implements Serializable {


    private static final long serialVersionUID = 2851308311173264136L;

    @Transient
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    @Transient
    private static final Logger logger = LoggerFactory.getLogger(EventosController.class);

    public Eventos(EventosDTO eventosDTO) {
        this.direccion = eventosDTO.getDireccion();
        try {
            this.dias = format.parse(eventosDTO.getDias()) ;
        } catch (ParseException e) {
            logger.info("hubo un error al parsear la fecha se asigna la fecha actual");
            this.dias= new Date();
        }
        this.horarios = eventosDTO.getHorarios();
        this.lugar = eventosDTO.getLugar();
        this.barrio = eventosDTO.getBarrio();
        this.consultas = eventosDTO.getConsultas();
    }

    public Eventos() {

    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

    @Column(name = "direccion")
    private String direccion;

    @Temporal(TemporalType.DATE)

    @Column(name = "dias")
    private Date dias;

    @Column(name = "horarios")
    private String horarios;

    @Column(name = "lugar")
    private String lugar;

    @Column(name = "barrio")
    private String barrio;



    @Column(name = "consultas")
    private String consultas;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }






    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getDias() {
        return dias;
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


    public String getConsultas() {
        return consultas;
    }

    public void setConsultas(String consultas) {
        this.consultas = consultas;
    }




}
