package model;

public class Usuario {

    private String nombre;
    private String correo;

    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }

    public void iniciar(String nombreUsuario, String correoUsuario) {
        this.nombre = nombreUsuario;
        this.correo = correoUsuario;
    }
}
