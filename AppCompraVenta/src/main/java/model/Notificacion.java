package model;

public class Notificacion {

    public String avisarNotificacion(Usuario usuario) {

        return "Pronto le llegará la notificacion correspondiente al email propuesto en " + usuario.getCorreo()+", le notificaremos" +
                " sobre el estado en cuanto haya actualizaciones. Gracias por comprar con nosotros!";
    }
}