package model.dao;

import java.util.ArrayList;

import model.beans.Assento;
import java.sql.*;

public class AssentoDAO {

    private static Conexao conexao = new Conexao();

    public AssentoDAO() {
        // TODO Auto-generated constructor stub
    }

    public static boolean cadastrarAssento(Assento assento) {
        try {
            conexao.openDB();
            PreparedStatement pstmt = conexao.con.prepareStatement("insert into assento ( numero, coluna, fileira, especial, id_localdeevento) values "
                    + "(?, ?, ?, 0, ?)");
            pstmt.setInt(1, assento.getNumero());
            pstmt.setInt(2, assento.getColuna());
            pstmt.setInt(3, assento.getFileira());
            pstmt.setInt(4, assento.getLocalDeEvento().getId());

            pstmt.executeUpdate();
            conexao.closeDB();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao cadastrar assento\n" + e);
            return false;
        }
    }

    public static boolean alterarAssento(Assento assento) {
        return true;
    }

    public static Assento removerAssento(Assento assento) {
        return null;
    }

    public static ArrayList<Assento> buscarAssentos() {
        return null;
    }
    
}
