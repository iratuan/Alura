package br.com.caelum.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Empresa {
	
	private int id;
	private String nome;
	private Date dataAbertura;
	
	
	public Empresa(String nome, String dataAbertura){
		this.nome = nome;
		this.id = Banco.listaEmpresas().size() + 1;
		try {
			this.dataAbertura = this.setDataAbertura(dataAbertura);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

	}

	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	private Date setDataAbertura(String data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.parse(data);
	}
	
	public Date getDataAbertura() {
		return this.dataAbertura;
	}
		
}
