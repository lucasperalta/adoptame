package ar.edu.davinci.adoptame.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="usuarios")

public class Usuario extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private Integer idPersona;

	@Column(name="estado", length = 45)
	private String estado;

	//TODO many to one
	private Coordenada coordenada;

    public Usuario() {

    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }
}
