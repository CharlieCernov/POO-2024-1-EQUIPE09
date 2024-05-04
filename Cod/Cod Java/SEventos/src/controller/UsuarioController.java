package controller;

import model.beans.*;
import model.dao.*;
public class UsuarioController {
	
	public static boolean fazerLogin(String email, String senha) {
		Usuario user = new Cliente();
		user.setEmail(email);
		user.setSenha(senha);
		
		return UsuarioDAO.login(user.getEmail(), user.getSenha());
	}
	public static boolean fazerCadastro(String nome, String email, String senha, boolean organizador) {
		if(organizador) {
			Organizador o = new Organizador(nome, email, senha);
			return OrganizadorDAO.cadastrarOrganizador(o);
		}
		else {
			Cliente c = new Cliente(nome, email, senha);
			return ClienteDAO.cadastrarCliente(c);
		}
	}
}
