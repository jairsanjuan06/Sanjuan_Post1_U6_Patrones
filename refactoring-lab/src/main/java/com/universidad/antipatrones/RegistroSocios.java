package com.universidad.antipatrones;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase especializada 2 — Responsabilidad: gestion de socios.
 *
 * SRP aplicado: esta clase solo cambia si cambian las reglas sobre
 * como se registran o validan los socios (ej: nueva validacion de email).
 */
public class RegistroSocios {

    private final List<Socio> socios = new ArrayList<>();

    public void registrar(Socio socio) {
        if (!socio.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email invalido: " + socio.getEmail());
        }
        socios.add(socio);
        System.out.println("Socio registrado: " + socio.getNombre());
    }

    public Optional<Socio> buscarPorId(String id) {
        return socios.stream()
            .filter(s -> s.getId().equals(id))
            .findFirst();
    }

    public boolean existe(String id) { return buscarPorId(id).isPresent(); }

    public int totalSocios() { return socios.size(); }
}
