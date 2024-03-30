package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Materia {
    private String nombre;
    public Set<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Materia> getCorrelativas() {
        return correlativas;
    }

    public void agregarCorrelativas(Materia ...materias) {
        Collections.addAll(this.correlativas, materias);
    }
}
