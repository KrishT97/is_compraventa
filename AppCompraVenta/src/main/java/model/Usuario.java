package model;

public class Usuario {

    private static String nombre;
    private static String contrasena;
    private static String correo;


    public static void iniciarSesion(String nombreUsuario, String contrasenaUsuario, String correoUsuario) {
        nombre = nombreUsuario;
        contrasena = contrasenaUsuario;
        correo = correoUsuario;
    }

    public void cerrarSesion() {
        // TODO: implementar la lógica para cerrar sesión
    }
}
