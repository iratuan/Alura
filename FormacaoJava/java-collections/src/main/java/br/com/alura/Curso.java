package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Curso {

    private String nome;
    private String instrutor;
    private List<Aula> aulas = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<Aluno>();

    public Curso(String nome, String instrutor) {
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public List<Aula> getAulas() {
        return Collections.unmodifiableList(this.aulas);
    }

    public String getNome() {
        return this.nome;
    }

    public void setAula(Aula a1) {
        this.aulas.add(a1);
    }

    public int getSizeAulas() {
        return this.aulas.size();
    }

    public void removeAula(Aula a1) {
        try {
            this.aulas.remove(a1);
        } catch (Exception e) {
            System.out.println("Um erro ocorreu: " + e.getMessage());
        }

    }

    public void ordenaAulasPorTitulo() {
        List<Aula> aulas;
        aulas = new ArrayList<>(this.getAulas());
        aulas.sort(Comparator.comparing(Aula::getTitulo));
        this.aulas = aulas;
    }

    public double getTempoTotal() {
        return this.getAulas().stream().mapToDouble(Aula::getTempo).sum();
    }

    public String toString() {
        return "[Curso: " + this.getNome() + ", com " + this.getSizeAulas() + " aulas e " + this.getTempoTotal() + " minutos. , Aulas: " + this.getAulas() + "] ";
    }

    public void mantriculaAluno(Aluno a1) {
        this.alunos.add(a1);
    }

    public ArrayList<Aluno> getAlunos() {
        return new ArrayList<>(Collections.unmodifiableCollection(this.alunos));
    }

    public ArrayList<Aluno> ordernaAlunosPorNome() {
        this.alunos.sort(Comparator.comparing(Aluno::getNome));
        return this.getAlunos();
    }

    public boolean alunoEstaMatriculado(String nome) {
        for (Aluno a : alunos) {
            if (a.getNome() == nome) {
                return true;
            }
        }
        return false;
    }
}
