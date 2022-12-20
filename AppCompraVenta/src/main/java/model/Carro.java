package model;

import java.util.ArrayList;
import java.util.List;

public class Carro {

    private static List<Producto> productosAgregados;

    public static void inicializarCarro() {
        productosAgregados = new ArrayList<>();
    }

    public static void setProductosAgregados(Producto producto) {
        productosAgregados.add(producto);
    }


    public static double calcularTotal() {
        double precioTotal = 0;
        for (Producto producto : productosAgregados) {
            precioTotal += producto.getPrecio();
        }
        return precioTotal;


    }
}
