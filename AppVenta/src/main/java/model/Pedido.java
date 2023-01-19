package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final String shipAddress;
    private final List<Producto> productosPagados;
    private final Carro carro;

    public List<Producto> getProductosPagados() {
        return productosPagados;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void generar(){
        if (carro.isEstadoPago()){
            productosPagados.addAll(carro.getProductos());
        }

    }

    public Pedido(Carro carro, String shipAddress){
        this.carro = carro;
        this.shipAddress = shipAddress;
        this.productosPagados = new ArrayList<>();

    }



}
