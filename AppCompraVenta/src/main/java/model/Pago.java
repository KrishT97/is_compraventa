package model;

public class Pago {
    public static String realizarPago(String pago) {

        return "Se va realizar el pago por nombre de: "+Usuario.getNombre()+" con metodo de pago: " +pago+",siendo en total:" + Carro.getPrecioTotal() +
                ",en la ubicacion de " + Cliente.getShipAddress() + ". Redirigiendo a la web para pagar por " + pago + ".";

    }
}

