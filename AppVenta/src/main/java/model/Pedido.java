package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String shipAddress;
    private final List<Producto> productosPagados;
    public Carro carro;

    public List<Producto> getProductosPagados() {
        return productosPagados;
    }
    public void setShipAddress(String shipAddress){
        this.shipAddress = shipAddress;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void generar(Carro carro){
        this.carro = carro;
        if (this.carro.isEstadoPago()){
            productosPagados.addAll(this.carro.getProductos());
        }

    }

    public Pedido(){
        this.productosPagados = new ArrayList<>();

    }



}
