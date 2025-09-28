package DAO;

import Model.Reserva;
import Util.Conexão;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReservaDAO {

    public static void cadastrarReserva(Reserva reserva) throws SQLException, SQLException {
        String query = """
                INSERT INTO reserva
                (quarto_id, hospede_id, data_entrada, data_saida)
                VALUES   (?, ?, ?, ?)
                """;

        try(Connection conn = Conexão.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

                stmt.setInt(1, reserva.getQuarto_id());
                stmt.setInt(2, reserva.getHospede_id());
                stmt.setDate(3, java.sql.Date.valueOf(reserva.getData_entrada()));
                stmt.setDate(4, java.sql.Date.valueOf(reserva.getData_saida()));

                stmt.executeUpdate();

        }catch (SQLException erro){
            erro.printStackTrace();
        }
    }

    public static void listarReservas() throws SQLException {
        String query = """
                SELECT r.id, r.quarto_id, r.hospede_id, r.data_entrada, r.data_saida,
                       h.nome AS nome_hospede, q.numero AS numero_quarto
                FROM reserva r
                JOIN hospede h ON r.hospede_id = h.id
                JOIN quarto q ON r.quarto_id = q.id
                """;

        try(Connection conn = Conexão.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            var rs = stmt.executeQuery();

            System.out.println("Lista de Reservas:");
            System.out.printf("%-5s %-10s %-20s %-15s %-15s%n", "ID", "Quarto", "Hóspede", "Data Entrada", "Data Saída");
            System.out.println("---------------------------------------------------------------");

            while(rs.next()){
                int id = rs.getInt("id");
                int numeroQuarto = rs.getInt("numero_quarto");
                String nomeHospede = rs.getString("nome_hospede");
                java.sql.Date dataEntrada = rs.getDate("data_entrada");
                java.sql.Date dataSaida = rs.getDate("data_saida");

                System.out.printf("%-5d %-10d %-20s %-15s %-15s%n", id, numeroQuarto, nomeHospede, dataEntrada, dataSaida);
            }

        }catch (SQLException erro){
            erro.printStackTrace();
        }
    }

    public static List<Reserva> pesqReservasPorNomeHospede(String nome) throws SQLException {
        String query = """
                SELECT r.id, r.quarto_id, r.hospede_id, r.data_entrada, r.data_saida,
                       h.nome AS nome_hospede, q.numero AS numero_quarto
                FROM reserva r
                JOIN hospede h ON r.hospede_id = h.id
                JOIN quarto q ON r.quarto_id = q.id
                WHERE h.nome LIKE ?
                """;

        try(Connection conn = Conexão.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, "%" + nome + "%");
            var rs = stmt.executeQuery();

            List<Reserva> reservas = new java.util.ArrayList<>();

            while(rs.next()){
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setQuarto_id(rs.getInt("quarto_id"));
                reserva.setHospede_id(rs.getInt("hospede_id"));
                reserva.setData_entrada(rs.getDate("data_entrada").toLocalDate());
                reserva.setData_saida(rs.getDate("data_saida").toLocalDate());
                reservas.add(reserva);
            }
            return reservas;

        }catch (SQLException erro){
            erro.printStackTrace();
            return java.util.Collections.emptyList();
        }
    }
    
}