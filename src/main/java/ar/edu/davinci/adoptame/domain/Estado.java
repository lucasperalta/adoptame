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
	private Integer id;

	@Column(name = "estado")
	private String estado;



    public Estado() {

    }


    public Estado(String estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
