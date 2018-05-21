package ar.edu.davinci.adoptame.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="personas")
@NamedQueries({
	@NamedQuery(name = "persona.findAll",
			    query = "select p from Persona p"),
	@NamedQuery(name = "Persona.findByEmail",
		        query = "select p from Persona p where p.email = :email"),
	@NamedQuery(name = "Persona.findByApellido",
    query = "select p from Persona p where p.apePaterno = :apellido or p.apeMaterno = :apellido")
	})
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

//	public static final String PERSONA_FIND_ALL = "Persona.findAll";
//	public static final String PERSONA_FIND_BY_EMAIL = "Persona.findByEmail";
//	public static final String PERSONA_FIND_BY_APELLIDO = "Persona.findByApellido";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private Integer id;
	
	@Column(name="nombre", nullable = false, length = 45)
	private String nombre;
	
	@Column(name = "apellido", nullable = false, length = 45)
	private String apellido;
	

	@Column(name="email", nullable = false, length = 45)
	private String email;
	
	@Column(name="telefono", length = 45)
	private String telefono;



    public Persona() {
	}

    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
