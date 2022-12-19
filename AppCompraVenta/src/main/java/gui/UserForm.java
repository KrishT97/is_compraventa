package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserForm extends JFrame {

    private JTextField nombreUsuarioField;
    private JPasswordField contraseñaField;
    private JButton iniciarSesionButton;
    private JButton cerrarSesionButton;

    public UserForm() {
        // configurar la ventana
        setTitle("Iniciar sesión");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // crear los componentes de la interfaz
        nombreUsuarioField = new JTextField(20);
        contraseñaField = new JPasswordField(20);
        iniciarSesionButton = new JButton("Iniciar sesión");
        cerrarSesionButton = new JButton("Cerrar sesión");

        // agregar los componentes a la ventana
        add(new JLabel("Nombre de usuario:"));
        add(nombreUsuarioField);
        add(new JLabel("Contraseña:"));
        add(contraseñaField);
        add(iniciarSesionButton);
        add(cerrarSesionButton);

        // agregar listeners a los botones
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: implementar la lógica para iniciar sesión
                JOptionPane.showMessageDialog(UserForm.this, "Proceso realizado correctamente");
            }
        });
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: implementar la lógica para cerrar sesión
                JOptionPane.showMessageDialog(UserForm.this, "Cerrando sesion");


            }
        });
    }
}
