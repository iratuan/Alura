package br.com.iratuan.pocs;

public class Dados {
	private String versao;
	private String idDispositivo;
	private String conteudo;
	private Usuario usuario;
	private boolean aceiteLGPD = false;
	
	

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isAceiteLGPD() {
		return aceiteLGPD;
	}

	public void setAceiteLGPD(boolean aceiteLGPD) {
		this.aceiteLGPD = aceiteLGPD;
	}
	
	@Override
	public String toString() {
		return "{\"versao\":\"" +this.versao + "\","
				+ "\"idDispositivo\":\" " + this.idDispositivo + "\","
				+ "\"conteudo\":\" " + this.conteudo.replace("\"", "/\"") + " \","
				+ "\"aceiteLGPD\":\" " + this.aceiteLGPD + "\","
				+ "\"usuario\":\" " + this.usuario +"\"}";
	}

}
