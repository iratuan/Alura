package br.com.alura.forum.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.model.StatusTopico;
import br.com.alura.forum.model.Topico;

public class DetalheTopicoDTO {

	private Long id;
	private String titulo;
	private String mensagem;
	private String nomeAutor;
	private StatusTopico status;
	private List<RespostaDTO> respostas =  new ArrayList<>();

	public DetalheTopicoDTO(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.nomeAutor = topico.getAutor().getNome();
		this.status = topico.getStatus();		
		this.respostas.addAll(topico.getRespostas()
				.stream()
				.map(RespostaDTO::new)
				.collect(Collectors.toList()));

	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public List<RespostaDTO> getRespostas() {
		return respostas;
	}

}
