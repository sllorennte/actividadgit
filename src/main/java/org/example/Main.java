package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class Libro {
    private String titulo;
    private String autor;
    private String isbn;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }
}

class Usuario {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private ArrayList<Libro> librosPendientes;

    public Usuario(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.librosPendientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Libro> getLibrosPendientes() {
        return librosPendientes;
    }

    public void agregarLibroPendiente(Libro libro) {
        librosPendientes.add(libro);
    }

    public void devolverLibro(Libro libro) {
        librosPendientes.remove(libro);
    }
}

class Biblioteca {
    private ArrayList<Libro> librosDisponibles;
    private ArrayList<Usuario> usuarios;

    public Biblioteca() {
        this.librosDisponibles = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        librosDisponibles.add(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public ArrayList<Libro> getLibrosDisponibles() {
        return librosDisponibles;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibro(new Libro("1984", "George Orwell", "9780141036144"));
        biblioteca.agregarLibro(new Libro("Orgullo y prejuicio", "Jane Austen", "9780141439518"));
        biblioteca.agregarLibro(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "9788478884450"));
        biblioteca.agregarLibro(new Libro("El señor de los anillos", "J.R.R. Tolkien", "9780544003415"));
        biblioteca.agregarLibro(new Libro("Crónica de una muerte anunciada", "Gabriel García Márquez", "9788437604728"));
        biblioteca.agregarLibro(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "9788424115945"));
        biblioteca.agregarLibro(new Libro("El nombre del viento", "Patrick Rothfuss", "9788401352836"));
        biblioteca.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", "9780307474728"));

        biblioteca.registrarUsuario(new Usuario("Juan", "Perez", "123456789", "juan@gmail.com"));
        biblioteca.registrarUsuario(new Usuario("María", "Gonzalez", "987654321", "maria@gmail.com"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Ver libros disponibles");
            System.out.println("2. Ver libros pendientes de devolver");
            System.out.println("3. Pedir un libro");
            System.out.println("4. Devolver un libro");
            System.out.println("5. Salir");

            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarLibrosDisponibles(biblioteca);
                    break;
                case 2:
                    mostrarLibrosPendientes(scanner, biblioteca);
                    break;
                case 3:
                    pedirLibro(scanner, biblioteca);
                    break;
                case 4:
                    devolverLibro(scanner, biblioteca);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }
    }

    public static void mostrarLibrosDisponibles(Biblioteca biblioteca) {
        System.out.println("Libros disponibles:");
        for (Libro libro : biblioteca.getLibrosDisponibles()) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " - ISBN: " + libro.getIsbn());
        }
    }

    public static void mostrarLibrosPendientes(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        Usuario usuario = null;
        for (Usuario u : biblioteca.getUsuarios()) {
            if (u.getNombre().equals(nombreUsuario)) {
                usuario = u;
                break;
            }
        }

        if (usuario != null) {
            System.out.println("Libros pendientes de devolver para " + usuario.getNombre() + ":");
            for (Libro libro : usuario.getLibrosPendientes()) {
                System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " - ISBN: " + libro.getIsbn());
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public static void pedirLibro(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        Usuario usuario = null;
        for (Usuario u : biblioteca.getUsuarios()) {
            if (u.getNombre().equals(nombreUsuario)) {
                usuario = u;
                break;
            }
        }

        if (usuario != null) {
            mostrarLibrosDisponibles(biblioteca);
            System.out.print("Ingrese el título del libro que desea pedir: ");
            String tituloLibro = scanner.nextLine();

            Libro libroPedir = null;
            for (Libro libro : biblioteca.getLibrosDisponibles()) {
                if (libro.getTitulo().equals(tituloLibro)) {
                    libroPedir = libro;
                    break;
                }
            }

            if (libroPedir != null) {
                usuario.agregarLibroPendiente(libroPedir);
                biblioteca.getLibrosDisponibles().remove(libroPedir);
                System.out.println("Libro pedido con éxito.");
            } else {
                System.out.println("Libro no encontrado.");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public static void devolverLibro(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        Usuario usuario = null;
        for (Usuario u : biblioteca.getUsuarios()) {
            if (u.getNombre().equals(nombreUsuario)) {
                usuario = u;
                break;
            }
        }

        if (usuario != null) {
            mostrarLibrosPendientes(scanner, biblioteca);
            System.out.print("Ingrese el título del libro que desea devolver: ");
            String tituloLibro = scanner.nextLine();

            Libro libroDevolver = null;
            for (Libro libro : usuario.getLibrosPendientes()) {
                if (libro.getTitulo().equals(tituloLibro)) {
                    libroDevolver = libro;
                    break;
                }
            }

            if (libroDevolver != null) {
                usuario.devolverLibro(libroDevolver);
                biblioteca.agregarLibro(libroDevolver);
                System.out.println("Libro devuelto con éxito.");
            } else {
                System.out.println("Libro no encontrado en la lista de pendientes.");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
}

