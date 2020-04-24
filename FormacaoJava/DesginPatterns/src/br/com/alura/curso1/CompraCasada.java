package br.com.alura.curso1;

import java.util.HashMap;
import java.util.Map;

public class CompraCasada{

	private Orcamento orcamento;
	private Map<Orcamento, Item> comprasCasadas = new HashMap<Orcamento, Item>();


	public CompraCasada(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public Map<Orcamento, Item> getComprasCasadas() {
		return comprasCasadas;
	}

	public void setCompraCasada(Item item) {
		this.comprasCasadas.put(orcamento, item);
	}

}
