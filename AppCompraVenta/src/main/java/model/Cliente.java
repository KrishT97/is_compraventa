package model;

public class Cliente extends Usuario {

    private String shipAddress;

    public void setShipAddress(String shipAddressUsuario) {
        shipAddress = shipAddressUsuario;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void agregarACarrito(Carro carro,Double precio) {
        carro.calcularSuma(precio);
    }
}
