package model;

import java.util.List;
public class Catalogo {
    private static List<Categoria> categorias;

    public static List<Categoria> getCategorias() {
        return categorias;
    }

    public void añadirCategoria(String nombreCategoria) {
        Categoria categoria = new Categoria(nombreCategoria);
    }

    public void eliminarCategoria(Categoria categoria) {
        categorias.remove(categoria);
    }
}
