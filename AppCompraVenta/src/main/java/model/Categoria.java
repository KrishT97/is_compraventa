package model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nombre;
    private static List<Producto> productos;

    public static void listarProductos(Categoria categoria){
        if (Catalogo.getCategorias().contains(categoria)){
            productos = new ArrayList<>();
        }

    }

    public static List<Producto> getProductos() {
        return productos;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public static void anadirProducto(Producto producto) {
        productos.add(producto);
    }

    public static void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }
}
