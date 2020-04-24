package br.com.alura.curso1.respostas;

import br.com.alura.curso1.Conta;
import br.com.alura.curso1.Formato;
import br.com.alura.curso1.Requisicao;

public class RespostaXML implements Resposta {

	private Resposta proximaResposta;

	public RespostaXML(Resposta resposta) {
		this.proximaResposta = resposta;
	}

	@Override
	public String render(Conta conta, Requisicao requisicao) {
		if (requisicao.getFormato() == Formato.XML) {
			return "<conta>" 
						+ "<titular>" + conta.getTitular() + "</titular>" 
					    + "<saldo>" + conta.getSaldo()
					    + "</saldo>" 
					    + "</conta>";

		} else {
			return this.proximaResposta.render(conta, requisicao);
		}
	}

}
