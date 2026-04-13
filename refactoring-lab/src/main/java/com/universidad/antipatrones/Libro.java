package com.universidad.antipatrones;

/**
 * Clase de dominio Libro.
 * Reemplaza el array String[] {id, titulo, autor, disponible} del God Object.
 * Ventaja: tipado fuerte, nombres claros, imposible confundir los indices.
 */
public class Libro {

    private final String id;
    private final String titulo;
    private final String autor;
    private boolean disponible = true;

    public Libro(String id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() { return titulo + " (" + autor + ")"; }
}
