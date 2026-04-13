# refactoring-lab

Laboratorio de refactorizacion: de un **God Object** a un diseno limpio aplicando el **Principio de Responsabilidad Unica (SRP)**.

Unidad 6 — Antipatrones de Diseno  
Patrones de Diseno de Software · Ingenieria de Sistemas · UDES · 2026

---

## Antipatron identificado: God Object

`GestorBiblioteca` es un God Object porque concentra **4 responsabilidades distintas** en una sola clase. Tiene 4 razones independientes para cambiar, lo que viola directamente el SRP.

| # | Responsabilidad | Razon de cambio |
|---|----------------|-----------------|
| 1 | Gestion del catalogo de libros | Cambiar como se almacenan o buscan libros |
| 2 | Gestion de socios | Cambiar reglas de registro o validacion de email |
| 3 | Gestion de prestamos | Cambiar reglas de negocio del prestamo |
| 4 | Generacion de reportes | Cambiar formato o contenido de los reportes |

---

## Patron aplicado: SRP (Single Responsibility Principle)

Cada clase del nuevo diseno tiene **una sola razon para cambiar**:

```
GestorBiblioteca (God Object)
         │
         ├── CatalogoLibros     → solo gestiona libros
         ├── RegistroSocios     → solo gestiona socios
         ├── ServicioPrestamos  → solo gestiona prestamos
         └── GeneradorReportes  → solo genera reportes
```

Las dependencias se inyectan por constructor en `ServicioPrestamos` y `GeneradorReportes`, lo que facilita las pruebas unitarias.

---

## Estructura del proyecto

```
refactoring-lab/
├── pom.xml
└── src/main/java/com/universidad/antipatrones/
    ├── GestorBiblioteca.java   ← God Object original (version inicial)
    ├── Libro.java              ← Clase de dominio
    ├── Socio.java              ← Clase de dominio
    ├── CatalogoLibros.java     ← Especializada: libros
    ├── RegistroSocios.java     ← Especializada: socios
    ├── ServicioPrestamos.java  ← Especializada: prestamos
    ├── GeneradorReportes.java  ← Especializada: reportes
    └── Main.java               ← Demuestra antes y despues
```

---

## Como ejecutar

```bash
# Compilar
mvn compile

# Ejecutar
mvn exec:java
```

### Salida esperada

```
========================================
  VERSION 1 - God Object (GestorBiblioteca)
========================================
Libro agregado: Clean Code
Libro agregado: Design Patterns
Socio registrado: Ana Torres
Prestamo realizado: libro L01 a socio S01
=== REPORTE BIBLIOTECA ===
Libros registrados: 2
Libros disponibles: 1
Socios registrados: 1
Prestamos activos:  1
==========================
Libro devuelto: Clean Code
=== REPORTE BIBLIOTECA ===
Libros registrados: 2
Libros disponibles: 2
Socios registrados: 1
Prestamos activos:  0
==========================

========================================
  VERSION 2 - Diseno limpio con SRP
========================================
(salida identica a la version 1)
```



## Autor

**Jair Sanjuan**  
Ingenieria de Sistemas — Universidad de Santander (UDES)  
Patrones de Diseno de Software · 2026
