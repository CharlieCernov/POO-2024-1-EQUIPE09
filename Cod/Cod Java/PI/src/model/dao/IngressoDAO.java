package model.dao;

import java.util.ArrayList;

import model.beans.Ingresso;
import java.sql.*;
public class IngressoDAO {

    private static Conexao conexao = new Conexao();

    public IngressoDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public static boolean cadastrarIngressoSemAssento(Ingresso ingresso) {
        try {
            conexao.openDB();
            PreparedStatement pstmt = conexao.con.prepareStatement("insert into ingresso (comprado, id_evento) values (0, ?)");
            pstmt.setInt(1, ingresso.getEvento().getEId());

            pstmt.executeUpdate();
            conexao.closeDB();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao inserir ingresso\n" + e);
            return false;
        }
        
    }
    public static boolean cadastrarIngressoComAssento(Ingresso ingresso, int idAssento) {
        try {
            conexao.openDB();
            PreparedStatement pstmt = conexao.con.prepareStatement("insert into ingresso (comprado, id_evento, id_assento) values (0, ?, ?)");
            pstmt.setInt(1, ingresso.getEvento().getEId());
            pstmt.setInt(2, idAssento);
            pstmt.executeUpdate();
            conexao.closeDB();
        } catch (SQLException e) {
            System.out.println("Falha ao inserir ingresso\n" + e);
            return false;
        }
        return true;
    }
    public static boolean alterarIngresso(Ingresso ingresso) {
        try {
            conexao.openDB();
            PreparedStatement pstmt = conexao.con.prepareStatement("update ingresso set comprado = ? where id = ?");
            pstmt.setBoolean(1, ingresso.isComprado());
            pstmt.setInt(2, ingresso.getId());
            pstmt.executeUpdate();
            conexao.closeDB();
        } catch (SQLException e) {
            System.out.println("Falha ao alterar ingresso\n" + e);
            return false;
        }
        return true;
    }

    public static Ingresso removerIngresso(Ingresso ingresso) {
        return null;
    }

    public static ArrayList<Ingresso> buscarIngressos() {
        return null;
    }
}
