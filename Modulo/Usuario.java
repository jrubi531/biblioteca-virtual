package Modulo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String password;
    private List<Libro> favoritos;
    private List<Libro> historial;

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        this.favoritos = new ArrayList<>();
        this.historial = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    // Método para agregar un libro a favoritos
    public void agregarFavorito(Libro libro) {
        favoritos.add(libro);
    }

    // Método para agregar un libro al historial
    public void agregarHistorial(Libro libro) {
        historial.add(libro);
    }

    // Opcional: obtener favoritos e historial
    public List<Libro> getFavoritos() {
        return favoritos;
    }

    public List<Libro> getHistorial() {
        return historial;
    }
}

