package ar.edu.davinci.adoptame.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="coordenadas")

public class Coordenada implements Serializable {


    private static final long serialVersionUID = 3004996156743910088L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_coordenada")
	private Integer id;

	@Column(name = "latitud")
	private Double latitud;

	@Column(name = "longitud")
	private Double longitud;

    public Coordenada() {

    }

    public Coordenada(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}
