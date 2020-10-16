package ar.edu.davinci.adoptame.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="usuarios")

@NamedQueries({
        @NamedQuery(name = "Usuario.buscarUsuarioByEmail", query = "select p from Usuario p where p.email = :email"),
        @NamedQuery(name = "Usuario.findAdmin", query = "select p from Usuario p where p.email = :email and p.password=:password and rol=1")
})
public class Usuario extends Persona implements Serializable {


    private static final long serialVersionUID = 1548205958242267599L;


    @Column(name="password")
    private String password;

    @ManyToOne
    @JoinColumn(name="id_rol")
    private  Rol rol;

    public Usuario() {

    }

    public Usuario(String nombre, String apellido, String email, String password, Rol rol,String telefono,String ubicacion) {
        super(nombre, apellido, email,telefono,ubicacion);
        this.password = password;
        this.rol = rol;
    }



    public String getPassword() {
        return password;
    }




    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "password='" + password + '\'' +
                ", rol=" + rol +
                '}';
    }
}
