package vista;

import Modulo.Libro;
import control.ControlBiblioteca;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListaLibros extends JFrame {

    public ListaLibros(List<Libro> libros, ControlBiblioteca controlBiblioteca) {
        super("Mis Libros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setUndecorated(true);
        getContentPane().setBackground(new Color(245, 245, 245));
        setLayout(new BorderLayout());

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panelPrincipal, BorderLayout.CENTER);

        JLabel titulo = new JLabel("📚 Libros Disponibles", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
        titulo.setForeground(new Color(33, 37, 41));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        panelPrincipal.add(titulo, BorderLayout.NORTH);

        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Libro libro : libros) {
            modelo.addElement(libro.getTitulo() + " - " + libro.getAutor());
        }

        JList<String> listaLibros = new JList<>(modelo);
        listaLibros.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        listaLibros.setSelectionBackground(new Color(0, 123, 255));
        listaLibros.setSelectionForeground(Color.WHITE);
        listaLibros.setFixedCellHeight(35);
        listaLibros.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JScrollPane scroll = new JScrollPane(listaLibros);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        panelPrincipal.add(scroll, BorderLayout.CENTER);

        // Abrir PDF con doble click
        listaLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int index = listaLibros.locationToIndex(evt.getPoint());
                    if (index >= 0) {
                        Libro libro = libros.get(index);
                        controlBiblioteca.abrirPDF(libro);
                    }
                }
            }
        });

        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(Color.WHITE);
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCerrar.setBackground(new Color(0, 123, 255));
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        btnCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(e -> dispose());
        panelInferior.add(btnCerrar);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }
}
