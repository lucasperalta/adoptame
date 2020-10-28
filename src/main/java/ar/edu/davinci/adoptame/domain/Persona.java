package ar.edu.davinci.adoptame.domain;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo_persona")
@Table(name="personas")

public abstract class Persona implements Serializable {

    private static final long serialVersionUID = 2719272463483141301L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  @SequenceGenerator(name="personas_id_seq", sequenceName="personas_id_seq", allocationSize=1)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="personas_id_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name="nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;


    @Column(name="email", nullable = false, length = 45)
    private String email;

    @Column(name="telefono", nullable = true, length = 45)
    private String telefono;

    @Column(name="ubicacion", nullable = true, length = 45)
    private String ubicacion;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String email,String telefono,String ubicacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono=telefono;
        this.ubicacion=ubicacion;

    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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


}
