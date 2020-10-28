package ar.edu.davinci.adoptame.DTO;

import ar.edu.davinci.adoptame.domain.Usuario;


public class UsuarioDTO extends PersonaDTO  {





    private String password;


    private  String rol;

    public UsuarioDTO() {

    }

    public UsuarioDTO(Usuario usuario) {
        super(usuario.getNombre(),usuario.getApellido(),usuario.getEmail(),usuario.getTelefono(),usuario.getUbicacion());
        this.password=usuario.getPassword();

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


}
