package br.com.alura.curso1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orcamento {
	private double valor;
	private final List<Item> itens;
	private final CompraCasada compraCasada;
	
	

	public Orcamento(double valor) {
		this.compraCasada = null;
		this.valor = valor;
		itens = new ArrayList<Item>();
	}
	
	public CompraCasada getCompraCasada() {
		return compraCasada;
	}


	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void adicionaItem(Item item) {
		itens.add(item);
	}
	
	public List<Item> getItens(){
		return Collections.unmodifiableList(itens);
	}
	
	public boolean temItemMaiorQueValorX(double valor) {
		for(Item item: getItens()) {
			if(item.getValor() > valor) return true;
		}
		
		return false;
	}
	
}
