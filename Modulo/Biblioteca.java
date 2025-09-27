package Modulo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();

        libros.add(new Libro("La Metamorfosis", "Franz Kafka", "119-2014-02-11-Kafka.La metamorfosis.pdf"));
        libros.add(new Libro("Alicia en el país de las maravillas", "Lewis Carroll", "119-2014-02-19-Carroll.AliciaEnElPaisDeLasMaravillas.pdf"));
        libros.add(new Libro("Drácula", "Bram Stoker", "Bram Sttoker Dracula.pdf"));
        libros.add(new Libro("Campus PHP", "Desconocido", "campus_20180320150123phpFtNzv8.pdf"));
        libros.add(new Libro("Cuentos de Edgar Allan Poe", "Edgar Allan Poe", "Edgar Allan Poe Cuentos.pdf"));
        libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", "ElPrincipito.pdf"));
        libros.add(new Libro("Matar un ruiseñor", "Harper Lee", "Harper, Lee - Matar Un Ruiseñor.pdf"));
        libros.add(new Libro("Harry Potter y la Piedra Filosofal", "J.K. Rowling", "Harry_Potter_y_la_Piedra_Filosofal-J_K_Rowling.pdf"));
        libros.add(new Libro("El viejo y el mar", "Ernest Hemingway", "hemingway, ernest - el viejo.pdf"));
        libros.add(new Libro("Don Juan Tenorio", "José Zorrilla", "José Zorrilla Don Juan Tenorio.pdf"));
        libros.add(new Libro("Las Aventuras de Tom Sawyer", "Mark Twain", "Mark Twain - Las Aventuras de Tom Sawyer.pdf"));
        libros.add(new Libro("El Retrato de Dorian Gray", "Oscar Wilde", "Oscar Wilde El Retrato de Dorian Gray.pdf"));
        libros.add(new Libro("Las crónicas de Narnia: El león, la bruja y el ropero", "C.S. Lewis", "texto_las-cronicas-de-narnia-el-leon-la-bruja-y-el-ropero.pdf"));
    }

    public List<Libro> getLibros() {
        return libros;
    }
}
