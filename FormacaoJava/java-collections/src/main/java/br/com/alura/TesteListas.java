/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura;

import java.util.ArrayList;

/**
 *
 * @author iratuan
 */
public class TesteListas {
    public static void main(String[] args) {
        String aula1 = "Conhecendo mais de Listas";
        String aula2 = "Modelando a classe Aula";
        String aula3 = "Trabalhando com Cursos e Sets";
        
        ArrayList<String> aulas = new ArrayList<>();
        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);
        
        System.out.println("FOR EM OBJETOS");
        for (String aula : aulas) {
            System.out.println("Aula: " + aula);
        }
        
        System.out.println("FOR FUNCIONAL");
        aulas.forEach((aula) -> {
            System.out.println("Aula:" + aula);
        });
        
        System.out.println("PEGANDO UM ELEMENTO");
        String primeiraAula = aulas.get(0);
        System.out.println("A primeira aula é: " + primeiraAula);
        
        System.out.println("FOR TRADICIONAL");
        for(int i = 0; i < aulas.size(); i ++){
            System.out.println("Aula atual: " + aulas.get(i));
        }
        
        System.out.println("FOREACH");
        aulas.forEach(aula -> {
            System.out.println("Aula :" + aula);
        });
    }
}

