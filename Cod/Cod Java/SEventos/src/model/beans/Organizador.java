package model.beans;


public class Organizador extends Usuario {
	private int id;
	public Organizador() {
		super();
	}
	public Organizador(String nome, String email, String senha) {
		super(nome, email, senha, true);
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
