package model;

public class Vendedor extends Usuario {
    private final String vendedorID;
    private Producto producto;

    public String getVendedorID() {
        return vendedorID;
    }

    public Vendedor(String vendedorID) {
        this.vendedorID = vendedorID;
    }

    public void publicarProducto(String nombreProducto, String descripcion, double precio, Vendedor vendedor){
        this.producto = new Producto(nombreProducto,descripcion,precio,vendedor);
    }

    public Producto getProducto() {
        return producto;
    }
}

