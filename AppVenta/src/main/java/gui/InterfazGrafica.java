package gui;

import model.*;

import javax.swing.*;



public class InterfazGrafica {
    private final JTextField campoNombreProducto;
    private final JTextField campoNombreCategoria;
    private final JTextField campoNombreUsuario;
    private final JTextField campoCorreo;
    private final JTextField campoDireccion;
    private final JTextField campoVendedorID;

    public InterfazGrafica(AppCompraVenta app) {
        JFrame ventana = new JFrame("App Compra-Venta");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane pestanas = new JTabbedPane();
        JPanel panelCatalogo = new JPanel();
        JPanel panelCarro = new JPanel();
        JPanel panelUsuario = new JPanel();

        campoNombreProducto = new JTextField(20);
        campoNombreCategoria = new JTextField(20);
        campoNombreUsuario = new JTextField(20);
        campoCorreo = new JTextField(20);
        campoDireccion = new JTextField(20);
        campoVendedorID = new JTextField(20);
        JTextField campoShipAddress = new JTextField(20);


        JButton botonIniciarSesion = new JButton("Iniciar sesión");
        JButton botonCerrarSesion = new JButton("Cerrar sesión");
        JButton botonRegistrarSesion = new JButton("Registrarse");
        JButton botonAgregarCarrito = new JButton("Agregar al carrito");
        JButton botonRealizarPago = new JButton("Realizar pago");
        JButton botonMostrarCatalogo = new JButton("Mostrar Catalogo");

        panelCatalogo.add(new JLabel("Nombre del producto:"));
        panelCatalogo.add(campoNombreProducto);
        panelCatalogo.add(new JLabel("Nombre de la categoría:"));
        panelCatalogo.add(campoNombreCategoria);
        panelCatalogo.add(botonMostrarCatalogo);


        panelCarro.add(botonAgregarCarrito);
        panelCarro.add(botonRealizarPago);

        panelUsuario.add(new JLabel("Nombre del usuario:"));
        panelUsuario.add(campoNombreUsuario);
        panelUsuario.add(new JLabel("Correo:"));
        panelUsuario.add(campoCorreo);
        panelUsuario.add(new JLabel("Dirección:"));
        panelUsuario.add(campoDireccion);
        panelUsuario.add(new JLabel("ID del vendedor:"));
        panelUsuario.add(campoVendedorID);
        panelUsuario.add(new JLabel("Dirección de envío:"));
        panelUsuario.add(campoShipAddress);
        panelUsuario.add(botonIniciarSesion);
        panelUsuario.add(botonCerrarSesion);
        panelUsuario.add(botonRegistrarSesion);

        pestanas.addTab("Catálogo", panelCatalogo);
        pestanas.addTab("Carro", panelCarro);
        pestanas.addTab("Usuario", panelUsuario);


        botonMostrarCatalogo.addActionListener(e-> {
            JOptionPane.showMessageDialog(null, app.mostrarCatalogo(), "Información", JOptionPane.INFORMATION_MESSAGE);

        });

        botonRegistrarSesion.addActionListener(e -> {
            String nombreUsuario = campoNombreUsuario.getText();
            String correo = campoCorreo.getText();
            String direccion = campoDireccion.getText();
            if(nombreUsuario.isEmpty() || correo.isEmpty() || direccion.isEmpty()){
                JOptionPane.showMessageDialog(null, "El nombre , correo y direccion es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);

            }
            else{
                app.registrarCuenta(nombreUsuario,correo,direccion);
                JOptionPane.showMessageDialog(null, " Registrado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);

            }
        });


        botonIniciarSesion.addActionListener(e -> {
            String nombreUsuario = campoNombreUsuario.getText();
            String correo = campoCorreo.getText();
            String direccion = campoDireccion.getText();
            String vendedorId = campoVendedorID.getText();
            if(app.iniciarSesion(nombreUsuario, correo, direccion)){
                if (!vendedorId.isEmpty()){
                    app.iniciarVenta(vendedorId);
                    JOptionPane.showMessageDialog(null, " Iniciado como vendedor con id "+ app.getID() + "correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (nombreUsuario.isEmpty() || correo.isEmpty() || direccion.isEmpty()){
                    JOptionPane.showMessageDialog(null, "El nombre , correo y direccion es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);

                }
                else{
                    app.iniciarCompra();
                    JOptionPane.showMessageDialog(null, app.getUser() + " ha sido iniciado sesion correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);

                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El usuario no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        botonCerrarSesion.addActionListener(e -> {
            app.cerrarSesion();
            JOptionPane.showMessageDialog(null, "Se ha cerrado sesion correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);


        });

        botonAgregarCarrito.addActionListener(e -> {
            if(app.getEstadoCliente()){
                String nombreProducto = campoNombreProducto.getText();
                String nombreCategoria = campoNombreCategoria.getText();
                Producto producto = app.buscarProducto(nombreProducto, nombreCategoria);
                if(producto != null){
                    app.agregarCarrito(producto);
                    JOptionPane.showMessageDialog(null, "Se ha añadido el producto al carrito.", "Información", JOptionPane.INFORMATION_MESSAGE);

                }
            }
            else{
                JOptionPane.showMessageDialog(null, "No se ha podido añadir el producto al carrito, compruebe que este iniciado de sesión como cliente.", "Error", JOptionPane.ERROR_MESSAGE);

            }

        });

        botonRealizarPago.addActionListener(e -> {
            if(app.getEstadoCliente()){
                JOptionPane.showMessageDialog(null, "La suma total es $" + app.calcularPago()+ ".", "Información", JOptionPane.INFORMATION_MESSAGE);
                app.generarPedido(campoDireccion.getText());
                JOptionPane.showMessageDialog(null, "Se tienen los siguientes pedidos para usted:" + app.consultarPedidos(), "Información", JOptionPane.INFORMATION_MESSAGE);

            }
            else{
                JOptionPane.showMessageDialog(null, "No se ha podido iniciar pago, compruebe que este iniciado de sesión y ha agragado productos al carrito como cliente.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        });

        ventana.add(pestanas);
        ventana.setVisible(true);
    }



}