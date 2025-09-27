package control;

import Modulo.Usuario;
import Persistencia.ArchivoUsuarios;

public class ControlSesion {
    private ArchivoUsuarios archivoUsuarios;
    private Usuario usuarioActivo;

    public ControlSesion(ArchivoUsuarios archivoUsuarios) {
        this.archivoUsuarios = archivoUsuarios;
    }

    // Verifica si el login es correcto
    public boolean verificarUsuario(String nombre, String contrasena) {
        Usuario u = archivoUsuarios.buscarPorNombre(nombre);
        if (u != null && u.getContraseña().equals(contrasena)) {
            usuarioActivo = u;
            return true;
        }
        return false;
    }

    // Registra un usuario nuevo
    public boolean registrarUsuario(String nombre, String contrasena) {
        Usuario nuevo = new Usuario(nombre, contrasena);
        return archivoUsuarios.guardarUsuario(nuevo); // devuelve false si ya existía
    }

    // Obtener usuario activo
    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }
}
