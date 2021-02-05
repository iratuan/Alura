package br.com.iratuan.pocs;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TestGeradorPayload {

	@SuppressWarnings("deprecation")
	@Test
	void testaSeConsegueGerarPayloadComBaseNaClasseEnviada() {
		PayloadBuilder plb = new PayloadBuilder();
		String payload = plb.getPayload(Animal.class);
		System.out.println(payload);
		Assert.assertNotNull(payload);
	}
	
	
	@Test
	void testaSeConsegueGerarUmDadoTOComBaseNaClasseEnviada() {
		PayloadBuilder plb = new PayloadBuilder();
		Dados dadoTO = plb.getDadosTO(ControleSanitario.class);
		System.out.println(dadoTO);
		Assert.assertNotNull(dadoTO);
	}

}
