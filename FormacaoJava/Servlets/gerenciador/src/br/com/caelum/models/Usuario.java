package br.com.caelum.models;

public class Usuario {
	private String nome;
	private String senha;

	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isEquals(Usuario u) {
		return u == this;
	}
	
	public boolean isEquals(String nome) {
		return (this.nome.equals(nome));
	}

}
