package app;

import gui.InterfazGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class AppForm{
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Image faviconImage = null;
        try {
            faviconImage = ImageIO.read(new File("src/main/resources/favicon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        InterfazGUI gui = new InterfazGUI();
        gui.setIconImage(faviconImage);
        gui.setVisible(true);
    }
}



