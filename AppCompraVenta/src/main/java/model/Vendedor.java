package model;

public class Vendedor extends Usuario {


    public static void anadirProducto(Categoria nombreCategoria, int id, double precio, String nombre, String descripcion) {
        Producto producto = new Producto(id);
        if (Catalogo.getCategorias().contains(nombreCategoria)){
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            nombreCategoria.anadirProducto(producto);
        }
        else{
            System.out.println("No existe la categoria indicada, por lo cual no se añadira el producto.");
        }
    }

    public void eliminarProducto(Categoria nombreCategoria, int id) {
        Producto producto = new Producto(id);
        if (Catalogo.getCategorias().contains(nombreCategoria) && Categoria.getProductos().contains(producto)){
            nombreCategoria.eliminarProducto(producto);
        }
        else{
            System.out.println("No existe la categoria indicada o el producto indicado, " +
                    "por lo cual no se añadira el producto.");
        }
    }

    public static void modificarProducto(Categoria nombreCategoria, double precio, int id, String nombre, String descripcion) {
        Producto producto = new Producto(id);
        if (Catalogo.getCategorias().contains(nombreCategoria) && Categoria.getProductos().contains(producto)){
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
        }
        else{
            System.out.println("No existe la categoria indicada o el producto indicado, " +
                    "por lo cual no se añadira el producto.");
        }
    }
}
