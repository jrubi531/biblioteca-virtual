package vista;

import control.ControlSesion;

import javax.swing.*;
import java.awt.*;

public class LoginDialog extends JDialog {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private ControlSesion control;

    public LoginDialog(JFrame parent, ControlSesion control) {
        super(parent, "Iniciar Sesión", true);
        this.control = control;

        setSize(350, 180);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel campos = new JPanel(new GridLayout(2,2));
        campos.add(new JLabel("Usuario:"));
        txtUsuario = new JTextField();
        campos.add(txtUsuario);
        campos.add(new JLabel("Contraseña:"));
        txtPassword = new JPasswordField();
        campos.add(txtPassword);
        add(campos, BorderLayout.CENTER);

        btnLogin = new JButton("Iniciar Sesión");
        add(btnLogin, BorderLayout.SOUTH);

        btnLogin.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String password = new String(txtPassword.getPassword());

            if(control.verificarUsuario(usuario, password)) {
                dispose(); // cerrar login
                // Abrir la VistaBiblioteca
                SwingUtilities.invokeLater(() -> new VistaBiblioteca());
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
