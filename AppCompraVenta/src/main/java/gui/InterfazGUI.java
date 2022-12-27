package gui;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InterfazGUI extends JFrame implements ActionListener {

    private final JTextField fieldNombre;
    private final JTextField fieldCorreo;
    private final JTextField fieldItems;
    private final JTextField fieldTipo;
    private final JTextField fieldCategoria;
    private final JTextField fieldId;
    private final JTextField fieldDireccion;
    private final JTextField fieldPrecio;
    private final JTextField fieldNombreProducto;
    private final JTextField fieldDescripcion;
    private final JButton buttonCatalogo;
    private final JButton buttonAnadir;
    private final JButton buttonEliminar;
    private final JButton buttonComprar;
    private final JButton buttonModificar;
    Categoria categoriaDisponible;

    Catalogo catalogo = new Catalogo();


    public InterfazGUI() {

        empezarAplicacion();
        setTitle("App CompraVenta");
        setSize(800, 650);

        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        JLabel labelInformacion = new JLabel("Siendo un vendedor, podrás añadir, modificar o quitar productos.");
        JLabel labelInformacion1 = new JLabel("Siendo un cliente, podrás realizar la compra de uno o más productos.");
        JLabel labelInformacion2 = new JLabel("Para el vendedor:");
        JLabel labelInformacion3 = new JLabel("Para el cliente:");
        JLabel labelNombre = new JLabel("Nombre:");
        JLabel labelContrasena = new JLabel("Contraseña:");
        JLabel labelCorreo = new JLabel("Correo:");
        JLabel labelTipo = new JLabel("Tipo (vendedor o cliente):");
        JLabel labelCategoria = new JLabel("Nombre de la categoría:");
        JLabel labelId = new JLabel("ID:");
        JLabel labelDireccion = new JLabel("Dirección de envío:");
        JLabel labelPrecio = new JLabel("Precio:");
        JLabel labelNombreProducto = new JLabel("Nombre del producto:");
        JLabel labelDescripcion = new JLabel("Descripción:");
        JLabel labelItems = new JLabel("Número de items seleccionados:");


        fieldNombre = new JTextField();
        JTextField fieldContrasena = new JTextField();
        fieldCorreo = new JTextField();
        fieldTipo = new JTextField();
        fieldCategoria = new JTextField();
        fieldId = new JTextField();
        fieldDireccion = new JTextField();
        fieldPrecio = new JTextField();
        fieldNombreProducto = new JTextField();
        fieldDescripcion = new JTextField();
        fieldItems = new JTextField();

        // Cree botones para iniciar sesión, añadir, eliminar y modificar
        buttonCatalogo = new JButton("Catálogo");
        buttonAnadir = new JButton("Añadir Producto");
        buttonEliminar = new JButton("Eliminar Producto");
        buttonModificar = new JButton("Modificar Producto");
        buttonComprar = new JButton("Comprar");

        labelInformacion.setBounds(5,-10,400,50);
        labelInformacion1.setBounds(5,12,450,50);
        labelInformacion2.setBounds(5,250,450,50);
        labelInformacion3.setBounds(450,250,450,50);

        labelNombre.setBounds(50, 70, 100, 30);
        fieldNombre.setBounds(150, 70, 100, 30);
        labelContrasena.setBounds(50, 110, 100, 30);
        fieldContrasena.setBounds(150, 110, 100, 30);
        labelCorreo.setBounds(50, 150, 100, 30);
        fieldCorreo.setBounds(150, 150, 100, 30);
        labelTipo.setBounds(50, 190, 200, 30);
        fieldTipo.setBounds(250, 190, 100, 30);
        labelCategoria.setBounds(50, 350, 200, 30);
        fieldCategoria.setBounds(250, 350, 100, 30);
        labelId.setBounds(50, 300, 100, 30);
        fieldId.setBounds(100, 300, 100, 30);
        labelDireccion.setBounds(500, 295, 200, 30);
        fieldDireccion.setBounds(650, 295, 100, 30);
        labelNombreProducto.setBounds(50, 390, 200, 30);
        fieldNombreProducto.setBounds(250, 390, 100, 30);
        labelDescripcion.setBounds(50, 430, 200, 30);
        fieldDescripcion.setBounds(250, 430, 100, 30);
        labelPrecio.setBounds(50, 470, 100, 30);
        fieldPrecio.setBounds(250, 470, 100, 30);
        fieldItems.setBounds(650, 345, 100, 30);
        labelItems.setBounds(450, 345, 200, 30);



        buttonCatalogo.setBounds(520, 100, 180, 80);
        buttonAnadir.setBounds(50, 515, 140, 30);
        buttonEliminar.setBounds(208, 515, 140, 30);
        buttonModificar.setBounds(122, 555, 150, 30);
        buttonComprar.setBounds(600,400,150,30);

        contentPane.add(labelInformacion);

        contentPane.add(labelInformacion1);
        contentPane.add(labelInformacion2);
        contentPane.add(labelInformacion3);
        contentPane.add(labelNombre);
        contentPane.add(fieldNombre);
        contentPane.add(labelContrasena);
        contentPane.add(fieldContrasena);
        contentPane.add(labelCorreo);
        contentPane.add(fieldCorreo);
        contentPane.add(labelTipo);
        contentPane.add(fieldTipo);
        contentPane.add(labelCategoria);
        contentPane.add(fieldCategoria);
        contentPane.add(labelId);
        contentPane.add(fieldId);
        contentPane.add(labelDireccion);
        contentPane.add(fieldDireccion);
        contentPane.add(labelPrecio);
        contentPane.add(fieldPrecio);
        contentPane.add(labelNombreProducto);
        contentPane.add(fieldNombreProducto);
        contentPane.add(labelDescripcion);
        contentPane.add(fieldDescripcion);
        contentPane.add(buttonCatalogo);
        contentPane.add(buttonAnadir);
        contentPane.add(buttonEliminar);
        contentPane.add(buttonModificar);
        contentPane.add(fieldItems);
        contentPane.add(labelItems);
        contentPane.add(buttonComprar);

        buttonCatalogo.addActionListener(this);
        buttonAnadir.addActionListener(this);
        buttonEliminar.addActionListener(this);
        buttonModificar.addActionListener(this);
        buttonComprar.addActionListener(this);

    }
    private void empezarAplicacion(){

        catalogo.iniciarCatalogo();

        String bicicleta = "Bicicleta";
        String hogar = "Hogar";
        String moda = "Moda";
        String informatica = "Informática";
        String motos = "Motos";
        String deporte = "Deporte";

        catalogo.anadirCategoria(bicicleta);
        catalogo.anadirCategoria(hogar);
        catalogo.anadirCategoria(moda);
        catalogo.anadirCategoria(informatica);
        catalogo.anadirCategoria(motos);
        catalogo.anadirCategoria(deporte);

        Categoria categoriaBicicleta = new Categoria(catalogo,bicicleta);
        Categoria categoriaModa = new Categoria(catalogo,moda);
        Categoria categoriaInformatica = new Categoria(catalogo,informatica);
        Categoria categoriaMotos = new Categoria(catalogo,motos);
        Categoria categoriaHogar = new Categoria(catalogo,hogar);
        Categoria categoriaDeporte = new Categoria(catalogo,deporte);

        Producto.setIds();

        Producto producto1 = new Producto(1);
        producto1.setPrecio(19.3);
        categoriaBicicleta.anadir(producto1);
        Producto producto2 = new Producto(2);
        producto2.setPrecio(8.9);
        categoriaDeporte.anadir(producto2);
        Producto producto3 = new Producto(3);
        producto3.setPrecio(43.1);
        categoriaHogar.anadir(producto3);
        Producto producto4 = new Producto(4);
        producto4.setPrecio(33.21);
        categoriaInformatica.anadir(producto4);
        Producto producto5 = new Producto(5);
        producto5.setPrecio(11);
        categoriaModa.anadir(producto5);
        Producto producto6 = new Producto(6);
        producto6.setPrecio(231);
        categoriaMotos.anadir(producto6);

    }

    public void actionPerformed(ActionEvent e) {

        Usuario usuario = new Usuario();
        usuario.iniciar(fieldNombre.getText(),fieldCorreo.getText());
        Vendedor vendedor = new Vendedor();
        
        if (e.getSource() == buttonCatalogo) {
            JOptionPane.showMessageDialog(null, "Hola, El catálogo tiene las siguientes categorias: " +
                    catalogo.getCategorias() + ", y estas son los IDs de Productos Disponibles en estos momentos: " + Producto.getIds());
        } else if (e.getSource() == buttonAnadir && fieldTipo.getText().equals("vendedor")) {
            String categoriaNombre = fieldCategoria.getText();
            int id = Integer.parseInt(fieldId.getText());
            double precio = Double.parseDouble(fieldPrecio.getText());
            String nombreProducto = fieldNombreProducto.getText();
            String descripcion = fieldDescripcion.getText();
            String respuesta = vendedor.anadirProducto(catalogo,categoriaNombre, id, precio, nombreProducto, descripcion);
            JOptionPane.showMessageDialog(null, respuesta);
        } else if (e.getSource() == buttonEliminar && fieldTipo.getText().equals("vendedor")) {
            String categoriaNombre = fieldCategoria.getText();
            int id = Integer.parseInt(fieldId.getText());
            String respuesta = vendedor.eliminarProducto(catalogo, categoriaNombre, id);
            JOptionPane.showMessageDialog(null, respuesta);
        } else if (e.getSource() == buttonModificar && fieldTipo.getText().equals("vendedor")) {
            String categoriaNombre = fieldCategoria.getText();
            String nombreProducto = fieldNombreProducto.getText();
            int id = Integer.parseInt(fieldId.getText());
            String descripcion = fieldDescripcion.getText();
            double precio = Double.parseDouble(fieldPrecio.getText());
            String respuesta = vendedor.modificarProducto(catalogo,categoriaNombre, id, precio, nombreProducto, descripcion);
            JOptionPane.showMessageDialog(null, respuesta);
        }
        else if (e.getSource() == buttonComprar && fieldTipo.getText().equals("cliente")){
            Cliente cliente = new Cliente();
            cliente.setShipAddress(fieldDireccion.getText());
            int numItems = Integer.parseInt(fieldItems.getText());
            System.out.println(numItems);
            List<Integer> idProductosSeleccionados = new ArrayList<>();
            for (int i = 0; i < numItems; i++) {
                String productId = JOptionPane.showInputDialog(null, "Introduzca el ID del producto " + (i+1) + ":");
                idProductosSeleccionados.add(Integer.valueOf(productId));
            }
            Carro carro = new Carro();
            carro.setIdProductosSeleccionados(idProductosSeleccionados);

            int contadorAgregado = 0;

            List<Integer> copia = new ArrayList<>(Producto.getIds());
            for (Integer idProducto : copia) {
                for (Integer idProductosSeleccionado : idProductosSeleccionados) {
                    if (Objects.equals(idProducto, idProductosSeleccionado)) {
                        double precioProducto = catalogo.getPrecioPorId(idProducto);
                        cliente.agregarACarrito(carro,precioProducto);
                        contadorAgregado += 1;

                    }
                }
            }
            if(contadorAgregado == numItems){
                JOptionPane.showMessageDialog(null,"Todos los productos añadidos en el carrito correctamente.");
                if (carro.getPrecioTotal() != 0) {
                    System.out.println("El calculo total del carro es " + carro.getPrecioTotal());
                    System.out.println("Se va proceder a realizar el pago, eliga el metodo de pago (tarjeta débito, paypal o monedero):");
                    String metodoPago = JOptionPane.showInputDialog(null, "El calculo total del carro es " + carro.getPrecioTotal() + ". Se va proceder a realizar el pago, eliga el metodo de pago (tarjeta débito, paypal o bizum):");

                    if (Objects.equals(metodoPago, "paypal") || Objects.equals(metodoPago, "tarjeta débito") || Objects.equals(metodoPago, "bizum")){
                        Pago pago = new Pago();
                        JOptionPane.showMessageDialog(null,pago.realizarPago(usuario,cliente,carro,metodoPago));
                        Pedido pedido = new Pedido();
                        JOptionPane.showMessageDialog(null,pedido.consultarPedido(usuario,cliente,carro));
                        Notificacion notificacion = new Notificacion();
                        JOptionPane.showMessageDialog(null, notificacion.avisarNotificacion(usuario));
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Error, el formato del método de pago es incorrecto. Vuelva a intentarlo.");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error, el o los productos no suman a ninguna cantidad...");
                }

            }
            else{
                JOptionPane.showMessageDialog(null,"Error, número de productos añadidos en el carrito: " + contadorAgregado + ", no coincide con el número de productos seleccionados especificados.");

            }

        }
    }

}


