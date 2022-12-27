package model;

public class Pago {
    public String realizarPago(Usuario usuario,Cliente cliente, Carro carro, String pago) {

        return "Se va realizar el pago por nombre de: "+usuario.getNombre()+" con metodo de pago: " +pago+",siendo en total:" + carro.getPrecioTotal() +
                ",en la ubicacion de " + cliente.getShipAddress() + ". Redirigiendo a la web para pagar por " + pago+".";

    }
}

