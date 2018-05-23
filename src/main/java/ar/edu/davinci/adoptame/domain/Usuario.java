package ar.edu.davinci.adoptame.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="usuarios")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("USUARIO")
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
}
