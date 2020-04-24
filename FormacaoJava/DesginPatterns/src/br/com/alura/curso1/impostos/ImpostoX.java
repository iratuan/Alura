package br.com.alura.curso1.impostos;

import br.com.alura.curso1.Orcamento;

public class ImpostoX extends ImpostoCondicionalTemplate {

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500 && orcamento.temItemMaiorQueValorX(100);
	}

	@Override
	public double aplicarMaximaTaxacacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.10;
	}

	@Override
	public double aplicarMinimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

}
