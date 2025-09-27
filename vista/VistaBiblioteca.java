package vista;

import paneles.PanelRecomendados;
import paneles.PanelBusqueda;
import javax.swing.*;
import java.awt.*;

public class VistaBiblioteca extends JFrame {
    public VistaBiblioteca() {
        super("Biblioteca Moderna");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(true);
        panel.setBackground(new Color(30, 30, 30));

        // Panel de búsqueda
        PanelBusqueda panelBusqueda = new PanelBusqueda();
        panel.add(panelBusqueda, BorderLayout.NORTH);

        // Panel de recomendados dentro de scroll
        PanelRecomendados panelRecomendados = new PanelRecomendados();
        JScrollPane scrollLibros = new JScrollPane(panelRecomendados);
        scrollLibros.setOpaque(false);
        scrollLibros.getViewport().setOpaque(false);
        scrollLibros.setBorder(BorderFactory.createEmptyBorder());

        panel.add(scrollLibros, BorderLayout.CENTER);

        setContentPane(panel);
        setVisible(true);

        // Acción del botón buscar
        panelBusqueda.getBtnBuscar().addActionListener(e -> {
            String texto = panelBusqueda.getTxtBusqueda().getText().trim();
            if (!texto.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Buscando: " + texto, 
                    "Buscar", JOptionPane.INFORMATION_MESSAGE);
                // Aquí luego conectamos con Biblioteca.buscarPorTitulo()
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VistaBiblioteca::new);
    }
}
