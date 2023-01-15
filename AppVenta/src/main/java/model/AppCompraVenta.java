package model;

import java.util.ArrayList;
import java.util.List;

public class AppCompraVenta {
    private final Catalogo catalogo;
    private final Usuario usuario;
    private final Cliente cliente;
    private Vendedor vendedor;
    private boolean vendedorActivo;

    public AppCompraVenta() {
        this.catalogo = new Catalogo();
        this.usuario = new Usuario();
        this.cliente = new Cliente();
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

    public double calcularSuma() {
        return cliente.calcularSuma();
    }


    public void iniciarSesion(String nombre, String correo, String direccion) {
        usuario.iniciarSesion(nombre,correo,direccion);
    }

    public void iniciarVenta(String vendedorID){
        vendedor = new Vendedor(vendedorID);
        vendedorActivo = true;
    }

    public boolean getEstadoVendedor(){
        return vendedorActivo;
    }

    public void cerrarSesion() {
        usuario.cerrarSesion();
        vendedorActivo = false;
    }

    public String getID(){
        return vendedor.getVendedorID();
    }

    public String getUser(){
        return "Usuario con Nombre:" + usuario.getNombre() + ", Correo: " + usuario.getCorreo() + ", y Direccion: " + usuario.getDireccion();
    }


    public List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();
        for (Categoria categoria : catalogo.getCategorias()) {
            productos.addAll(categoria.getProductos());
        }
        return productos;
    }

}

