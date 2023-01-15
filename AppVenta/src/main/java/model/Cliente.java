package model;

public class Cliente extends Usuario {
    private final Carro carro;

    public Cliente() {
        this.carro = new Carro();
    }

    public void agregarCarrito(Producto producto) {
        carro.agregarProducto(producto);
    }

    public double calcularSuma() {
        double suma = 0;
        for (Producto producto : carro.getProductos()) {
            suma += producto.getPrecio();
        }
        carro.setPrecioTotal(suma);
        return suma;
    }

}





