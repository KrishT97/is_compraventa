package model;

public class Producto {
    private final String nombreProducto;
    private final String descripcion;
    private final double precio;
    private final Vendedor vendedor;

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Producto(String nombreProducto, String descripcion, double precio, Vendedor vendedor) {
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.vendedor = vendedor;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    @Override
    public String toString() {
        return "Producto: " + nombreProducto + ", Descripción: " + descripcion + ", Precio: " + precio;
    }

    public double getPrecio() {
        return precio;
    }

}


