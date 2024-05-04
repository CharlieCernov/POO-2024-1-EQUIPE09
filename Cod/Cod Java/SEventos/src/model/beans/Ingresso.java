package model.beans;


public class Ingresso {
	private int id;
	private boolean comprado;
	private Evento evento;
	private Assento assento;
	
	public Ingresso() {
		
	}
	public Ingresso(boolean comprado, Evento evento) {

		this.comprado = comprado;
		this.evento = evento;
	}
	public Ingresso(boolean comprado, Evento evento, Assento assento) {

		this.comprado = comprado;
		this.evento = evento;
		this.assento = assento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isComprado() {
		return comprado;
	}

	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public Assento getAssento() {
		return assento;
	}
	public void setAssento(Assento assento) {
		this.assento = assento;
	}
	

}
