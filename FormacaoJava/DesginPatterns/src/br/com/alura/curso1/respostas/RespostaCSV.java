package br.com.alura.curso1.respostas;

import br.com.alura.curso1.Conta;
import br.com.alura.curso1.Formato;
import br.com.alura.curso1.Requisicao;

public class RespostaCSV implements Resposta {

	private Resposta proximaResposta;

	public RespostaCSV(Resposta resposta) {
		this.proximaResposta = resposta;
	}

	@Override
	public String render(Conta conta, Requisicao requisicao) {
		if (requisicao.getFormato() == Formato.CSV) {
			return conta.getTitular() + "; " + conta.getSaldo(); 
		} else {
			return this.proximaResposta.render(conta, requisicao);
		}
	}

}
