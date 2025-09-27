package vista;

import control.ControlSesion;
import javax.swing.*;
import java.awt.*;

public class LoginDialog extends JDialog {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnRegistro;

    public LoginDialog(JFrame parent, ControlSesion control) {
        super(parent, "Iniciar Sesión", true);
        setSize(350, 180);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Panel de campos
        JPanel campos = new JPanel(new GridLayout(2,2,5,5));
        campos.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        campos.add(new JLabel("Usuario:"));
        txtUsuario = new JTextField();
        campos.add(txtUsuario);
        campos.add(new JLabel("Contraseña:"));
        txtPassword = new JPasswordField();
        campos.add(txtPassword);
        add(campos, BorderLayout.CENTER);

        // Panel de botones
        JPanel botones = new JPanel();
        btnLogin = new JButton("Entrar");
        btnRegistro = new JButton("Registrar");
        botones.add(btnLogin);
        botones.add(btnRegistro);
        add(botones, BorderLayout.SOUTH);

        // Acción botón Entrar
        btnLogin.addActionListener(e -> {
            String usuario = txtUsuario.getText().trim();
            String pass = new String(txtPassword.getPassword());
            if (usuario.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Completa los campos");
                return;
            }
            if (control.verificarUsuario(usuario, pass)) {
                JOptionPane.showMessageDialog(this, "Bienvenido " + usuario);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            }
        });

        // Acción botón Registrar
        btnRegistro.addActionListener(e -> {
            String usuario = txtUsuario.getText().trim();
            String pass = new String(txtPassword.getPassword());
            if (usuario.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Completa los campos para registrar");
                return;
            }
            if (control.registrarUsuario(usuario, pass)) {
                JOptionPane.showMessageDialog(this, "Usuario registrado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "El usuario ya existe");
            }
        });
    }
}
