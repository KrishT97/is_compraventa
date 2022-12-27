package model;

import java.util.ArrayList;
import java.util.List;
public class Catalogo {
    private List<String> categorias;

    public List<String> getCategorias() {
        return categorias;
    }

    public void iniciarCatalogo(){
        categorias = new ArrayList<>();
    }

    public double getPrecioPorId(int id) {
        for (Producto producto : Categoria.getProductos()) {
            for(Integer idProducto: Producto.getIds()){
                if (idProducto == id) {
                    return producto.getPrecio();
                }
            }
        }
        return 0.0;
    }

    public void anadirCategoria(String nombreCategoria) {

        if (getCategorias().contains(nombreCategoria)) {
            System.out.println("La categoría ya existe.");
        } else {
            categorias.add(nombreCategoria);
        }

    }
}
