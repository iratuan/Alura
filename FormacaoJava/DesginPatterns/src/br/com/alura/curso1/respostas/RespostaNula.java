package br.com.alura.curso1.respostas;

import br.com.alura.curso1.Conta;
import br.com.alura.curso1.Requisicao;

public class RespostaNula implements Resposta {

	@Override
	public String render(Conta conta, Requisicao requisicao) {
		return null;
	}

}
