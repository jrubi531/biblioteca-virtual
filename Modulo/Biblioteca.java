package Modulo;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Biblioteca {
private List<Libro> libros;


public Biblioteca() {
libros = new ArrayList<>();
}


public void agregarLibro(Libro libro) {
libros.add(libro);
}


public List<Libro> getLibros() {
return libros;
}


public List<Libro> buscarPorTitulo(String texto) {
String t = texto.toLowerCase();
return libros.stream().filter(l -> l.getTitulo().toLowerCase().contains(t) || l.getAutor().toLowerCase().contains(t)).collect(Collectors.toList());
}
}