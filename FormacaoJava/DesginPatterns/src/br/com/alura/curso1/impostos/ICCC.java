package br.com.alura.curso1.impostos;

import br.com.alura.curso1.Orcamento;

public class ICCC implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {
		if (orcamento.getValor() < 1000) {
			return orcamento.getValor() * 0.05;
		} else if (orcamento.getValor() <= 3000) {
			return orcamento.getValor() * 0.07;
		} else {
			return orcamento.getValor() * 0.08 + 30;
		}
	}
}
