package vista;

import control.ControlBiblioteca;
import control.ControlSesion;
import Modulo.Biblioteca;
import Modulo.Libro;
import Persistencia.ArchivoUsuarios;
import paneles.PanelRecomendados;
import paneles.PanelBusqueda;
import paneles.PanelInferior; // 👈 importa tu footer
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VistaBiblioteca extends JFrame {

    private ControlBiblioteca controlBiblioteca;

    // Constructor original
    public VistaBiblioteca() {
        super("Biblioteca Moderna");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ArchivoUsuarios archivoUsuarios = new ArchivoUsuarios("usuarios.ser");
        ControlSesion controlSesion = new ControlSesion(archivoUsuarios);

        Biblioteca biblioteca = new Biblioteca();
        controlBiblioteca = new ControlBiblioteca(biblioteca, controlSesion);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(true);
        panel.setBackground(new Color(30, 30, 30));

        // Barra de búsqueda arriba
        PanelBusqueda panelBusqueda = new PanelBusqueda();
        panel.add(panelBusqueda, BorderLayout.NORTH);

        // Libros recomendados en el centro con scroll
        PanelRecomendados panelRecomendados = new PanelRecomendados();
        JScrollPane scrollLibros = new JScrollPane(panelRecomendados);
        scrollLibros.setOpaque(false);
        scrollLibros.getViewport().setOpaque(false);
        scrollLibros.setBorder(BorderFactory.createEmptyBorder());
        panel.add(scrollLibros, BorderLayout.CENTER);

        // Footer con usuario, favoritos e historial 👇
        PanelInferior panelInferior = new PanelInferior();
        panel.add(panelInferior, BorderLayout.SOUTH);

        setContentPane(panel);
        setVisible(true);

        // Eventos de búsqueda
        panelBusqueda.getBtnBuscar().addActionListener(e -> {
            String texto = panelBusqueda.getTxtBusqueda().getText().trim();
            if (!texto.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Buscando: " + texto,
                        "Buscar", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Evento "ver todos"
        panelBusqueda.getBtnVerTodos().addActionListener(e -> {
            List<Libro> listaCompleta = controlBiblioteca.getBiblioteca().getLibros();
            new ListaLibros(listaCompleta, controlBiblioteca);
        });
    }

    // ✅ Constructor extra agregado para LoginDialog
    public VistaBiblioteca(ControlSesion controlSesion) {
        this(); // llama al constructor original
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VistaBiblioteca::new);
    }
}
