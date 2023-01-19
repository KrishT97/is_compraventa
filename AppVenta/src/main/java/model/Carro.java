package model;

import java.util.ArrayList;
import java.util.List;

public class Carro {

    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public boolean isEstadoPago() {
        return estadoPago;
    }

    private boolean estadoPago;

    private final List<Producto> productosSeleccionados;

    public Carro() {
        this.productosSeleccionados = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productosSeleccionados.add(producto);
    }

    public List<Producto> getProductos() {
        return productosSeleccionados;
    }

    public void setPrecioTotal(double suma) {
    }
}


