package org.example;

import java.util.ArrayList;

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
