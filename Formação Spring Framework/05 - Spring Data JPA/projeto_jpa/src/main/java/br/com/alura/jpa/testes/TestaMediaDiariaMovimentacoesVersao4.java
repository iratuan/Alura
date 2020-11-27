package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.dao.MovimentacaoDAO;
import br.com.alura.jpa.modelo.MediaComData;

public class TestaMediaDiariaMovimentacoesVersao4 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		List<MediaComData> mediasMovimentacoes = new MovimentacaoDAO(em).getMediaDiariaDasMovimentacoes();
		for (MediaComData mcd : mediasMovimentacoes) {
			System.out.println("MEDIA: " + mcd.getMedia() + ": DATA: " + mcd.getFullData());
		}
	}
}
