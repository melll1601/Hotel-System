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

    public static void listarHospedes() throws SQLException {
        String query = "SELECT * FROM hospede";

        try (Connection conn = Conexão.conectar();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {

            System.out.println("Lista de Hóspedes:");
            System.out.printf("%-5s %-20s %-15s %-15s%n", "ID", "Nome", "Documento", "Telefone");
            System.out.println("------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String documento = rs.getString("documento");
                String telefone = rs.getString("telefone");

                System.out.printf("%-5d %-20s %-15s %-15s%n", id, nome, documento, telefone);
            }

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public static List<Hospede> pesqHospedesPorNome(String nome) throws SQLException {
        String query = "SELECT * FROM hospede WHERE nome LIKE ?";
        List<Hospede> hospedes = new ArrayList<>();

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Hospede hospede = new Hospede();
                    hospede.setId(rs.getInt("id"));
                    hospede.setNome(rs.getString("nome"));
                    hospede.setDocumento(rs.getString("documento"));
                    hospede.setTelefone(rs.getString("telefone"));
                    hospedes.add(hospede);
                }
            }

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return hospedes;
    }

    public static void editarHospede(Hospede hospede) throws SQLException {
        String query = """
                UPDATE hospede
                SET nome = ?, documento = ?, telefone = ?
                WHERE id = ?
                """;

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getDocumento());
            stmt.setString(3, hospede.getTelefone());
            stmt.setInt(4, hospede.getId());
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Hóspede atualizado com sucesso!");
            } else {
                System.out.println("Nenhum hóspede encontrado com o ID fornecido.");
            }

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public static Hospede pesqHospedesPorId(int id) throws SQLException {
        String query = "SELECT * FROM hospede WHERE id = ?";
        Hospede hospede = null;

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    hospede = new Hospede();
                    hospede.setId(rs.getInt("id"));
                    hospede.setNome(rs.getString("nome"));
                    hospede.setDocumento(rs.getString("documento"));
                    hospede.setTelefone(rs.getString("telefone"));
                }
            }

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return hospede;
    }

}

