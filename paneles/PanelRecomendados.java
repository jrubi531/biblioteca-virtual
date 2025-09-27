package paneles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class PanelRecomendados extends JPanel {
    public PanelRecomendados() {
        setOpaque(false);
        setLayout(new GridLayout(1, 3, 15, 0)); // 1 fila, 3 columnas, espacio horizontal

        // Imagen + PDF
        String[][] librosSugerencia = {
            {"Assets/librosugerencia1.png", "pdfs/Harper, Lee - Matar Un Ruiseñor.pdf"},
            {"Assets/librosugerencia2.png", "pdfs/texto_las-cronicas-de-narnia-el-leon-la-bruja-y-el-ropero.pdf"},
            {"Assets/librosugerencia3.png", "pdfs/Harry_Potter_y_la_Piedra_Filosofal-J_K_Rowling.pdf"}
        };
        

        for (String[] datos : librosSugerencia) {
            String rutaImagen = datos[0];
            String rutaPDF = datos[1];

            JPanel libroPanel = new JPanel(new BorderLayout());
            libroPanel.setOpaque(false);

            // Cargar imagen original
            ImageIcon icon = new ImageIcon(rutaImagen);
            Image img = icon.getImage();

            // Escalar respetando proporción
            int ancho = 260;
            int alto = (int) (((double) img.getHeight(null) / img.getWidth(null)) * ancho);
            Image imgEscalada = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

            JLabel lblLibro = new JLabel(new ImageIcon(imgEscalada));
            lblLibro.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
            lblLibro.setHorizontalAlignment(SwingConstants.CENTER);
            lblLibro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            // Abrir PDF al hacer click
            lblLibro.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        Desktop.getDesktop().open(new File(rutaPDF));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,
                                "No se pudo abrir el archivo PDF:\n" + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            libroPanel.add(lblLibro, BorderLayout.CENTER);
            add(libroPanel);
        }
    }
}
