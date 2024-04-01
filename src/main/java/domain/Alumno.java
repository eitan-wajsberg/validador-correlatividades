package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Alumno {
    private String nombre;
    private Set<Materia> materiasAprobadas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.materiasAprobadas = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
