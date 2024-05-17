package controller;
import java.util.ArrayList;

import model.beans.*;
import model.dao.*;
public class LocalDeEventoController {

	public LocalDeEventoController() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<LocalDeEvento> getListaLocais(){
		ArrayList<LocalDeEvento> locais = new ArrayList<>();
		LocalDeEvento lc = new LocalDeEvento("Parque X", "Rua Conde Alberto", "09430-478", "f32", 5000, 0, 0);
		lc.setId(1);
		locais.add(lc);
		lc = new LocalDeEvento("Circo", "Rua Pedro Alvaro", "06730-478", "201", 3000, 0, 0);
		lc.setId(2);
		locais.add(lc);
		return locais;
	}
    public static LocalDeEvento excluiLocal(int id){
        return LocalDeEventoDAO.removerLocal(id);
    }
    public static boolean addLocal(String nome, String logradouro, String cep, String numero, int capacidade, int fileiras, int colunas){
    	LocalDeEvento lc = new LocalDeEvento(nome, logradouro, cep, numero, capacidade, fileiras, colunas);

        return LocalDeEventoDAO.cadastrarLocal(lc);
    }
    public static LocalDeEvento getLocal(int id) {
    	return LocalDeEventoDAO.buscaLocal(id);
    }
    
    public static boolean updLocal(int id, String nome, String logradouro, String cep, String num, int capacidade, int fil, int col) {
        LocalDeEvento local = new LocalDeEvento(nome, logradouro, cep, num, capacidade, fil, col);
        local.setId(id);
        return LocalDeEventoDAO.alterarLocal(local);
    }

}
