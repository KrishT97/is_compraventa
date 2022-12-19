package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {

        // CASO 1: CLIENTE
        Cliente.iniciarSesion("Juan", "12345","juan@gmail.com");
        Cliente.setShipAddress("Las Palmas, Gran Canaria");
        Producto productoSeleccionado = new Producto(2341);
        Producto productoSeleccionado1 = new Producto(22);
        Cliente.agregarACarrito(productoSeleccionado); //TODO: da error al anadir
        Cliente.agregarACarrito(productoSeleccionado1);
        Carro.calcularTotal();
        Pago.realizarPago();
        Pedido.consultarPedido();

        //CASO 2: VENDEDEDOR
        Vendedor.iniciarSesion("Roberto", "123456","roberto@gmail.com");
        Random randomNum = new Random();
        int id = randomNum. nextInt(100);
        Categoria categoriaSeleccionado = new Categoria("Bicicleta");
        Vendedor.anadirProducto(categoriaSeleccionado,id,15.65,"Bicicleta BMX",
                "Nueva con unas semanas de uso.");
        Vendedor.modificarProducto(categoriaSeleccionado,45.34,id,"Bicicleta BMX", "Nueva");

        //CASO EN GENERAL PARA LA APLICACION

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Buenas, eres cliente o vendededor? (ponga 'cliente' o 'vendedor')");
        String type = reader.readLine();
        if (Objects.equals(type, "vendedor")){
            System.out.println("Nombre:");
            String name = reader.readLine();
            System.out.println("Contrasena:");
            String surname = reader.readLine();
            System.out.println("Email:");
            String email = reader.readLine();
            System.out.println("Shipping Address:");
            String shippingAddress = reader.readLine();
            //...
        }





    }
}
