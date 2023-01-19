package gui;

import model.*;

import javax.swing.*;



public class InterfazGrafica {
    private final JTextField campoNombreProducto;
    private final JTextField campoDescripcion;
    private final JTextField campoPrecio;
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
        campoDescripcion = new JTextField(20);
        campoPrecio = new JTextField(20);
        campoNombreCategoria = new JTextField(20);
        campoNombreUsuario = new JTextField(20);
        campoCorreo = new JTextField(20);
        campoDireccion = new JTextField(20);
        campoVendedorID = new JTextField(20);
        JTextField campoShipAddress = new JTextField(20);

        JButton botonAnadirProducto = new JButton("Añadir producto");
        JButton botonEliminarProducto = new JButton("Eliminar producto");
        JButton botonAnadirUsuario = new JButton("Añadir usuario");
        JButton botonEliminarUsuario = new JButton("Eliminar usuario");
        JButton botonAnadirCategoria = new JButton("Añadir categoría");
        JButton botonEliminarCategoria = new JButton("Eliminar categoría");
        JButton botonIniciarSesion = new JButton("Iniciar sesión");
        JButton botonCerrarSesion = new JButton("Cerrar sesión");
        JButton botonAgregarCarrito = new JButton("Agregar al carrito");
        JButton botonRealizarPago = new JButton("Realizar pago");
        JButton botonMostrarCatalogo = new JButton("Mostrar Catalogo");

        panelCatalogo.add(new JLabel("Nombre del producto:"));
        panelCatalogo.add(campoNombreProducto);
        panelCatalogo.add(new JLabel("Descripción:"));
        panelCatalogo.add(campoDescripcion);
        panelCatalogo.add(new JLabel("Precio:"));
        panelCatalogo.add(campoPrecio);
        panelCatalogo.add(new JLabel("Nombre de la categoría:"));
        panelCatalogo.add(campoNombreCategoria);
        panelCatalogo.add(botonAnadirProducto);
        panelCatalogo.add(botonMostrarCatalogo);
        panelCatalogo.add(botonEliminarProducto);
        panelCatalogo.add(botonAnadirCategoria);
        panelCatalogo.add(botonEliminarCategoria);

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
        panelUsuario.add(botonAnadirUsuario);
        panelUsuario.add(botonEliminarUsuario);

        pestanas.addTab("Catálogo", panelCatalogo);
        pestanas.addTab("Carro", panelCarro);
        pestanas.addTab("Usuario", panelUsuario);


        botonMostrarCatalogo.addActionListener(e-> {
            JOptionPane.showMessageDialog(null, app.mostrarCatalogo(), "Información", JOptionPane.INFORMATION_MESSAGE);

        });

        botonAnadirProducto.addActionListener(e -> {

            if (app.getEstadoVendedor()) {
                String nombreProducto = campoNombreProducto.getText();
                String descripcion = campoDescripcion.getText();
                String precio = campoPrecio.getText();
                String nombreCategoria = campoNombreCategoria.getText();
                if (nombreProducto.isEmpty() || descripcion.isEmpty() || precio.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El nombre del producto, precio y descripcion es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    double precioFormateado = Double.parseDouble(precio);
                    Producto producto = new Producto(nombreProducto, descripcion, precioFormateado);
                    app.anadirProducto(producto, nombreCategoria);
                    JOptionPane.showMessageDialog(null, "El producto " + nombreProducto + " solo habrá sido agregado si existiera la categoria mencionada, revise el catalogo.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "No eres el vendedor, no puedes realizar esta operación.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        });

        botonEliminarProducto.addActionListener(e -> {

            if (app.getEstadoVendedor()) {
                String nombreProducto = campoNombreProducto.getText();
                String nombreCategoria = campoNombreCategoria.getText();
                if(nombreProducto.isEmpty() || nombreCategoria.isEmpty()){
                    JOptionPane.showMessageDialog(null, "El nombre del producto y categoria es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);

                }
                else{
                    Producto producto = app.buscarProducto(nombreProducto, nombreCategoria);
                    app.eliminarProducto(producto, nombreCategoria);
                    JOptionPane.showMessageDialog(null, "El producto " + nombreProducto + " ha sido eliminado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "No eres el vendedor, no puedes realizar esta operación.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        });

        botonAnadirCategoria.addActionListener(e -> {
            String nombreCategoria = campoNombreCategoria.getText();
            if (!app.getEstadoVendedor() && !app.getEstadoCliente()) {
                if(!nombreCategoria.isEmpty()){
                    app.anadirCategoria(nombreCategoria);
                    JOptionPane.showMessageDialog(null, "Categoría añadida.", "Información", JOptionPane.INFORMATION_MESSAGE);

                }
                else{
                    JOptionPane.showMessageDialog(null, "El nombre de la categoria no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Te has registrado como cliente o vendedor, no puedes realizar esta operación.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        });

        botonEliminarCategoria.addActionListener(e -> {
            String nombreCategoria = campoNombreCategoria.getText();
            if (!app.getEstadoVendedor() && !app.getEstadoCliente()) {
                if(!nombreCategoria.isEmpty()){
                    app.eliminarCategoria(nombreCategoria);
                    JOptionPane.showMessageDialog(null, "Categoría eliminada.", "Información", JOptionPane.INFORMATION_MESSAGE);

                }
                else{
                    JOptionPane.showMessageDialog(null, "El nombre de la categoria no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Te has registrado como cliente o vendedor, no puedes realizar esta operación.", "Error", JOptionPane.ERROR_MESSAGE);

            }

        });

        botonAnadirUsuario.addActionListener(e-> {

            if(!app.getEstadoVendedor() && !app.getEstadoCliente()){
                String nombreUsuario = campoNombreUsuario.getText();
                String correo = campoCorreo.getText();
                String direccion = campoDireccion.getText();
                app.anadirUsuario(nombreUsuario,correo,direccion);
                JOptionPane.showMessageDialog(null, " Usuario " + nombreUsuario + " añadido correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);


            }

        });
        botonEliminarUsuario.addActionListener(e-> {

            if(!app.getEstadoVendedor() && !app.getEstadoCliente()){
                String nombreUsuario = campoNombreUsuario.getText();
                app.eliminarUsuario(nombreUsuario);
                JOptionPane.showMessageDialog(null, " Usuario " + nombreUsuario + " eliminado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        botonIniciarSesion.addActionListener(e -> {
            String nombreUsuario = campoNombreUsuario.getText();
            String correo = campoCorreo.getText();
            String direccion = campoDireccion.getText();
            String vendedorId = campoVendedorID.getText();
            app.iniciarSesion(nombreUsuario, correo, direccion);
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
        });

        botonCerrarSesion.addActionListener(e -> app.cerrarSesion());

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

        });

        botonRealizarPago.addActionListener(e -> {
            if(app.getEstadoCliente()){
                JOptionPane.showMessageDialog(null, "La suma total es $" + app.calcularPago()+ ".", "Información", JOptionPane.INFORMATION_MESSAGE);
                app.generarPedido(campoDireccion.getText());
                JOptionPane.showMessageDialog(null, "Se tienen los siguientes pedidos para usted:" + app.consultarPedidos(), "Información", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        ventana.add(pestanas);
        ventana.setVisible(true);
    }



}