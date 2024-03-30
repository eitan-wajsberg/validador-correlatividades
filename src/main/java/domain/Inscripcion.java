package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Inscripcion {
    private Set<Materia> materias;
    private Alumno alumno;

    public Inscripcion(Alumno alumno) {
        this.materias = new HashSet<>();
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void agregarMaterias(Materia ...materias) {
        Collections.addAll(this.materias, materias);
    }

    public boolean aprobada() {
        return materias
                .stream()
                .allMatch(materia -> this.alumno.puedeCursarMateria(materia));
    }
}
