package control;

import Modulo.Biblioteca;
import Modulo.Libro;
import Modulo.Usuario;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

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

    public Biblioteca getBiblioteca() { 
        return biblioteca; 
    }

    public void abrirPDF(Libro libro) {
        try {
            File pdf = new File("pdfs/" + libro.getArchivoPDF());
            if (pdf.exists()) {
                Desktop.getDesktop().open(pdf);
            } else {
                System.out.println("El archivo PDF no existe: " + libro.getArchivoPDF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
