package br.com.alura.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.caelum.alura.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDao {

	@PersistenceContext(unitName = "AgendamentoPU")
	private EntityManager entityManager;

	public List<AgendamentoEmail> listarAgendamentoEmail() {
		return entityManager.createQuery("select a from AgendamentoEmail a", AgendamentoEmail.class).getResultList();
	}

	public void salvarAgendamentoEmail(AgendamentoEmail agendamentoEmail) {
		entityManager.persist(agendamentoEmail);
	}

	public List<AgendamentoEmail> listarAgendamentosEmailsPorEmail(String email) {
		Query query = entityManager
				.createQuery("select a from AgendamentoEmail a where a.email = :email and a.enviado = false",
						AgendamentoEmail.class)
				.setParameter("email", email);
		return query.getResultList();

	}
	public List<AgendamentoEmail> listarAgendamentosNaoEnviados() {
		Query query = entityManager
				.createQuery("select a from AgendamentoEmail a where a.enviado = false",
						AgendamentoEmail.class);
		return query.getResultList();

	}

	public void atualizaStatusEmail(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setEnviado(true);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(agendamentoEmail);
		tx.commit();
		
	}
}
