
import Persistencia.ArchivoUsuarios;
import control.ControlSesion;
import vista.LoginDialog;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArchivoUsuarios archivoUsuarios = new ArchivoUsuarios("usuarios.ser");
            ControlSesion control = new ControlSesion(archivoUsuarios);

            JFrame frame = new JFrame(); // solo para padre del dialog
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(false); // no mostrar

            LoginDialog login = new LoginDialog(frame, control);
            login.setVisible(true); // se abre el login
        });
    }
}
