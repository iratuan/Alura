package br.com.alura.curso1;

public class ICMS implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {		
		return orcamento.getValor() * 0.10;
	}

}
