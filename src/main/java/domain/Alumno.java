package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Alumno {
    private String nombre;
    private String legajo;
    private Set<Materia> materiasAprobadas;

    public Alumno(String nombre, String legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.materiasAprobadas = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public Set<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void agregarMateriasAprobadas(Materia ...materias) {
        Collections.addAll(this.materiasAprobadas, materias);
    }

    public boolean puedeCursarMateria(Materia materia) {
        return this.materiasAprobadas.containsAll(materia.getCorrelativas())
                && !this.materiasAprobadas.contains(materia);
    }
}
