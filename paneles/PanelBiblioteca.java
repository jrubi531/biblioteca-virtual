package paneles;

import Modulo.Biblioteca;
import Modulo.Libro;
import control.ControlBiblioteca;

import javax.swing.*;
import java.awt.*;

public class PanelBiblioteca extends JPanel {
    private JList<Libro> listaLibros;
    private DefaultListModel<Libro> modeloLista;
    private JButton btnFavorito;
    private JButton btnHistorial;

    public PanelBiblioteca(Biblioteca biblioteca, ControlBiblioteca controlBiblioteca) {
        setLayout(new BorderLayout(10,10));

        modeloLista = new DefaultListModel<>();
        listaLibros = new JList<>(modeloLista);
        listaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(listaLibros);

        JPanel botones = new JPanel(new FlowLayout());
        btnFavorito = new JButton("Agregar a favoritos");
        btnHistorial = new JButton("Marcar historial");
        botones.add(btnFavorito);
        botones.add(btnHistorial);

        add(scroll, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);

        // cargar libros al iniciar
        cargarLibros(biblioteca);

        btnFavorito.addActionListener(e -> {
            Libro sel = listaLibros.getSelectedValue();
            if (sel != null) {
                controlBiblioteca.agregarFavorito(sel);
                JOptionPane.showMessageDialog(this, "Libro agregado a favoritos");
            }
        });

        btnHistorial.addActionListener(e -> {
            Libro sel = listaLibros.getSelectedValue();
            if (sel != null) {
                controlBiblioteca.marcarHistorial(sel);
                JOptionPane.showMessageDialog(this, "Libro agregado al historial");
            }
        });
    }

    public void cargarLibros(Biblioteca biblioteca) {
        modeloLista.clear();
        for (Libro l : biblioteca.getLibros()) {
            modeloLista.addElement(l);
        }
    }
}
