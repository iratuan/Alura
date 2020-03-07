package br.com.alura.timer;

import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import br.caelum.alura.entity.AgendamentoEmail;
import br.com.alura.business.AgendamentoEmailBusiness;

@Singleton
public class AgendamentoEmailTimer {


	@Inject
	private AgendamentoEmailBusiness agendamentoEmailBusiness;
	
	@Schedule(hour = "*", minute = "*")
	public void enviarEmailsAgendados() {
		List<AgendamentoEmail> agendamentoEmails = agendamentoEmailBusiness.listarAgendamentosNaoEnviados();
		agendamentoEmails.stream().forEach(agendamentoEmail -> {
			agendamentoEmailBusiness.atualizaStatusEmail(agendamentoEmail);
		});
		
	}
}
