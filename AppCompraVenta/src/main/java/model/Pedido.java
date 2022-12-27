package model;

public class Pedido {

    public String consultarPedido(Usuario usuario, Cliente cliente, Carro carro) {
        return "Aqui estan los detalles del pedido: \n"+
                "Nombre: " + usuario.getNombre() +"\n" +
                "Correo: " + usuario.getCorreo() + "\n" +
                "Direccion de envío: " + cliente.getShipAddress() + "\n"+
                "Lista ID de Productos Seleccionados: " + carro.getIdProductosSeleccionados() + "\n"+
                "Precio total: " + carro.getPrecioTotal() + "\n" +
                "Su pedido esta pagado.";

    }
}
