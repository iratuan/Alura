package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.Controle;

public class TesteInstanciaObjeto {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// Tipos de criação de classes.
		Class<Controle> controleClasse1 = Controle.class;
		Controle controle = new Controle();
		Class<? extends Controle> controleClasse2 = controle.getClass();
		Class<?> controleClasse3 = Class.forName("br.com.alura.alurator.playground.controle.Controle");
		
		// Retorna um objeto
		Controle objetoControle1 = controleClasse1.newInstance();
		Controle objetoControle2 = controleClasse2.newInstance();
		Object objetoControle3 = controleClasse3.newInstance();
		
		System.out.println(objetoControle1 instanceof Controle);
		System.out.println(objetoControle2 instanceof Controle);
		System.out.println(objetoControle2 instanceof Controle);
	}
}

