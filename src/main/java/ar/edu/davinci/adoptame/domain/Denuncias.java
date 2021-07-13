package ar.edu.davinci.adoptame.domain;

import ar.edu.davinci.adoptame.DTO.EventosDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="denuncias")

public class Denuncias implements Serializable {

    private static final long serialVersionUID = 4293521364607278076L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_denuncia")
    private Long idDenuncia;

    @Column(name="id_mascota")
    private Long idMascota;

    @Column(name="id_persona")
    private Long idPersona;

    @Column(name="id_motivo")
    private int idMotivo;

    @Column(name="fecha")
    private Date fecha;

    public Denuncias() {

    }

    public Denuncias(Long idMascota, Long idPersona, int idMotivo, Date fecha) {
        this.idMascota = idMascota;
        this.idPersona = idPersona;
        this.idMotivo = idMotivo;
        this.fecha = fecha;
    }
    public Long getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(Long idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(int idMotivo) {
        this.idMotivo = idMotivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


}
