package app;

import gui.InterfazGrafica;
import model.AppCompraVenta;

public class AppForm {

    public static void main(String[] args) {
        AppCompraVenta app = new AppCompraVenta();
        app.iniciarCatalogo();
        new InterfazGrafica(app);
    }
}
