package model.beans;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
public class Cliente extends Usuario {
	private int id;
	private LocalDate dataNascimento;
	private ArrayList<Ingresso> ingressosComprados;
	public Cliente() {
		super();
	}
	public Cliente(String nome, String email, String senha,
			ArrayList<Ingresso> ingressosComprados) {
		super(nome, email, senha, false);
		this.ingressosComprados = ingressosComprados;
	}
	public Cliente(String nome, String email, String senha) {
		super(nome, email, senha, false);
		ingressosComprados = new ArrayList<Ingresso>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(int dia, int mes, int ano) {
		this.dataNascimento = LocalDate.of(ano, mes, dia);
	}
	public int getIdade() {
		int idade = -1;
		if(this.dataNascimento != null) {
			idade = Period.between(dataNascimento, LocalDate.now()).getYears();
		}
		return idade;
	}
	public void addIngresso(Ingresso ing) {
		ingressosComprados.add(ing);
	}
	
}
