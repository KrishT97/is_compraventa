package model;


public class Pago {

    private final Carro carro;

    public double calcularTotal(){
        double suma = 0;
        for (Producto producto : carro.getProductos()) {
            suma += producto.getPrecio();
        }
        carro.setPrecioTotal(suma);
        carro.setEstadoPago(true);
        return suma;

    }

    public Pago(Carro carro) {
        this.carro = carro;
    }
}
