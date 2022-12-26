package model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private static List<Producto> productos;

    public static void listarProductos(String categoria){
        if (Catalogo.getCategorias().contains(categoria)){
            productos = new ArrayList<>();
        }

    }

    public double getPrecioPorId(int id) {
        for (Producto producto : productos) {
            for(Integer idProducto: Producto.getIds()){
                if (idProducto == id) {
                    return producto.getPrecio();
                }
            }
        }
        return 0.0;
    }

    public void anadir(Producto producto) {
        productos.add(producto);
    }

    public void eliminar(Integer id) {
        Producto.ids.remove(id);
    }
}
