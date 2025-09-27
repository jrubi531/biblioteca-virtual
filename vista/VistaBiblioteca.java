package vista;

import javax.swing.*;
import java.awt.*;

public class VistaBiblioteca extends JFrame {

    public VistaBiblioteca() {
        super("Biblioteca");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel principal con BorderLayout
        JPanel panel = new JPanel(new BorderLayout()) {
            // Pintar imagen de fondo
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("imagenes/biblioteca.jpg"); // ruta de tu imagen
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Título
        JLabel label = new JLabel("¡Bienvenido a la Biblioteca!", SwingConstants.CENTER);
        label.setFont(new Font("Georgia", Font.BOLD, 26));
        label.setForeground(Color.WHITE);
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        panel.add(label, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        panelBotones.setOpaque(false); // transparente

        JButton btnBuscar = new JButton("Buscar Libro");
        JButton btnPrestamo = new JButton("Préstamos");
        JButton btnFavoritos = new JButton("Favoritos");

        for (JButton btn : new JButton[]{btnBuscar, btnPrestamo, btnFavoritos}) {
            btn.setFocusPainted(false);
            btn.setBackground(new Color(255, 255, 255, 180)); // semitransparente
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.setPreferredSize(new Dimension(150, 50));
        }

        panelBotones.add(btnBuscar);
        panelBotones.add(btnPrestamo);
        panelBotones.add(btnFavoritos);

        panel.add(panelBotones, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new VistaBiblioteca();
    }
}
