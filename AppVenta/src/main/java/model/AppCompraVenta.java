package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AppCompraVenta {
    private final Catalogo catalogo;
    private final ArrayList<Usuario> usuarios;
    private Vendedor vendedor;
    private Cliente cliente;
    private Pago pago;
    private Carro carro;
    private Pedido pedido;
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

    public void publicarProducto(String nombreProducto,String descripcion,double precio){
        if(vendedorActivo){
            vendedor.publicarProducto(nombreProducto,descripcion,precio,vendedor);
        }
    }
    public String getProductoPublicado(){
        if(vendedorActivo){
            return vendedor.getProducto().toString();
        }
        return null;
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
        carro = new Carro();

    }

    public Vendedor getVendedorProducto(Producto producto){
        return producto.getVendedor();
    }


    public double calcularPago() {
        pago = carro.crearPago();
        return cliente.calcularPago(pago);
    }

    public void generarPedido(String shipAddress){
        pedido = carro.crearPedido();
        cliente.generarPedido(pedido,shipAddress);
    }

    public List<String> consultarPedidos(){
        return cliente.consultarPedidos();
    }


    public boolean iniciarSesion(String nombre, String correo, String direccion) {

        for(Usuario usuario : usuarios){
            if(Objects.equals(usuario.getNombre(), nombre) && Objects.equals(usuario.getCorreo(), correo) && Objects.equals(usuario.getDireccion(), direccion)){
                usuarioIniciado = usuario;
                return true;
            }
        }
        return false;


    }
    public void registrarCuenta(String nombre, String correo, String direccion){
        Usuario usuario = new Usuario();
        usuario.registrarCuenta(nombre, correo, direccion);
        usuarios.add(usuario);
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
        vendedorActivo = false;
        clienteActivo = false;
    }

    public void eliminarCuenta(){
        usuarioIniciado.eliminarCuenta();
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

