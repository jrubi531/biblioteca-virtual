import javax.swing.*;
import vista.LoginDialog;
import vista.MenuPrincipal;
import Modulo.Biblioteca;
import Modulo.Libro;
import Modulo.Usuario;
import Persistencia.ArchivoUsuarios;
import control.ControlSesion;

public class Main {
    public static void main(String[] args) {
        // Inicializamos persistencia de usuarios
        ArchivoUsuarios archivoUsuarios = new ArchivoUsuarios("usuarios.ser");

        // Crear usuario admin si no hay usuarios
        if (archivoUsuarios.cargarUsuarios().isEmpty()) {
            archivoUsuarios.guardarUsuario(new Usuario("admin", "admin"));
        }

        // Biblioteca de ejemplo
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibro(new Libro("Cien Años de Soledad", "Gabriel García Márquez", "978-1"));
        biblioteca.agregarLibro(new Libro("El Principito", "Antoine de Saint-Exupéry", "978-2"));
        biblioteca.agregarLibro(new Libro("Java: Como Programar", "Deitel", "978-3"));

        // Control de sesión
        ControlSesion controlSesion = new ControlSesion(archivoUsuarios);

        // Crear ventana principal para el login
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);
        ventana.setLocationRelativeTo(null);

        // Mostrar login
        LoginDialog login = new LoginDialog(ventana, controlSesion);
        login.setVisible(true);

        // Si inició sesión, mostrar menú principal
        if (controlSesion.getUsuarioActivo() != null) {
            MenuPrincipal menu = new MenuPrincipal(biblioteca, controlSesion);
            menu.setVisible(true);
        } else {
            System.exit(0); // Salir si no inicia sesión
        }
    }
}
