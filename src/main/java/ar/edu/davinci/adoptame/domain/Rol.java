package ar.edu.davinci.adoptame.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="roles")
@NamedQuery(name = "Rol.findRolByNombreRol",query = "select p from Rol p where p.nombreRol = :nombreRol")

public class Rol implements Serializable {


	private static final long serialVersionUID = -2957279687678642582L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private Long id;

	@Column(name = "nombre_rol")
	private String nombreRol;

    @ManyToMany
    @JoinTable(name="rol_permiso",
            joinColumns={@JoinColumn(name="id_rol", referencedColumnName="id_rol")},
            inverseJoinColumns={@JoinColumn(name="id_permiso", referencedColumnName="id_permiso")})
    private List<Permiso> permisos;

    public Rol() {

    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}
}
