package br.com.alura.curso1.impostos;

import br.com.alura.curso1.Orcamento;

public class ImpostoICPP extends ImpostoCondicionalTemplate {

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500;
	}

	@Override
	public double aplicarMaximaTaxacacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}

	@Override
	public double aplicarMinimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}

}
