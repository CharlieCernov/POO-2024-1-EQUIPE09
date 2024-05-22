package controller;

import model.beans.*;
import model.dao.*;

public class IngressoController {

    public IngressoController() {
        // TODO Auto-generated constructor stub
    }
    public static inserirIngressoComAssento(Evento e, int col, int fil){
        Ingresso ingresso = new Ingresso(true, e, AssentoController.getAssento(e.getId(), col, fil));
        return IngressoDAO.cadastrarIngressoComAssento(ingresso);
    }
}
