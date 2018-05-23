package ar.edu.davinci.adoptame.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="roles")

public class Rol implements Serializable {


	private static final long serialVersionUID = -2957279687678642582L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private Integer id;

	@Column(name = "nombre_rol")
	private String nombre_rol;

    @ManyToMany
    @JoinTable(name="rol_permiso",
            joinColumns={@JoinColumn(name="id_rol", referencedColumnName="id_rol")},
            inverseJoinColumns={@JoinColumn(name="id_permiso", referencedColumnName="id_permiso")})
    private List<Permiso> permisos;

    public Rol() {

    }


}
