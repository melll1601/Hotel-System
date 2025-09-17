package DAO;

import Model.Hospede;
import Util.Conexão;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HospedeDAO {

    public static void cadastroHospede(Hospede hospede) throws SQLException {

        String query = """
                INSERT INTO hospede (nome, documento, telefone)
                VALUES (?, ?, ?)
                """;

        try(Connection conn = Conexão.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getDocumento());
            stmt.setString(3, hospede.getTelefone());
            stmt.executeUpdate();

        }catch (SQLException erro){
            erro.printStackTrace();
        }
    }

    public static List<Hospede>  ListarHospedes() throws SQLException{
        String query = """
                SELECT id, nome, documento, telefone
                FROM hospede
                """;
        List<Hospede> listHospedes = new ArrayList<>();

        try(Connection conn = Conexão.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String documento = rs.getString("documento");
                String telefone = rs.getString("telefone");

                var hospede = new Hospede(id, nome, documento, telefone);
                listHospedes.add(hospede);
            }

        }catch (SQLException erro){
            erro.printStackTrace();
        }

        return listHospedes;
    }


}
