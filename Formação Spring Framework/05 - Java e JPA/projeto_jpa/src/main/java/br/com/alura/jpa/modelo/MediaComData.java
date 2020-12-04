package br.com.alura.jpa.modelo;

public class MediaComData {
	private int dia;
	private int mes;
	private int ano;
	private Double media;
	
	public MediaComData(int dia, int mes, int ano, Double media) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.media = media;
	}
	
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Double getMedia() {
		return media;
	}
	public void setMedia(Double media) {
		this.media = media;
	}
	
	public String getFullData() {
		return dia + "/" + mes + "/" + ano;
	}
	
}
