package br.com.iratuan.pocs;

import java.util.HashMap;

public class PayloadBuilder {

	private HashMap<Object, String> payloads = new HashMap<Object, String>();

	public PayloadBuilder() {
		this.setPayload(Animal.class, "{\"chave\":\"Animal\",\"valor\":\"payload bonitinho\"}");
		this.setPayload(ControleSanitario.class,
				"{\"chave\":\"Controle Sanitario\",\"valor\":\"payload bonitinho Controle Sanitario\"}");
	}

	public void setPayload(Object key, String value) {
		if (searchByClassKey(key)) {
			return;
		}
		payloads.put(key, value);
	}

	public String getPayload(Object key) {
		return payloads.get(key);
	}

	private boolean searchByClassKey(Object key) {
		// TODO implementar busca
		return false;
	}

	public Dados getDadosTO(Class<ControleSanitario> key) {
		Dados dadoTO = new Dados();
		dadoTO.setAceiteLGPD(true);
		dadoTO.setIdDispositivo("ABC");
		dadoTO.setVersao("123");
		dadoTO.setUsuario( new Usuario());
		dadoTO.setConteudo(getPayload(key));
		return dadoTO;
	}

}
