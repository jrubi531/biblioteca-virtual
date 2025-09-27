package Persistencia;
import Modulo.Libro;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    // Lista de libros
    private List<Libro> libros;

    // Constructor
    public Biblioteca() {
        libros = new ArrayList<>();
    }

    // Agregar un libro a la lista
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // Obtener todos los libros
    public List<Libro> getLibros() {
        return libros;
    }

    // Buscar libros por título o autor
    public List<Libro> buscarPorTitulo(String texto) {
        String t = texto.toLowerCase();
        return libros.stream()
                     .filter(l -> l.getTitulo().toLowerCase().contains(t) ||
                                  l.getAutor().toLowerCase().contains(t))
                     .collect(Collectors.toList());
    }
}
