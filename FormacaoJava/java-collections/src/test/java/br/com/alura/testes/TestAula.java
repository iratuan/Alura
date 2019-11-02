/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.testes;

import org.junit.Test;
import static org.junit.Assert.*;

import br.com.alura.Aula;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author iratuan
 */
public class TestAula {

    ArrayList<Aula> aulas = new ArrayList<>();
    Aula a1 = new Aula("Aula 01", 30);
    Aula a2 = new Aula("Aula 02", 20);
    Aula a3 = new Aula("Aula 03", 18);
    Aula a4 = new Aula("Aula 04", 75);

    public TestAula() {        
        aulas.add(a1);
        aulas.add(a2);
        aulas.add(a3);
        aulas.add(a4);
    }

    @Test
    public void testaAulas() {
        assertEquals(4, aulas.size());
    }

    @Test
    public void ordenaAulas() {
        assertEquals(1, a2.compareTo(a1));
    }
    
    @Test
    public void testaComparaTempo(){
        aulas.sort(Comparator.comparing(Aula::getTempo));
        assertEquals(a3, aulas.get(0));
    }
}
