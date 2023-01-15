package model;

public class Vendedor extends Usuario {
    private final String vendedorID;

    public String getVendedorID() {
        return vendedorID;
    }

    public Vendedor(String vendedorID) {
        this.vendedorID = vendedorID;
    }
}

