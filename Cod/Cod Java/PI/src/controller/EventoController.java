package controller;

import java.util.ArrayList;

import model.beans.*;
import model.dao.*;

public class EventoController {

    public EventoController() {
        // TODO Auto-generated constructor stub
    }

    public static ArrayList<Evento> getListaEventos() {
        return EventoDAO.buscarEventos();
    }
    public static Evento excluirEvento(Evento e){
        return EventoDAO.removerEvento(e);
    }
    public static boolean addEvento(String nome, int idLocalEvento, String duracao, String dataInicio, String dataFim, String horaInicio, String horaFim, int IdadeMin, float preco){
        
    	Evento e = new Evento(nome, duracao, dataInicio, dataFim, horaInicio, horaFim, preco, IdadeMin);
        e.setId(idLocalEvento);
        return EventoDAO.cadastrarEvento(e);
    }
    public static boolean updEvento(int eId, String nome, int local, String duracao, String dataInicio, String dataFim, String horaInicio, String horaFim, int idadeMin, float preco) {
        Evento evento = new Evento(nome, duracao, dataInicio, dataFim, horaInicio, horaFim, preco, idadeMin);
        evento.setId(local);
        evento.setEId(eId);
        return EventoDAO.alterarEvento(evento);
    }
}
