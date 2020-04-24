package br.com.alura.curso1.calculadoras;

import br.com.alura.curso1.Orcamento;
import br.com.alura.curso1.descontos.Desconto;
import br.com.alura.curso1.descontos.DescontoPorItens;
import br.com.alura.curso1.descontos.DescontoPorValor;
import br.com.alura.curso1.descontos.DescontoZero;

public class CalculadorDesconto {
	
	public double calcula(Orcamento orcamento) {
		Desconto d1 = new DescontoPorItens(new DescontoPorValor(new DescontoZero()));		
		return d1.desconto(orcamento);
	}
}
