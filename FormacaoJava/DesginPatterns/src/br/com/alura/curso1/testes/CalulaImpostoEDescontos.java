package br.com.alura.curso1.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.curso1.CompraCasada;
import br.com.alura.curso1.Item;
import br.com.alura.curso1.Orcamento;
import br.com.alura.curso1.calculadoras.CalculadorDesconto;
import br.com.alura.curso1.calculadoras.CalculadorImposto;
import br.com.alura.curso1.impostos.ICCC;
import br.com.alura.curso1.impostos.ICMS;
import br.com.alura.curso1.impostos.ISS;

class CalulaImpostoEDescontos {

	@Test
	void testImposto() {
		CalculadorImposto calculadorImposto = new CalculadorImposto();
		Orcamento orcamento = new Orcamento(500.0);
		assertEquals(orcamento.getValor()*0.10, calculadorImposto.calcula(new ICMS(), orcamento));
		assertEquals(orcamento.getValor()*0.06, calculadorImposto.calcula(new ISS(), orcamento));
		orcamento.setValor(999.0);		
		assertEquals(orcamento.getValor()*0.05, calculadorImposto.calcula(new ICCC(), orcamento));
		orcamento.setValor(1200.0);		
		assertEquals(orcamento.getValor()*0.07, calculadorImposto.calcula(new ICCC(), orcamento));
	}
	
	@Test
	void testDesconto() {
		CalculadorDesconto calculadorDesconto = new CalculadorDesconto();
		Orcamento orcamento = new Orcamento(500.0);
		
		
		orcamento.adicionaItem(new Item("Livro",500));
		orcamento.adicionaItem(new Item("Bola",200));
		orcamento.adicionaItem(new Item("Carrinho",200));
		orcamento.adicionaItem(new Item("Celular",400));
		orcamento.adicionaItem(new Item("Chapeu",100));
		orcamento.adicionaItem(new Item("Violao",200));
		
		System.out.println(calculadorDesconto.calcula(orcamento));
	}
	
	@Test
	void testDescontoCompraCasada() {
		CalculadorDesconto calculadorDesconto = new CalculadorDesconto();
		Orcamento orcamento = new Orcamento(500.0);
		CompraCasada compraCasada = new CompraCasada(orcamento);
		
		compraCasada.setCompraCasada(new Item("Lapis",10.0));
		compraCasada.setCompraCasada(new Item("Caneta",10.0));		
		
		orcamento.adicionaItem(new Item("Livro",500));
		orcamento.adicionaItem(new Item("Bola",200));
		orcamento.adicionaItem(new Item("Carrinho",200));
		orcamento.adicionaItem(new Item("Celular",400));
		orcamento.adicionaItem(new Item("Chapeu",100));
		orcamento.adicionaItem(new Item("Violao",200));
		
		System.out.println(calculadorDesconto.calcula(orcamento));
	}
}
