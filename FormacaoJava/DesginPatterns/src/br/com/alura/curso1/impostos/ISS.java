package br.com.alura.curso1.impostos;

import br.com.alura.curso1.Orcamento;

public class ISS implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {		
		return orcamento.getValor() * 0.06;
	}

}
