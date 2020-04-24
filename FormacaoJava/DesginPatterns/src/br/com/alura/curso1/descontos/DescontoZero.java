package br.com.alura.curso1.descontos;

import br.com.alura.curso1.Orcamento;

public class DescontoZero implements Desconto {

	@Override
	public double desconto(Orcamento orcamento) {		
		return 0;
	}

}
