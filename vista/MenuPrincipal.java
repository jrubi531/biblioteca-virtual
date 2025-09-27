package vista;

import Modulo.Biblioteca;
import control.ControlSesion;
import javax.swing.*;

public class MenuPrincipal extends JFrame {

    private Biblioteca biblioteca;
    private ControlSesion controlSesion;

    // Constructor que recibe Biblioteca y ControlSesion
    public MenuPrincipal(Biblioteca biblioteca, ControlSesion controlSesion) {
        this.biblioteca = biblioteca;
        this.controlSesion = controlSesion;

        setTitle("Menú Principal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Aquí puedes inicializar tus paneles, botones, etc.
        initComponents();
    }

    private void initComponents() {
        // Ejemplo de componente
        JLabel lbl = new JLabel("Bienvenido a la Biblioteca");
        add(lbl);
    }
}
