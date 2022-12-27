package model;

import java.util.ArrayList;
import java.util.List;

public class Producto {


    public static List<Integer> ids;
    private double precio;

    public double getPrecio() {
        return precio;
    }

    public static void setIds() {
        ids = new ArrayList<>();
    }

    public static List<Integer> getIds() {
        return ids;
    }

    public static int obtenerOcurrenciasId(int nuevoId){
        int contador = 0;
        for(Integer id : ids){
            if (id == nuevoId){
                contador += 1;
            }
        }
        return contador;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public Producto(int id){
        ids.add(id);
    }


}