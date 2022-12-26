package model;

public class Cliente extends Usuario {

    private static String shipAddress;

    public static void setShipAddress(String shipAddressUsuario) {
        shipAddress = shipAddressUsuario;
    }

    public static String getShipAddress() {
        return shipAddress;
    }

    public static void agregarACarrito(Double precio) {
        Carro.calcularSuma(precio);
    }
}
