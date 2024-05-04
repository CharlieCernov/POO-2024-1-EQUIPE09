package model.beans;


public class Assento {
	private int id;
	private Ingresso ingresso;
	private Evento evento;
	// Para mudança futura (tirar ligação de assento com evento e ingresso)
	// private LocalDeEvento localDeEvento;
	// private int coluna, fileira;
	private int numero;
	private boolean especial;
	public Assento() {
		
	}
	public Assento(Evento evento, int numero, boolean especial) {
		super();
		this.evento = evento;
		this.numero = numero;
		this.especial = especial;
	}
	public Assento(Ingresso ingresso, Evento evento, int numero, boolean especial) {
		this.ingresso = ingresso;
		this.evento = evento;
		this.numero = numero;
		this.especial = especial;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Ingresso getIngresso() {
		return ingresso;
	}
	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean isEspecial() {
		return especial;
	}
	public void setEspecial(boolean especial) {
		this.especial = especial;
	}
	
}
