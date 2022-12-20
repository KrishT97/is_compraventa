package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static model.Puntuacion.agregarPuntuacion;

public class Main {

    public static void main(String[] args) throws IOException {

        // Iniciar Catalogo
        Catalogo.iniciarCatalogo();

        // Declarar nuevas categorias para anadir al catalogo
        Categoria bicicleta = new Categoria("Bicicleta");
        Categoria hogar = new Categoria("Hogar");
        Categoria moda = new Categoria("Moda");

        // Anadir categorias al catalogo
        Catalogo.anadirCategoria(bicicleta);
        Catalogo.anadirCategoria(hogar);
        Catalogo.anadirCategoria(moda);

        // Iniciar listado de productos para las distintas categorias
        Categoria.listarProductos(bicicleta);
        Categoria.listarProductos(hogar);
        Categoria.listarProductos(moda);

        // CASO RELACION: VENDEDOR Y CLIENTE
        Vendedor.iniciarSesion("Roberto", "123456","roberto@gmail.com");

        Vendedor.anadirProducto(bicicleta,1,15.65,"Bicicleta BMX",
                "Nueva con unas semanas de uso.");
        Vendedor.anadirProducto(bicicleta,2,23.65,"Bicicleta de Paseo",
                "Nueva con unas semanas de uso.");
        Vendedor.modificarProducto(bicicleta,1,45.32,"Bicicleta BMX", "Nueva");


        Cliente.iniciarSesion("Juan", "12345","juan@gmail.com");
        Cliente.setShipAddress("Las Palmas, Gran Canaria");

        List<Integer> idProductosSeleccionados = new ArrayList<>();
        idProductosSeleccionados.add(1);
        idProductosSeleccionados.add(2);

        Carro.inicializarCarro();
        for (Producto p : Categoria.getProductos()) {
            for (Integer idProductosSeleccionado : idProductosSeleccionados) {
                if (p.getId() == idProductosSeleccionado) {
                    Cliente.agregarACarrito(p);


                }
            }
        }
        Carro.calcularTotal();
        Pago.realizarPago();
        Pedido.consultarPedido();
        int puntuacion = agregarPuntuacion(5);
        System.out.println(puntuacion);

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
