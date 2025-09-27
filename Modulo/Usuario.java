package Modulo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String contraseña;
    private List<Libro> favoritos; 
    private List<Libro> historial;   

    public Usuario(String username, String contraseña) {
        this.username = username;
        this.contraseña = contraseña;
        this.favoritos = new ArrayList<>();
        this.historial = new ArrayList<>();
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }

    // Favoritos
    public List<Libro> getFavoritos() { return favoritos; }
    public void agregarFavorito(Libro libro) {
        if (!favoritos.contains(libro)) {
            favoritos.add(libro);
        }
    }
    public void eliminarFavorito(Libro libro) { favoritos.remove(libro); }

    // Historial
    public List<Libro> getHistorial() { return historial; }
    public void agregarHistorial(Libro libro) {
        historial.add(libro); 
    }
}
