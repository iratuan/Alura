package br.com.alura.curso1.impostos;

import br.com.alura.curso1.Orcamento;

public abstract class ImpostoCondicionalTemplate implements Imposto {

	@Override
	public final double calcula(Orcamento orcamento) {
		if(deveUsarMaximaTaxacao(orcamento)) {
			return aplicarMaximaTaxacacao(orcamento);
		}else {
			return aplicarMinimaTaxacao(orcamento);
		}
	}

	public abstract double aplicarMaximaTaxacacao(Orcamento orcamento);

	public abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);

	public abstract double aplicarMinimaTaxacao(Orcamento orcamento);

}
