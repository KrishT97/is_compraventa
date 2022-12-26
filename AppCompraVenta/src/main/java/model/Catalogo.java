package model;

import java.util.ArrayList;
import java.util.List;
public class Catalogo {
    private static List<String> categorias;

    public static List<String> getCategorias() {
        return categorias;
    }

    public static void iniciarCatalogo(){
        categorias = new ArrayList<>();
    }

    public static void anadirCategoria(String nombreCategoria) {

        if (getCategorias().contains(nombreCategoria)) {
            System.out.println("La categoría ya existe.");
        } else {
            categorias.add(nombreCategoria);
        }

    }
}
