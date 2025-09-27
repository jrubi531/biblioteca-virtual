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

    // Guardar un usuario
    public boolean guardarUsuario(Usuario usuario) {
        List<Usuario> usuarios = cargarUsuarios();
        usuarios.add(usuario);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(usuarios);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cargar todos los usuarios
    @SuppressWarnings("unchecked")
    public List<Usuario> cargarUsuarios() {
        File file = new File(archivo);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // ✅ Método que faltaba: buscar usuario por nombre
    public Usuario buscarPorNombre(String nombre) {
        for (Usuario u : cargarUsuarios()) {
            if (u.getNombre().equals(nombre)) {
                return u;
            }
        }
        return null;
    }
}
