package model;

import java.util.ArrayList;
import java.util.List;

public class Carro {
    public static List<Integer> idProductosSeleccionados;

    static double precioTotal;

    public static List<Integer> getIdProductosSeleccionados() {
        return idProductosSeleccionados;
    }

    public Carro(){
        idProductosSeleccionados = new ArrayList<>();

    }

    public void setIdProductosSeleccionados(List<Integer> idProductosSeleccionados) {
        Carro.idProductosSeleccionados = idProductosSeleccionados;
    }

    public static double getPrecioTotal() {
        return precioTotal;
    }

    public static void calcularSuma(double precio) {
        precioTotal += precio;


    }
}
