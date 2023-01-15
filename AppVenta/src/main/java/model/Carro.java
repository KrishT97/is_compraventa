package model;

import java.util.ArrayList;
import java.util.List;

public class Carro {
    private final List<Producto> productos;

    public Carro() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setPrecioTotal(double suma) {
    }
}


