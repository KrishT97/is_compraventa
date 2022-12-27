package model;

public class Vendedor extends Usuario {


    public String anadirProducto(Catalogo catalogo,String nombreCategoria, int id, double precio, String nombre, String descripcion) {
        if (catalogo.getCategorias().contains(nombreCategoria) && !(Producto.getIds().contains(id))){
            Producto producto = new Producto(id);
            Categoria categoria = new Categoria(catalogo,nombreCategoria);
            producto.setPrecio(precio);
            categoria.anadir(producto);
            return "Perfectamente añadido con los siguientes datos:  \n" +
                    "                    Categoría: " + nombreCategoria + ",\n" +
                    "                    ID: " + id + ",\n" +
                    "                    Precio: " + precio + " €,\n" +
                    "                    Nombre del Producto: " + nombre + "\n" +
                    "                    Descripcion: " + descripcion;
        }
        else{
            return "No existe la categoria indicada o el id ya esta en uso, por lo cual no se añadira el producto.";
        }
    }

    public String eliminarProducto(Catalogo catalogo,String nombreCategoria, int id) {
        if (catalogo.getCategorias().contains(nombreCategoria) && Producto.getIds().contains(id)){
            Categoria categoria = new Categoria(catalogo,nombreCategoria);
            categoria.eliminar(id);
            return "Perfectamente eliminado con los siguientes datos: \n" +
                    "                    Categoría: " + nombreCategoria + ", \n" +
                    "                    ID: " + id;
        }
        else{
            return "No existe la categoria indicada o el producto indicado, " +
                    "por lo cual no se añadira el producto.";
        }
    }

    public String modificarProducto(Catalogo catalogo,String nombreCategoria, int id, double precio,String nombre, String descripcion) {

        if (catalogo.getCategorias().contains(nombreCategoria) && Producto.getIds().contains(id)){
            int nuevoId = id+1;
            if (Producto.obtenerOcurrenciasId(nuevoId) < 1){
                Producto producto = new Producto(nuevoId);
                producto.setPrecio(precio);
                return "Perfectamente modificado con los siguientes datos:  \n" +
                        "                    Categoría: " + nombreCategoria + ", \n" +
                        "                    ID: " + nuevoId + ", \n" +
                        "                    Precio: " + precio + " €, \n" +
                        "                    Nombre del Producto: " + nombre + ", \n" +
                        "                    Descripcion: " + descripcion;
            }
            else{
                return "Ya has modificado el Id de ese producto.";
            }
        }
        else{
            return "No existe la categoria indicada o el producto indicado, " +
                    "por lo cual no se añadira el producto.";
        }
    }
}
