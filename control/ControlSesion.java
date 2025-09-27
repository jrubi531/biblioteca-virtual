package control;

import Modulo.Usuario;
import Persistencia.ArchivoUsuarios;

public class ControlSesion {
    private ArchivoUsuarios archivoUsuarios;
    private Usuario usuarioActivo;

    public ControlSesion(ArchivoUsuarios archivoUsuarios) {
        this.archivoUsuarios = archivoUsuarios;
    }

    // Verificar usuario para login
    public boolean verificarUsuario(String nombre, String password) {
        System.out.println("Buscando usuario: " + nombre);
        Usuario u = archivoUsuarios.buscarPorNombre(nombre);
        if (u != null) {
            System.out.println("Usuario encontrado: " + u.getNombre());
            System.out.println("Password ingresada: " + password + " / Password real: " + u.getPassword());
            if (u.getPassword().equals(password)) {
                usuarioActivo = u;
                return true;
            }        
        }
        return false;
    }

    // Obtener usuario activo
    public Usuario getUsuarioActivo() { 
        return usuarioActivo; 
    }

    // Registrar un nuevo usuario
    public boolean registrarUsuario(String nombre, String password) {
        if (archivoUsuarios.buscarPorNombre(nombre) != null) return false;
        Usuario u = new Usuario(nombre, password); 
        return archivoUsuarios.guardarUsuario(u);
    }
}
