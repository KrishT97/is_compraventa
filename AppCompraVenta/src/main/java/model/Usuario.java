package model;

public class Usuario {

    private static String nombre;
    private static String correo;

    public static String getNombre() {
        return nombre;
    }
    public static String getCorreo() {
        return correo;
    }

    public static void iniciar(String nombreUsuario, String correoUsuario) {
        nombre = nombreUsuario;
        correo = correoUsuario;
    }
}
