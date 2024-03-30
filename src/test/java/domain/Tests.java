package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {
    Materia ayed = new Materia("Algoritmos y Estructuras de Datos");
    Materia md = new Materia("Matematica Discreta");
    Materia pdp = new Materia("Paradigmas de Programacion");
    Materia syo = new Materia("Sistemas y Organizaciones");
    Materia ads = new Materia("Analisis de Sistemas");
    Materia dds = new Materia("Diseño de Sistemas");
    Materia ssl = new Materia("Sintaxis y Semantica de los Lenguajes");
    Alumno martin = new Alumno("Martin Martinez", "208.124.0");
    Inscripcion i = new Inscripcion(martin);

    @Before
    public void setup() {
        pdp.agregarCorrelativas(ayed, md);
        ssl.agregarCorrelativas(ayed, md);
        ads.agregarCorrelativas(syo, ayed);
        dds.agregarCorrelativas(ads, pdp);
        martin.agregarMateriasAprobadas(ayed, md);
    }

    @Test
    public void alumnoPuedeCursarMateriaCuyasCorrelativasTieneAprobadas() {
        Assert.assertTrue(martin.puedeCursarMateria(pdp));
    }

    @Test
    public void alumnoNoPuedeCursarMateriaQueYaTieneAprobada() {
        Assert.assertFalse(martin.puedeCursarMateria(ayed));
    }

    @Test
    public void alumnoNoPuedeCursarMateriaCuyasCorrelativasNoTieneAprobadas() {
        Assert.assertFalse(martin.puedeCursarMateria(dds));
    }

    @Test
    public void inscripcionNoValidaSiElAlumnoNoPuedeCursarTodasLasMaterias() {
        i.agregarMaterias(dds, ads, ssl);
        Assert.assertFalse(i.aprobada());
    }

    @Test
    public void inscripcionValidaSiElAlumnoPuedeCursarTodasLasMaterias() {
        martin.agregarMateriasAprobadas(ayed, md, pdp, ads);
        i.agregarMaterias(dds, ssl);
        Assert.assertTrue(i.aprobada());
    }
}
