package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoComParametro {
	public static void main(String[] args) throws Exception {
		Class<?> subControleClasse = Class.forName("br.com.alura.alurator.playground.controle.SubControle");

		Constructor<?> construtorPadrao = getConstrutor(subControleClasse);
		Object subControle = construtorPadrao.newInstance();

		Method metodo = subControleClasse.getDeclaredMethod("metodoSubControle");
		metodo.setAccessible(true);
		Object retorno = metodo.invoke(subControle);
		System.out.println(retorno);

	}

	private static Constructor<?> getConstrutor(Class<?> subControleClasse) throws NoSuchMethodException {
		Constructor<?> construtorPadrao = subControleClasse.getDeclaredConstructor();
		construtorPadrao.setAccessible(true);
		return construtorPadrao;
	}
}
