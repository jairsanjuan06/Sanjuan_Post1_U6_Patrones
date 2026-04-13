package com.universidad.antipatrones;

/**
 * Clase principal — demuestra el antes y despues de la refactorizacion.
 *
 * ANTES: un solo objeto GestorBiblioteca lo hace todo (God Object).
 * DESPUES: 4 clases especializadas, cada una con una sola responsabilidad.
 * La salida en consola es identica en ambos casos.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  VERSION 1 — God Object (GestorBiblioteca)");
        System.out.println("========================================");
        ejecutarConGodObject();

        System.out.println();

        System.out.println("========================================");
        System.out.println("  VERSION 2 — Diseno limpio con SRP");
        System.out.println("========================================");
        ejecutarConDisenoLimpio();
    }

    /** Version original — God Object */
    private static void ejecutarConGodObject() {
        GestorBiblioteca gestor = new GestorBiblioteca();

        gestor.agregarLibro("L01", "Clean Code", "Robert Martin");
        gestor.agregarLibro("L02", "Design Patterns", "Gang of Four");
        gestor.registrarSocio("S01", "Ana Torres", "ana@uni.edu");
        gestor.realizarPrestamo("L01", "S01");
        gestor.imprimirReporteCompleto();
        gestor.devolverLibro("L01");
        gestor.imprimirReporteCompleto();
    }

    /** Version refactorizada — clases especializadas (SRP) */
    private static void ejecutarConDisenoLimpio() {
        CatalogoLibros catalogo = new CatalogoLibros();
        RegistroSocios registro = new RegistroSocios();
        ServicioPrestamos prestamos = new ServicioPrestamos(catalogo, registro);
        GeneradorReportes reportes = new GeneradorReportes(catalogo, registro, prestamos);

        catalogo.agregar(new Libro("L01", "Clean Code", "Robert Martin"));
        catalogo.agregar(new Libro("L02", "Design Patterns", "Gang of Four"));
        registro.registrar(new Socio("S01", "Ana Torres", "ana@uni.edu"));
        prestamos.prestar("L01", "S01");
        reportes.imprimirReporteCompleto();
        prestamos.devolver("L01");
        reportes.imprimirReporteCompleto();
    }
}
