package model;

public class Puntuacion {

    public static int agregarPuntuacion(int puntuacion) {
        // Validar la puntuación
        if (puntuacion < 1 || puntuacion > 10) {
            System.out.println("La puntuación debe estar entre 1 y 10.");
        }
        // Asignar la puntuación al producto
        return puntuacion;
    }
}