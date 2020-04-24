package br.com.alura.curso1.calculadoras;

import br.com.alura.curso1.Orcamento;
import br.com.alura.curso1.impostos.Imposto;

public class CalculadorImposto {
	public double calcula(Imposto imposto, Orcamento orcamento) {
		return imposto.calcula(orcamento);
	}
}
