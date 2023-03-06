package model;

import java.util.ArrayList;
import java.util.List;

public class Carro {

    public Pedido getPedido() {
        return pedido;
    }

    private Pedido pedido;

    public Pago getPago() {
        return pago;
    }

    private Pago pago;

    public Pago crearPago(){
        return this.pago = new Pago();
    }

    public Pedido crearPedido(){
        return this.pedido = new Pedido();
    }

    public boolean isEstadoPago() {
        return this.pago != null;
    }


    private final List<Producto> productosSeleccionados;

    public Carro() {
        this.productosSeleccionados = new ArrayList<>();
        this.pedido = null;
        this.pago = null;

    }

    public void agregarProducto(Producto producto) {
        productosSeleccionados.add(producto);
    }

    public List<Producto> getProductos() {
        return productosSeleccionados;
    }
}


