package model.dao;

import java.util.ArrayList;

import model.beans.Evento;

public class EventoDAO {

	public EventoDAO() {
		// TODO Auto-generated constructor stub
	}
    public static boolean cadastrarEvento(Evento evento) {
        // Após cadastrar o evento, os ingressos serão cadastrados
        if (evento.hasAssentos()) {
            //Cadastro de assentos
        }
        return true;
    }

    public static boolean alterarEvento(Evento evento) {
        return true;
    }

    public static Evento removerEvento(Evento evento) {
        return null;
    }

    public static ArrayList<Evento> buscarEventos() {
        return null;
    }

}
