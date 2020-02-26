package br.com.alura.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

import br.caelum.alura.entity.AgendamentoEmail;
import br.com.alura.dao.AgendamentoEmailDao;

@Stateless
public class AgendamentoEmailBusiness {

	@Inject
	AgendamentoEmailDao agendamentoEmailDao;

	public List<AgendamentoEmail> listarAgendamentosEmail() {
		return agendamentoEmailDao.listarAgendamentoEmail();
	}
	
	
	public void salvarAgendamentoEmail(@Valid AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setEnviado(false);
		agendamentoEmailDao.salvarAgendamentoEmail(agendamentoEmail);
	}

}
