package com.universidad.antipatrones;

/**
 * Clase de dominio Socio.
 * Reemplaza el array String[] {id, nombre, email} del God Object.
 */
public class Socio {

    private final String id;
    private final String nombre;
    private final String email;

    public Socio(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }

    @Override
    public String toString() { return nombre + " <" + email + ">"; }
}
