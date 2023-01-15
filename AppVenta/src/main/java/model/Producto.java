package model;

public class Producto {
    private final String nombreProducto;
    private final String descripcion;
    private final double precio;

    public Producto(String nombreProducto, String descripcion, double precio) {
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
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


