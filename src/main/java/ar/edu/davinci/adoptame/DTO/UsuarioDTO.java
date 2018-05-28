package ar.edu.davinci.adoptame.DTO;

import ar.edu.davinci.adoptame.domain.Estado;
import ar.edu.davinci.adoptame.domain.Persona;
import ar.edu.davinci.adoptame.domain.Rol;

import javax.persistence.*;
import java.io.Serializable;


public class UsuarioDTO extends PersonaDTO  {


    private String estado;


    private String password;


    private  String rol;

    public UsuarioDTO() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
