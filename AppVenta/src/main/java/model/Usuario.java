package model;

public class Usuario {
    private String nombre;
    private String correo;
    private String direccion;

    public Usuario() {
    }

    public void iniciarSesion(String nombre, String correo, String direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
    }

    public void cerrarSesion() {
        this.nombre = null;
        this.correo = null;
        this.direccion = null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }
}


