package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private final Carro carro;
    private final ArrayList<Pedido> pedidos;

    public Cliente() {
        this.carro = new Carro();
        this.pedidos = new ArrayList<>();
    }

    public void agregarCarrito(Producto producto) {
        carro.agregarProducto(producto);
    }

    public double calcularPago(){
        Pago pago = new Pago(carro);
        return pago.calcularTotal();
    }

    public void generarPedido(String shipAddress){
        Pedido pedidoActual = new Pedido(carro, shipAddress);
        pedidoActual.generar();
        pedidos.add(pedidoActual);
    }

    public List<String> consultarPedidos(){
        List<String> listaPedidos = new ArrayList<>();
        for (Pedido pedido: pedidos){
            listaPedidos.add("Pedido de productos: "+
                    pedido.getProductosPagados() + "con dirección de envío: " +
                    pedido.getShipAddress());
        }
        return listaPedidos;
    }








}





