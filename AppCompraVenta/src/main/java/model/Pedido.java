package model;

public class Pedido {

    public static String consultarPedido() {
        return "Aqui estan los detalles del pedido: \n"+
                "Nombre: " + Usuario.getNombre() +"\n" +
                "Correo: " + Usuario.getCorreo() + "\n" +
                "Direccion de envío: " + Cliente.getShipAddress() + "\n"+
                "Lista ID de Productos Seleccionados: " + Carro.getIdProductosSeleccionados() + "\n"+
                "Precio total: " + Carro.getPrecioTotal() + "\n" +
                "Su pedido esta pagado.";

    }
}
