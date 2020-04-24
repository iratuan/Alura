package br.com.alura.curso1.descontos;

import br.com.alura.curso1.Orcamento;

public class DescontoPorValor implements Desconto {

	private Desconto proximoDesconto;
	
	public DescontoPorValor(Desconto proximoDesconto) {
		this.proximoDesconto = proximoDesconto;		
	}

	public double desconto(Orcamento orcamento) {
		if (orcamento.getValor() > 500) {
			return orcamento.getValor() * 0.07;
		} else {
			return this.proximoDesconto.desconto(orcamento);
		}
	}

}
