package br.com.alura.curso1.descontos;

import br.com.alura.curso1.Orcamento;

public class DescontoCompraCasada implements Desconto {

	
	 private Desconto proximoDesconto;

	public DescontoCompraCasada(Desconto proximoDesconto) {
		this.proximoDesconto = null;		
	}
	
	@Override
	public double desconto(Orcamento orcamento) {		
		return 0;
	}

}
