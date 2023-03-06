package model;


public class Pago {

    public Carro carro;

    public double calcularTotal(Carro carro){
        double suma = 0;
        this.carro = carro;
        for (Producto producto : this.carro.getProductos()) {
            suma += producto.getPrecio();
        }
        return suma;

    }

    public Pago() {
    }
}
