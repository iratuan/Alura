package br.com.caelum.models;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<Empresa>();
	
	public static void adicionaEmpresa(Empresa e) {
		Banco.empresas.add(e);
		
	}
	
	public static List<Empresa> listaEmpresas() {
		return Banco.empresas;
	}	
	
	public static void removeEmpresa(Empresa e) {		
		List<Empresa> empresasLocal = new ArrayList<Empresa>();
		for (Empresa empresa : Banco.listaEmpresas()) {
			if(empresa.getId() != e.getId()) {
				empresasLocal.add(empresa);
			}
		}
		Banco.removeEmpresas();		
		Banco.empresas = empresasLocal;
	}
	
	public static void removeEmpresas() {
		Banco.empresas = new ArrayList<Empresa>();
	}
	
	public static Empresa encontraEmpresa(int id) {
		for (Empresa empresa : Banco.listaEmpresas()) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}		
		return null;
	}

}
