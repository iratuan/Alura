
package br.com.alura.testes;


import br.com.alura.Aluno;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAlunos {
    Aluno a1;
    Aluno a2;
    
    Set<Aluno> alunos;
    
    public TestAlunos() {
        a1 = new Aluno("Iratuã Junior");
        a2 = new Aluno("Erika Rosal");
        alunos = new HashSet<Aluno>();
    }
    
    @Test
    public void testaSetNome(){
        a1.setNome("Francisco Iratuã Nobre Júnior");
        assertEquals("Francisco Iratuã Nobre Júnior", a1.getNome());
    }
    
    @Test
    public void testaAdicionaAlunos(){
        alunos.add(a1);
        alunos.add(a2);
        assertEquals(2,alunos.size());
    }
    
    @Test
    public void testaBuscarAluno(){
        alunos.add(a1);
        assertTrue(alunos.contains(a1));        
    }
    
    @Test 
    public void testaRemoveAluno(){
        alunos.add(a1);
        alunos.add(a2);
        alunos.remove(a1);
        assertEquals(1, this.alunos.size());
        
    }
    
    @Test
    public void testaOrdenaAlunosPorNome(){
        alunos.add(a1);
        alunos.add(a2);
        
        List alunosOrdenados = new ArrayList(this.alunos);
        alunosOrdenados.sort(Comparator.comparing(Aluno::getNome));
        this.alunos = new HashSet(alunosOrdenados);
        assertEquals(a2, alunosOrdenados.get(0));
    }
   
}
