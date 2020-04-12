package br.com.alura.curso1.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.curso1.CalculadorImposto;
import br.com.alura.curso1.ICMS;
import br.com.alura.curso1.ISS;
import br.com.alura.curso1.Orcamento;

class CalculaImpostoTeste {

	@Test
	void test() {
		CalculadorImposto calculadorImposto = new CalculadorImposto();
		Orcamento orcamento = new Orcamento();
		orcamento.setValor(500.0);		
		assertEquals(500*0.10, calculadorImposto.calcula(new ICMS(), orcamento));
		assertEquals(500*0.06, calculadorImposto.calcula(new ISS(), orcamento));
	}
}
