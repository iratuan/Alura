package br.com.caelum.models;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();

	static {
		Usuario u1 = new Usuario("iratuan", "12345");
		Usuario u2 = new Usuario("erika", "12345");

		Banco.adicionaUsuario(u1);
		Banco.adicionaUsuario(u2);

		Empresa e1 = new Empresa("Google", "01/01/2019");
		Empresa e2 = new Empresa("Facebook", "01/01/2019");
		Empresa e3 = new Empresa("Yahoo", "01/01/2020");
		Empresa e4 = new Empresa("Aygean", "01/01/2019");

		Banco.adicionaEmpresa(e1);
		Banco.adicionaEmpresa(e2);
		Banco.adicionaEmpresa(e3);
		Banco.adicionaEmpresa(e4);

	}

	public static void adicionaEmpresa(Empresa e) {
		Banco.empresas.add(e);

	}

	public static List<Empresa> listaEmpresas() {
		return Banco.empresas;
	}

	public static void removeEmpresa(Empresa e) {
		List<Empresa> empresasLocal = new ArrayList<Empresa>();
		for (Empresa empresa : Banco.listaEmpresas()) {
			if (empresa.getId() != e.getId()) {
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
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public static void adicionaUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public static List<Usuario> listaUsuarios() {
		return Banco.usuarios;
	}

	public static Usuario buscaUsuario(String nome) {
		Usuario usuario = Banco.usuarios.stream().filter(u -> u.getNome().equals(nome)).findAny().orElse(null);
		return usuario;
	}

}
