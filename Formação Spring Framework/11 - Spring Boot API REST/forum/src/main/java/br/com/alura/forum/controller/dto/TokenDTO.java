package br.com.alura.forum.controller.dto;

public class TokenDTO {

	private String string;
	private String token;

	public TokenDTO(String token, String string) {
		this.token = token;
		this.string = string;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
