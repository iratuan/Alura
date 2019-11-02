/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.testes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import br.com.alura.Aula;
import java.util.ArrayList;

/**
 *
 * @author iratuan
 */
public class TestAula {

    ArrayList<Aula> aulas = new ArrayList<>();
    Aula a1 = new Aula("Aula 01", 180);
    Aula a2 = new Aula("Aula 02", 180);
    Aula a3 = new Aula("Aula 03", 180);
    Aula a4 = new Aula("Aula 04", 180);

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
}
