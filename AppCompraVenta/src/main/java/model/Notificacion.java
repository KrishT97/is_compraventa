package model;

public class Notificacion {

    public static String avisarNotificacion() {

        return "Pronto le llegará la notificacion correspondiente al email propuesto en " + Usuario.getCorreo()+", le notificaremos" +
                " sobre el estado en cuanto haya actualizaciones. Gracias por comprar con nosotros!";
    }
}