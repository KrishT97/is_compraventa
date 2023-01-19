package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AppCompraVenta {
    private final Catalogo catalogo;
    private final ArrayList<Usuario> usuarios;
    private Vendedor vendedor;
    private Cliente cliente;
    private Usuario usuarioIniciado;
    private boolean vendedorActivo;
    private boolean clienteActivo;

    public AppCompraVenta() {
        this.catalogo = new Catalogo();
        this.usuarios = new ArrayList<>();
        this.clienteActivo = false;
        this.vendedorActivo = false;
    }

    public void iniciarCatalogo() {
        catalogo.iniciar();
    }

    public void anadirCategoria(String nombreCategoria) {
        Categoria categoria = new Categoria(nombreCategoria);
        catalogo.anadirCategoria(categoria);
    }
    public String mostrarCatalogo() {

        List<Producto> productos = getProductos();
        List<Categoria> categorias = catalogo.getCategorias();
        List<String> listaProductos = new ArrayList<>();
        List<String> listaCategorias = new ArrayList<>();
        for (Producto producto : productos) {
            listaProductos.add(producto.toString() + "\n");
        }
        for (Categoria categoria : categorias) {
            listaCategorias.add(categoria.toString() + "\n");
        }
        return "Productos: " + listaProductos + ", Categorias: " + listaCategorias;
    }

    public void eliminarCategoria(String nombreCategoria) {
        Categoria categoria = new Categoria(nombreCategoria);
        catalogo.eliminarCategoria(categoria);
    }


    public void anadirProducto(Producto producto, String nombreCategoria) {
        Categoria categoria = catalogo.buscarCategoria(nombreCategoria);
        if(categoria != null){
            categoria.anadirProducto(producto);
        }
    }

    public void eliminarProducto(Producto producto, String nombreCategoria) {
        Categoria categoria = catalogo.buscarCategoria(nombreCategoria);
        categoria.eliminarProducto(producto);
    }


    public Producto buscarProducto(String nombreProducto, String nombreCategoria) {
        Categoria categoria = catalogo.buscarCategoria(nombreCategoria);
        return categoria.buscarProducto(nombreProducto);
    }

    public void agregarCarrito(Producto producto) {
        cliente.agregarCarrito(producto);
    }


    public double calcularPago() {
        return cliente.calcularPago();
    }

    public void generarPedido(String shipAddress){
        cliente.generarPedido(shipAddress);
    }

    public List<String> consultarPedidos(){
        return cliente.consultarPedidos();
    }


    public void iniciarSesion(String nombre, String correo, String direccion) {
        Usuario usuario = new Usuario();
        usuario.iniciarSesion(nombre,correo,direccion);
        usuarioIniciado = usuario;
        if (!usuarios.contains(usuarioIniciado)){
            usuarios.add(usuarioIniciado);
        }

    }

    public void anadirUsuario(String nombre, String correo, String direccion){
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setNombre(nombre);
        usuarioNuevo.setCorreo(correo);
        usuarioNuevo.setDireccion(direccion);
        usuarios.add(usuarioNuevo);
    }

    public void eliminarUsuario(String nombre){
        usuarios.removeIf(usuario -> Objects.equals(usuario.getNombre(), nombre));
    }

    public void iniciarVenta(String vendedorID){
        vendedor = new Vendedor(vendedorID);
        vendedorActivo = true;
    }

    public void iniciarCompra(){
        cliente = new Cliente();
        clienteActivo = true;
    }

    public boolean getEstadoVendedor(){
        return vendedorActivo;
    }

    public boolean getEstadoCliente(){
        return clienteActivo;
    }

    public void cerrarSesion() {
        usuarioIniciado.cerrarSesion();
        vendedorActivo = false;
        clienteActivo = false;
    }

    public String getID(){
        return vendedor.getVendedorID();
    }

    public String getUser(){
        return "Usuario con Nombre:" + usuarioIniciado.getNombre() + ", Correo: " + usuarioIniciado.getCorreo() + ", y Direccion: " + usuarioIniciado.getDireccion();
    }


    public List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();
        for (Categoria categoria : catalogo.getCategorias()) {
            productos.addAll(categoria.getProductos());
        }
        return productos;
    }

}

