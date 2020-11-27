package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.dao.MovimentacaoDAO;

public class TestaSomaMovimentacoes2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		BigDecimal somaMovimentacoes = new MovimentacaoDAO(em).getSoma();
		System.out.println(somaMovimentacoes);
	}
}
