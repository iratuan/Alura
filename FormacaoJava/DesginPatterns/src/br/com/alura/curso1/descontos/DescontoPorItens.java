package br.com.alura.curso1.descontos;

import br.com.alura.curso1.Orcamento;

public class DescontoPorItens implements Desconto {

	private Desconto proximoDesconto;
	
	public DescontoPorItens(Desconto proximoDesconto) {
		this.proximoDesconto = proximoDesconto;
	}
	
	@Override
	public double desconto(Orcamento orcamento) {
		if(orcamento.getItens().size() > 5) {
			return orcamento.getValor() * 0.1;
		}else {
			return this.proximoDesconto.desconto(orcamento);
		}
	}

}
