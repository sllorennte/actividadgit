package org.example;

import java.util.ArrayList;

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
