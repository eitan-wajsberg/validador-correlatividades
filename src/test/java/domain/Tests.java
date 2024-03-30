package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlumnoTest {
    Materia ayed = new Materia("Algoritmos y Estructuras de Datos");
    Materia md = new Materia("Matematica Discreta");
    Materia pdp = new Materia("Paradigmas de Programacion");
    Materia syo = new Materia("Sistemas y Organizaciones");
    Materia ads = new Materia("Analisis de Sistemas");
    Materia dds = new Materia("Diseño de sistemas");
    Alumno martin = new Alumno("Martin Martinez", "208.124.0");

    @Before
    public void setup() {
        pdp.agregarCorrelativas(ayed, md);
        ads.agregarCorrelativas(syo, ayed);
        dds.agregarCorrelativas(ads, pdp);
    }

    @Test
    public void alumnoPuedeCursarMateriaCuyasCorrelativasTieneAprobadas() {
        martin.agregarMateriasAprobadas(ayed, md);
        Assert.assertTrue(martin.puedeCursarMateria(pdp));
    }

    @Test
    public void alumnoNoPuedeCursarMateriaQueYaTieneAprobada() {
        martin.agregarMateriasAprobadas(ayed);
        Assert.assertFalse(martin.puedeCursarMateria(ayed));
    }

    @Test
    public void alumnoNoPuedeCursarMateriaCuyasCorrelativasNoTieneAprobadas() {
        martin.agregarMateriasAprobadas(ayed);
        Assert.assertFalse(martin.puedeCursarMateria(pdp));
    }

    @Test
    public void inscripcionNoValidaSiElAlumnoNoPuedeCursarTodasLasMaterias() {
        //TODO
    }

    @Test
    public void inscripcionValidaSiElAlumnoPuedeCursarTodasLasMaterias() {
        //TODO
    }
}
