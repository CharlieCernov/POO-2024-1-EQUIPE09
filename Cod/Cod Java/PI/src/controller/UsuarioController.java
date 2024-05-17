package controller;

import model.beans.*;
import model.dao.*;
public class UsuarioController {
	private static Usuario userLogado;
	public static Usuario fazerLogin(String email, String senha) {
		Usuario user = new Cliente();
		user.setEmail(email);
		user.setSenha(senha);
		userLogado = UsuarioDAO.login(user.getEmail(), user.getSenha());
		return userLogado;
	}
	public static boolean fazerCadastro(String nome, String email, String senha, boolean organizador, String dataNascimento) {
		if(organizador) {
			Organizador o = new Organizador(nome, email, senha);
			return OrganizadorDAO.cadastrarOrganizador(o);
		}
		else {
			Cliente c = new Cliente(nome, email, senha);
                        c.setDataNascimento(dataNascimento);
			return ClienteDAO.cadastrarCliente(c);
		}
	}
	public static Usuario getUserLogado() {
		return userLogado;
	}
}
