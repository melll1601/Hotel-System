package DAO;

import Model.Reserva;
import Util.Conexão;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
}