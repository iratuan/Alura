import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.hibernate.Session;
import org.junit.Test;

import br.com.caelum.pm73.dao.CriadorDeSessao;
import br.com.caelum.pm73.dao.UsuarioDao;
import br.com.caelum.pm73.dominio.Usuario;

public class UsuarioDaoTest {

	@Test
	public void deveEncontrarPeloNomeEEmail() {
		Session session = new CriadorDeSessao().getSession();

		UsuarioDao usuarioDao = new UsuarioDao(session);

		Usuario novoUsuario = new Usuario("Jo�o da Silva", "joao@dasilva.com.br");

		usuarioDao.salvar(novoUsuario);

		Usuario usuarioDoBanco = usuarioDao.porNomeEEmail("Jo�o da Silva", "joao@dasilva.com.br");

		assertEquals("Jo�o da Silva", usuarioDoBanco.getNome());

		assertEquals("joao@dasilva.com.br", usuarioDoBanco.getEmail());
		
		Usuario usuarioNulo = usuarioDao.porNomeEEmail("Iratu�", "iratuan@gmail.com");
		
		assertNull("iratuan@gmail.com", usuarioNulo);

		session.close();
	}
}
