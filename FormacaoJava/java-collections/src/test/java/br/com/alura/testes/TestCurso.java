package br.com.alura.testes;

import br.com.alura.Aula;
import br.com.alura.Curso;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCurso {

    Curso curso;

    public TestCurso() {
        curso = new Curso("Java", "Iratuã Junior");
    }

    @Test
    public void testaInstanciaCurso() {
        assertEquals("Java", curso.getNome());
    }

    @Test
    public void testaAdiconarAulas() {
        Aula a1 = new Aula("Introducao a JEE", 20);
        this.curso.setAula(a1);
        assertTrue(this.curso.getSizeAulas() == 1);
    }

    @Test
    public void testaRemoveAula() {
        Aula a1 = new Aula("Introducao a JEE", 20);
        this.curso.setAula(a1);
        this.curso.removeAula(a1);
        assertTrue(this.curso.getSizeAulas() == 0);
    }

    @Test
    public void testaGetAulas() {
        Aula a1 = new Aula("Introducao a JEE", 20);
        this.curso.setAula(a1);
        List<Aula> aulas = this.curso.getAulas();
        assertEquals(1, this.curso.getSizeAulas());
    }

    @Test
    public void testaOrdenaPorAula() {
        Aula a1 = new Aula("Introducao a JEE", 20);
        Aula a2 = new Aula("Introducao a JEE 2 ", 9);
        Aula a3 = new Aula("A Introducao a JEE 3 ", 21);

        this.curso.setAula(a1);
        this.curso.setAula(a2);
        this.curso.setAula(a3);

        this.curso.ordenaAulasPorTitulo();

        assertEquals(a3, this.curso.getAulas().get(0));
    }
    
    @Test
    public void testaGetTempoTotal(){
        Aula a1 = new Aula("Introducao a JEE", 20);
        Aula a2 = new Aula("Introducao a JEE 2 ", 9);
        Aula a3 = new Aula("A Introducao a JEE 3 ", 21);

        this.curso.setAula(a1);
        this.curso.setAula(a2);
        this.curso.setAula(a3);

        assertEquals(50.00, this.curso.getTempoTotal(),2);
    }
}
