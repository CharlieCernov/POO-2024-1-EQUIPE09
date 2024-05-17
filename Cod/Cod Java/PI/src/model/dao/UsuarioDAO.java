package model.dao;

import model.beans.*;
import java.sql.*;

public class UsuarioDAO {

    private static Conexao conexao = new Conexao();

    public UsuarioDAO() {
        // TODO Auto-generated constructor stub
    }

    public static Usuario login(String email, String senha) {
        try {
            conexao.openDB();
            PreparedStatement pstmt = conexao.con.prepareStatement("select usuario.id as 'Id', usuario.nome as 'Nome', usuario.email as 'Email'"+
                    ", cliente.id_usuario as 'Id Cli', organizador.id_usuario as 'Id Org' from usuario "
                    + "left join cliente on cliente.id_usuario = usuario.id "
                    + "left join organizador on organizador.id_usuario = usuario.id "
                    + "where usuario.email = ? and usuario.senha = ?");
            pstmt.setString(1, email);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();

            Usuario user = null;
            rs.next();
            if(rs.getInt("Id Cli") > 0)
                user = new Cliente();
            if(rs.getInt("Id Org") > 0)
                user = new Organizador();
            
            user.setEmail(rs.getString("Email"));
            user.setNome(rs.getString("Nome"));
            user.setId(rs.getInt("Id"));
            conexao.closeDB();

            return user;
        } catch (SQLException e) {
            System.out.println("Não foi possível logar \n" + e);
            return null;
        }
    }

    public static boolean cadastro(Usuario user) {
        return true;
    }
}
