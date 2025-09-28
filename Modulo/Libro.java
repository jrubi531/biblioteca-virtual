package Modulo;

public class Libro {
    private String titulo;
    private String autor;
    private String archivoPDF; 

    public Libro(String titulo, String autor, String archivoPDF) {
        this.titulo = titulo;
        this.autor = autor;
        this.archivoPDF = archivoPDF;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getArchivoPDF() {
        return archivoPDF;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor;
    }
}
