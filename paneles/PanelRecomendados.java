package paneles;

import javax.swing.*;
import java.awt.*;

public class PanelRecomendados extends JPanel {
    public PanelRecomendados() {
        setOpaque(false);
        setLayout(new GridLayout(1, 3, 15, 0)); // 1 fila, 3 columnas, espacio horizontal

        String[] librosSugerencia = {
            "Assets/librosugerencia1.png",
            "Assets/librosugerencia2.png",
            "Assets/librosugerencia3.png"
        };

        for (String ruta : librosSugerencia) {
            JPanel libroPanel = new JPanel(new BorderLayout());
            libroPanel.setOpaque(false);

            // Cargar imagen original
            ImageIcon icon = new ImageIcon(ruta);
            Image img = icon.getImage();

            // Escalar respetando proporción
            int ancho = 260;
            int alto = (int) (((double) img.getHeight(null) / img.getWidth(null)) * ancho);
            Image imgEscalada = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

            JLabel lblLibro = new JLabel(new ImageIcon(imgEscalada));
            lblLibro.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
            lblLibro.setHorizontalAlignment(SwingConstants.CENTER);
            lblLibro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            libroPanel.add(lblLibro, BorderLayout.CENTER);
            add(libroPanel);
        }
    }
}
