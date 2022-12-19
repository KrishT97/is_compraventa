package model;

public class Pago {
    public static void realizarPago() {

        System.out.println("Se va realizar el pago por: " + Carro.calcularTotal() +
                ", en la ubicacion de " + Cliente.getShipAddress());

    }
}

