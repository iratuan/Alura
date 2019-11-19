package br.com.caelum.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.caelum.models.Banco;
import br.com.caelum.models.Empresa;

class EmpresaTest {

	private Empresa e = new Empresa("Minas", "01/01/2019");

	@Test
	void adicionaEmpresaTes() {
		Banco.removeEmpresas();
		Banco.adicionaEmpresa(e);
		assertEquals(1, Banco.listaEmpresas().size());
	}

	@Test
	void removeEmpresa() {
		Banco.removeEmpresas();
		Banco.adicionaEmpresa(e);
		Banco.removeEmpresa(e);
		assertEquals(0, Banco.listaEmpresas().size());
	}

	@Test
	void encontraEmpresa() {
		Banco.encontraEmpresa(1);
		assertEquals("Minas", e.getNome());
	}
}
