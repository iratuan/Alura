package br.com.alura.alurator.playground.controle;

import java.io.IOException;

public class SubControle extends Controle {

	private SubControle() throws IOException{
		System.out.println("Conseguimos criar um subcontroller");
	}
	
	private SubControle(String s) {
		
	}
}
