package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.playground.controle.SubControle;

public class TesteInstaciaObjetoCorretamente {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException {

		
		try {
			/*
			 * Tipos de criação de instâncias de objetos.
			 */
			Class<SubControle> subControleClasse1 = SubControle.class;
			Class<?> subControleClasse2 = Class.forName("br.com.alura.alurator.playground.controle.SubControle");
			Class<?> controleClass1 = Class.forName("br.com.alura.alurator.playground.controle.Controle");

			// Criando a partir de metodos privados da classe.
			Constructor<?> constructorSubControle = subControleClasse1.getDeclaredConstructor();
			// Modificando os acessos da classe.
			constructorSubControle.setAccessible(true);
			// Instanciando o construtor.
			Object subControle;
			subControle = constructorSubControle.newInstance();
			// Exibindo os resultados.
			System.out.println(subControleClasse1);
			System.out.println(subControle);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
