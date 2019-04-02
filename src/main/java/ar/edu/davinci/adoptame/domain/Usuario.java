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

    @OneToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @Column(name="password")
    private String password;

    @ManyToOne
    @JoinColumn(name="id_rol")
    private  Rol rol;

    public Usuario() {

    }

    public Usuario(String nombre, String apellido, String email, Estado estado, String password, Rol rol) {
        super(nombre, apellido, email);
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "estado=" + estado +
                ", rol=" + rol +
                '}';
    }
}
