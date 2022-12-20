package model;

import java.util.ArrayList;
import java.util.List;
public class Catalogo {
    private static List<Categoria> categorias;

    public static List<Categoria> getCategorias() {
        return categorias;
    }

    public static void iniciarCatalogo(){
        categorias = new ArrayList<>();
    }

    public static void anadirCategoria(Categoria nombreCategoria) {

        if(getCategorias().contains(nombreCategoria)){
            System.out.println("La categoría ya existe");
        }
        else{
            categorias.add(nombreCategoria);
        }

    }

    public static void eliminarCategoria(Categoria categoria) {

        categorias.remove(categoria);
    }
}
