package model.beans;
public class LocalDeEvento {
	private int id;
	private String logradouro, CEP, numero;
	private int capacidade;
	// Para mudança futura
	// private int colunas, linhas;
	// private ArrayList<Assento> assento;
	private boolean assentos;
	
	public LocalDeEvento() {
		
	}
	public LocalDeEvento(String logradouro, String CEP, String numero, int capacidade, boolean assentos) {
		this.logradouro = logradouro;
		this.CEP = CEP;
		this.numero = numero;
		this.capacidade = capacidade;
		this.assentos = assentos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String CEP) {
		this.CEP = CEP;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public boolean hasAssentos() {
		return assentos;
	}
	public void setAssentos(boolean assentos) {
		this.assentos = assentos;
	}


}
