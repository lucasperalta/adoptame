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
	private Long latitud;

	@Column(name = "longitud")
	private Long longitud;

    public Coordenada() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getLatitud() {
        return latitud;
    }

    public void setLatitud(Long latitud) {
        this.latitud = latitud;
    }

    public Long getLongitud() {
        return longitud;
    }

    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }
}
