package paneles;

import javax.swing.*;
import java.awt.*;

public class PanelInferior extends JPanel {

    private JButton btnUsuario;
    private JButton btnFavoritos;
    private JButton btnHistorial;

    public PanelInferior() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 60, 10));
        setBackground(new Color(245, 245, 245));

        btnUsuario = crearBoton("Assets/usuario.png", "Usuario");
        btnFavoritos = crearBoton("Assets/corazon.png", "Favoritos");
        btnHistorial = crearBoton("Assets/simbolo-de-interfaz-de-historial-de-navegacion-de-un-reloj-con-una-flecha.png", "Historial");

        add(btnUsuario);
        add(btnFavoritos);
        add(btnHistorial);
    }

    private JButton crearBoton(String ruta, String texto) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

        JButton boton = new JButton(texto, new ImageIcon(img));
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false); // para que parezca "flat"
        boton.setBorderPainted(false);
        return boton;
    }

    // Getters para usar en VistaBiblioteca
    public JButton getBtnUsuario() { return btnUsuario; }
    public JButton getBtnFavoritos() { return btnFavoritos; }
    public JButton getBtnHistorial() { return btnHistorial; }
}
