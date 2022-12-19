package model;

import java.util.List;

public class Categoria {
    private String nombre;
    private static List<Producto> productos;

    public static List<Producto> getProductos() {
        return productos;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public void anadirProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }
}
