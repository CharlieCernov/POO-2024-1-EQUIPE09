package controller;

import model.beans.*;
import model.dao.*;

public class AssentoController {

    static Assento getAssento(int id, int col, int fil) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public AssentoController() {
        // TODO Auto-generated constructor stub
    }
    public static boolean inserirAssento(int fileira, int coluna, int idLocal){
        LocalDeEvento lc = new LocalDeEvento();
        lc.setId(idLocal);
        int numero = Integer.parseInt(Integer.toString(fileira)+Integer.toString(coluna));
        Assento assento = new Assento(lc,numero, false,fileira, coluna);
        return AssentoDAO.cadastrarAssento(assento);
    }

}
