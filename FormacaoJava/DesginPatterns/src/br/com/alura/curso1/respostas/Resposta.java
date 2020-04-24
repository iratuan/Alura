package br.com.alura.curso1.respostas;

import br.com.alura.curso1.Conta;
import br.com.alura.curso1.Requisicao;

public interface Resposta {

	String render(Conta conta, Requisicao requisicao);
}
