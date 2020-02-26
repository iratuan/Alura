package br.com.alura.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.caelum.alura.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDao {

	@PersistenceContext(unitName = "AgendamentoPU")
	private EntityManager entityManager;
	
	
	public  List<AgendamentoEmail> listarAgendamentoEmail() {
		return entityManager.createQuery("select a from AgendamentoEmail a", AgendamentoEmail.class).getResultList();
	}
	
	public void salvarAgendamentoEmail(AgendamentoEmail agendamentoEmail) {
		entityManager.persist(agendamentoEmail);
	}
}
