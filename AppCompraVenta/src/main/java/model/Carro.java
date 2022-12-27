package model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class Carro {
    public  List<Integer> idProductosSeleccionados;

    double precioTotal;

    public  List<Integer> getIdProductosSeleccionados() {
        return idProductosSeleccionados;
    }

    public Carro(){
        idProductosSeleccionados = new ArrayList<>();

    }

    public void setIdProductosSeleccionados(List<Integer> idProductosSeleccionados) {
        this.idProductosSeleccionados = idProductosSeleccionados;
    }

    public double getPrecioTotal() {
        return (double) round(precioTotal*100)/100;
    }

    public void calcularSuma(double precio) {
        precioTotal += precio;


    }
}
