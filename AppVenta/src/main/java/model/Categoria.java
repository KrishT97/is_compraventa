package model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private final String nombreCategoria;
    private final List<Producto> productos;

    public Categoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
        this.productos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Categoria: " + nombreCategoria;
    }


    public Producto buscarProducto(String nombreProducto) {
        for (Producto producto : productos) {
            if (producto.getNombreProducto().equals(nombreProducto)) {
                return producto;
            }
        }
        return null;
    }


    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void anadirProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }
}






