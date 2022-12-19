package model;

public class Producto {


    private int id;
    private double precio;

    private String nombre;
    private String descripcion;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto(int id) {
        this.id = id;
    }

}
