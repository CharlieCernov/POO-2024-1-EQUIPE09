package model.dao;

import java.util.ArrayList;
import java.sql.*;
import model.beans.Evento;

public class EventoDAO {

    private static Conexao conexao = new Conexao();

    public EventoDAO() {
        // TODO Auto-generated constructor stub
    }

    public static boolean cadastrarEvento(Evento ev) {
        try {
            conexao.openDB();
            PreparedStatement pstmt = conexao.con.prepareStatement("insert into evento (nome, idadeMin, duracao,"
                    + " dataInicio, dataFim, horaInicio, horaFim, valorIngresso, id_localdeevento) values"
                    + "(?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, ev.getNomeEvento());
            pstmt.setInt(2, ev.getIdadeMin());
            pstmt.setString(3, ev.getDuracao());
            pstmt.setString(4, ev.getDataInicio());
            pstmt.setString(5, ev.getDataFim());
            pstmt.setString(6, ev.getHoraInicio());
            pstmt.setString(7, ev.getHoraFim());
            pstmt.setFloat(8, ev.getValorIngresso());
            pstmt.setFloat(9, ev.getId());

            pstmt.executeUpdate();
            conexao.closeDB();
        } catch (SQLException e) {
            System.out.println("Falha ao inserir evento\n" + e);
            return false;
        }
        return true;
    }

    public static boolean alterarEvento(Evento evento) {
        return true;
    }

    public static Evento removerEvento(Evento e) {
        try{
            conexao.openDB();
            PreparedStatement pstmt = conexao.con.prepareStatement("delete from evento where id = ?");
            pstmt.setInt(1, e.getEId());
            pstmt.execute();
            conexao.closeDB();
            return e;
        }
        catch(SQLException ex){
            System.out.println("Falha ao deletar evento\n" + ex);         
        }
        return null;
    }

    public static ArrayList<Evento> buscarEventos() {
        ArrayList<Evento> eventos = new ArrayList<>();
        Evento evento;
        try {
            conexao.openDB();
            PreparedStatement pstmt = conexao.con.prepareStatement("select * from evento");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                evento = new Evento();
                evento.setEId(rs.getInt("id"));
                evento.setId(rs.getInt("id_localdeevento"));
                evento.setNomeEvento(rs.getString("nome"));
                evento.setIdadeMin(rs.getInt("idadeMin"));
                evento.setDataInicio(rs.getString("dataInicio"));
                evento.setDataFim(rs.getString("dataFim"));
                evento.setDuracao(rs.getString("duracao"));
                evento.setHoraFim(rs.getString("horaFim"));
                evento.setHoraInicio(rs.getString("horaInicio"));
                evento.setValorIngresso(rs.getFloat("valorIngresso"));
                eventos.add(evento);
            }
            conexao.closeDB();
        } catch (SQLException ex) {
            System.out.println("Falha ao buscar eventos\n" + ex);
        }
        return eventos;
    }

    public static Evento getEvento(int id) {
        Evento evento = new Evento();
        try {
            conexao.openDB();
            PreparedStatement pstmt = conexao.con.prepareStatement("select * from evento");
            ResultSet rs = pstmt.executeQuery();
            evento = new Evento();
            evento.setEId(rs.getInt("id"));
            evento.setId(rs.getInt("id_localdeevento"));
            evento.setNomeEvento(rs.getString("nome"));
            evento.setIdadeMin(rs.getInt("idadeMin"));
            evento.setDataInicio(rs.getString("dataInicio"));
            evento.setDataFim(rs.getString("dataFim"));
            evento.setDuracao(rs.getString("duracao"));
            evento.setHoraFim(rs.getString("horaFim"));
            evento.setHoraInicio(rs.getString("horaInicio"));
            evento.setValorIngresso(rs.getFloat("valorIngresso"));
            conexao.closeDB();

        } catch (SQLException ex) {
            System.out.println("Falha ao buscar eventos\n" + ex);
        }
        return evento;
    }

}
