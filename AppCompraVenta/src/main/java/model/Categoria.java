package model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private static List<Producto> productos;

    public Categoria( Catalogo catalogo ,String categoria){
        if (catalogo.getCategorias().contains(categoria)){
            productos = new ArrayList<>();
        }
    }

    public static List<Producto> getProductos() {
        return productos;
    }

    public void anadir(Producto producto) {
        productos.add(producto);
    }

    public void eliminar(Integer id) {
        Producto.ids.remove(id);
    }
}
