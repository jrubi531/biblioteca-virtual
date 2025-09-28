package vista;

import control.ControlSesion;

import javax.swing.*;
import java.awt.*;

public class LoginDialog extends JDialog {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnRegistrar;
    private ControlSesion control;

    public LoginDialog(JFrame parent, ControlSesion control) {
        super(parent, "Iniciar Sesión", true);
        this.control = control;

        setSize(350, 180);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel campos = new JPanel(new GridLayout(2,2,5,5));
        campos.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        campos.add(new JLabel("Usuario:"));
        txtUsuario = new JTextField();
        campos.add(txtUsuario);
        campos.add(new JLabel("Contraseña:"));
        txtPassword = new JPasswordField();
        campos.add(txtPassword);
        add(campos, BorderLayout.CENTER);

        btnLogin = new JButton("Iniciar Sesión");
        btnRegistrar = new JButton("Registrar Usuario");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnLogin);
        panelBotones.add(btnRegistrar);
        add(panelBotones, BorderLayout.SOUTH);

        // Acción de login
        btnLogin.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String password = new String(txtPassword.getPassword());

            if(control.verificarUsuario(usuario, password)) {
                dispose(); // cerrar login
                SwingUtilities.invokeLater(() -> new VistaBiblioteca(control));
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción de registro
        btnRegistrar.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String password = new String(txtPassword.getPassword());

            if(usuario.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debes ingresar usuario y contraseña", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if(control.registrarUsuario(usuario, password)) {
                JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                txtUsuario.setText("");
                txtPassword.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
