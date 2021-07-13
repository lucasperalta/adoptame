package ar.edu.davinci.adoptame.domain;

import ar.edu.davinci.adoptame.DTO.MascotaDTO;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="motivosdenuncia")

public class MotivosDenuncia implements Serializable {

    private static final long serialVersionUID =  8993521390607278076L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_motivo")
    private int idMotivo;

    @Column(name="motivo", nullable = false, length = 200)
    private String motivo;

    @Column(name="publico")
    private Boolean publico;


    public MotivosDenuncia() {

    }

    public MotivosDenuncia(String motivo, Boolean publico) {
        this.motivo = motivo;
        this.publico = publico;
    }

    public int getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(int idMotivo) {
        this.idMotivo = idMotivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Boolean getPublico() {
        return publico;
    }

    public void setPublico(Boolean publico) {
        this.publico = publico;
    }

}
