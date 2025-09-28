package paneles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelInferior extends JPanel {

    private JButton btnUsuario;
    private JButton btnFavoritos;
    private JButton btnHistorial;

    public PanelInferior() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 60, 10));
        setOpaque(false); // Fondo transparente para dibujar degradado

        btnUsuario = crearBoton("Assets/usuario.png", "Usuario");
        btnFavoritos = crearBoton("Assets/corazon.png", "Favoritos");
        btnHistorial = crearBoton("Assets/Historial.png", "Historial");

        
        btnUsuario.addActionListener(e -> mostrarMensaje("👤 Sección Usuario\nPróximamente disponible."));
        btnFavoritos.addActionListener(e -> mostrarMensaje("❤️ Favoritos\nEn construcción..."));
        btnHistorial.addActionListener(e -> mostrarMensaje("📖 Historial\nUps, esta función no está lista."));

        add(btnUsuario);
        add(btnFavoritos);
        add(btnHistorial);
    }

    private JButton crearBoton(String ruta, String texto) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

        JButton boton = new JButton(texto, new ImageIcon(img));
        boton.setFont(new Font("SansSerif", Font.BOLD, 13));
        boton.setForeground(new Color(255, 215, 0)); // Dorado brillante
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setForeground(new Color(255, 223, 80)); // Más brillante
                boton.setIcon(new ImageIcon(icon.getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setForeground(new Color(255, 215, 0));
                boton.setIcon(new ImageIcon(img));
            }
        });

        return boton;
    }

    // 👉 Método para mostrar mensajes emergentes
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Información",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(15, 15, 15),
                getWidth(), getHeight(), new Color(40, 40, 40)
        );
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        
        g2d.setColor(new Color(0, 0, 0, 120));
        g2d.fillRect(0, 0, getWidth(), 5);
    }

    
    public JButton getBtnUsuario() { return btnUsuario; }
    public JButton getBtnFavoritos() { return btnFavoritos; }
    public JButton getBtnHistorial() { return btnHistorial; }
}
