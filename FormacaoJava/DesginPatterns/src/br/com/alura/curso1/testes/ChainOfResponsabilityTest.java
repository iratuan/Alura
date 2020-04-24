package br.com.alura.curso1.testes;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.alura.curso1.Conta;
import br.com.alura.curso1.Formato;
import br.com.alura.curso1.Requisicao;
import br.com.alura.curso1.respostas.Resposta;
import br.com.alura.curso1.respostas.RespostaCSV;
import br.com.alura.curso1.respostas.RespostaNula;
import br.com.alura.curso1.respostas.RespostaXML;

class ChainOfResponsabilityTest {

	@Test
	void testChainOfResponsability() {
		Conta conta = new Conta("Iratuan", 500.0);
		Requisicao requisicao = new Requisicao(Formato.CSV);
		Resposta resposta = new RespostaXML(new RespostaCSV(new RespostaNula()));
		String strResposta =  resposta.render(conta, requisicao);
		assertTrue(strResposta.contains("Iratuan; 500.0"));	
		
	}

}
