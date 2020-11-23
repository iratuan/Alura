package br.com.alura.alurator;

import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {

	private String pacoteBase;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}

	public Object executa(String url) {

		Request request = new Request(url);
		String nomeController = request.getNomeControle();

		Object instanciaController = new Reflexao().refleteClasse(pacoteBase + nomeController).getConstrutorPadrao()
				.invocar();
		System.out.println(instanciaController);
		return null;

	}
}
