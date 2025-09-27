package control;

import Modulo.Biblioteca;
import Modulo.Libro;
import Modulo.Usuario;

public class ControlBiblioteca {
private Biblioteca biblioteca;
private ControlSesion controlSesion;

public ControlBiblioteca(Biblioteca biblioteca, ControlSesion controlSesion) {
this.biblioteca = biblioteca;
this.controlSesion = controlSesion;
}

public void agregarFavorito(Libro libro) {
Usuario u = controlSesion.getUsuarioActivo();
if (u != null) {
u.agregarFavorito(libro);
}
}

public void marcarHistorial(Libro libro) {
Usuario u = controlSesion.getUsuarioActivo();
if (u != null) u.agregarHistorial(libro);
}

public Biblioteca getBiblioteca() { return biblioteca; }
}