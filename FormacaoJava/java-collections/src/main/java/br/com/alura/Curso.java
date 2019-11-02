package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Curso {

    private String nome;
    private String instrutor;
    private List<Aula> aulas = new ArrayList<>();

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
}
