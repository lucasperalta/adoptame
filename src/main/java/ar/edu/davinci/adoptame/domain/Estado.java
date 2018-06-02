package ar.edu.davinci.adoptame.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="estados")
@NamedQuery(name = "Estado.findEstadoByDescripcion",query = "select p from Estado p where p.estado = :descripcion")
public class Estado implements Serializable {


    private static final long serialVersionUID = 2851308311173264136L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado")
	private Long id;

	@Column(name = "estado")
	private String estado;



    public Estado() {

    }


    public Estado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
