package ar.edu.davinci.adoptame.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="permisos")

public class Permiso implements Serializable {


	private static final long serialVersionUID = -556314904137288225L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_permiso")
	private Integer id;

	@Column(name = "nombre_permiso")
	private String nombre_permiso;


    public Permiso() {

    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre_permiso() {
		return nombre_permiso;
	}

	public void setNombre_permiso(String nombre_permiso) {
		this.nombre_permiso = nombre_permiso;
	}
}
