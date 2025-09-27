package Persistencia;

import Modulo.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUsuarios {
    private String archivo;

    public ArchivoUsuarios(String archivo) {
        this.archivo = archivo;
    }

    // Guardar un usuario nuevo
    public boolean guardarUsuario(Usuario usuario) {
        List<Usuario> usuarios = cargarUsuarios(); // cargar usuarios existentes
        // Verificar si ya existe el usuario
        if (buscarPorNombre(usuario.getUsername(), usuarios) != null) {
            return false; // usuario ya existe
        }

        usuarios.add(usuario); // agregar nuevo usuario

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(usuarios); // sobrescribir archivo con la lista actualizada
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cargar todos los usuarios
    public List<Usuario> cargarUsuarios() {
        File f = new File(archivo);
        if (!f.exists()) {
            return new ArrayList<>(); // archivo no existe → lista vacía
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Usuario>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // error de lectura → lista vacía
        }
    }

    // Buscar usuario por nombre
    public Usuario buscarPorNombre(String nombre) {
        List<Usuario> usuarios = cargarUsuarios();
        return buscarPorNombre(nombre, usuarios);
    }

    // Método interno para búsqueda en lista dada
    private Usuario buscarPorNombre(String nombre, List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equalsIgnoreCase(nombre)) {
                return u;
            }
        }
        return null;
    }
}
