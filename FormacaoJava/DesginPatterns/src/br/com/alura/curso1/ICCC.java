package br.com.alura.curso1;

public class ICCC implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {	
		if(orcamento.getValor() < 1000.0) {			
			return orcamento.getValor() * 0.05;
		}		
		return orcamento.getValor() * 0.07;
	}
}
