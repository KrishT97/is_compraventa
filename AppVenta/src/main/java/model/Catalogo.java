package model;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {

    private final List<Categoria> categorias;

    public Catalogo() {
        this.categorias = new ArrayList<>();
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void iniciar() {
        new Catalogo();
        Categoria categoria1 = new Categoria("Electronica");
        Categoria categoria2 = new Categoria("Libros");
        anadirCategoria(categoria1);
        anadirCategoria(categoria2);
        Producto producto1 = new Producto("Iphone", "Telefono movil", 800);
        Producto producto2 = new Producto("Samsung", "Telefono movil", 600);
        Producto producto3 = new Producto("Harry Potter", "Libro de Fantasia", 15);
        Producto producto4 = new Producto("El señor de los anillos", "Libro de Fantasia", 20);
        categoria1.anadirProducto(producto1);
        categoria1.anadirProducto(producto2);
        categoria2.anadirProducto(producto3);
        categoria2.anadirProducto(producto4);
        System.out.println(categorias);
    }

    public void anadirCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public Categoria buscarCategoria(String nombreCategoria) {
        for (Categoria categoria : categorias) {
            if (categoria.getNombreCategoria().equals(nombreCategoria)) {
                return categoria;
            }
        }
        return null;
    }
    public void eliminarCategoria(Categoria categoria) {
        categorias.remove(categoria);
    }
}

