package br.com.alura.business;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import br.caelum.alura.entity.AgendamentoEmail;
import br.com.alura.dao.AgendamentoEmailDao;
import br.com.alura.exception.BusinessException;

@Stateless
public class AgendamentoEmailBusiness {
	
	@Resource	
	private Session sessaoEmail;

    private static String EMAIL_FROM = "smtp.mailtrap.io";
    private static String EMAIL_USER = "2f6960d532dfd8";
    private static String EMAIL_PASSWORD = "6c8b630fa10a79";



	@Inject
	AgendamentoEmailDao agendamentoEmailDao;

	public List<AgendamentoEmail> listarAgendamentosEmail() {
		return agendamentoEmailDao.listarAgendamentoEmail();
	}

	public void salvarAgendamentoEmail(@Valid AgendamentoEmail agendamentoEmail) throws BusinessException {

		boolean naoPossueAgendamento = agendamentoEmailDao
				.listarAgendamentosEmailsPorEmail(agendamentoEmail.getEmail())
				.isEmpty();

		if (!naoPossueAgendamento) {
			throw new BusinessException("Email já agendado.");
		}
		agendamentoEmail.setEnviado(false);
		agendamentoEmailDao.salvarAgendamentoEmail(agendamentoEmail);
	}
	
	public List<AgendamentoEmail> listarAgendamentosNaoEnviados() {
		return agendamentoEmailDao.listarAgendamentosNaoEnviados();
	}
	
	public void enviarEmail(AgendamentoEmail agendamentoEmail) {
		try {

            MimeMessage mensagem = new MimeMessage(sessaoEmail);
            mensagem.setFrom(sessaoEmail.getProperty(EMAIL_FROM));
            mensagem.setRecipients(Message.RecipientType.TO, agendamentoEmail.getEmail());
            mensagem.setSubject(agendamentoEmail.getAssunto());

            mensagem.setText(agendamentoEmail.getMensagem());

            Transport.send(mensagem,
                    sessaoEmail.getProperty(EMAIL_USER),
                    sessaoEmail.getProperty(EMAIL_PASSWORD));

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
		
	}

	public void atualizaStatusEmail(AgendamentoEmail agendamentoEmail) {
		agendamentoEmailDao.atualizaStatusEmail(agendamentoEmail);
		
	}

}
