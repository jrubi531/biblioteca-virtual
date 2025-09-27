package paneles;

import javax.swing.*;
import java.awt.*;

public class PanelBusqueda extends JPanel {
    private JTextField txtBusqueda;
    private JButton btnBuscar;
    private JButton btnVerTodos; // 🔹 nuevo botón

    public PanelBusqueda() {
        setOpaque(false);
        setLayout(new BorderLayout(10, 0));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtBusqueda = new JTextField();
        txtBusqueda.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtBusqueda.setToolTipText("Buscar por título o autor...");
        txtBusqueda.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE, 2, true),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        txtBusqueda.setBackground(new Color(40, 40, 40));
        txtBusqueda.setForeground(Color.WHITE);

        btnBuscar = new JButton("🔍 Buscar");
        btnBuscar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnBuscar.setBackground(new Color(70, 130, 180));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnVerTodos = new JButton("📚 Ver todos");
        btnVerTodos.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnVerTodos.setBackground(new Color(100, 149, 237));
        btnVerTodos.setForeground(Color.WHITE);
        btnVerTodos.setFocusPainted(false);
        btnVerTodos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        panelBotones.setOpaque(false);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnVerTodos);

        add(txtBusqueda, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.EAST);
    }

    public JTextField getTxtBusqueda() {
        return txtBusqueda;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnVerTodos() {
        return btnVerTodos;
    }
}
