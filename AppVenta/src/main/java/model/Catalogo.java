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
        Vendedor vendedor1 = new Vendedor("1");
        Vendedor vendedor2 = new Vendedor("2");
        Vendedor vendedor3 = new Vendedor("3");
        Vendedor vendedor4 = new Vendedor("4");
        Producto producto1 = new Producto("Iphone", "Telefono movil", 800,vendedor1);
        Producto producto2 = new Producto("Samsung", "Telefono movil", 600,vendedor2);
        Producto producto3 = new Producto("Harry Potter", "Libro de Fantasia", 15,vendedor3);
        Producto producto4 = new Producto("El señor de los anillos", "Libro de Fantasia", 20,vendedor4);
        categoria1.anadirProducto(producto1);
        categoria1.anadirProducto(producto2);
        categoria2.anadirProducto(producto3);
        categoria2.anadirProducto(producto4);
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

