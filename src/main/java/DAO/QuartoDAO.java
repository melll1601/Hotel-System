package DAO;

import Model.Hospede;
import Model.Quarto;
import Util.Conexão;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuartoDAO {

    public static void cadastroQuarto(Quarto quarto) throws SQLException {
        String query = """
                INSERT INTO quarto(numero, tipo, preco)
                VALUES (?, ?, ?)
                """;

        try(Connection conn = Conexão.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, quarto.getNumero());
            stmt.setString(2, quarto.getTipoPedido());
            stmt.setDouble(3, quarto.getPreco());
            stmt.executeUpdate();

        }catch (SQLException erro){
            erro.printStackTrace();
        }
    }

    public static void listarQuartos() throws SQLException {
        String query = """
                SELECT numero, tipo, preco
                FROM quarto
                """;

        try(Connection conn = Conexão.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            var rs = stmt.executeQuery();

            System.out.println("Lista de Quartos:");
            System.out.printf("%-10s %-15s %-10s%n", "Número", "Tipo", "Preço");
            System.out.println("---------------------------------------");

            while(rs.next()){
                int numero = rs.getInt("numero");
                String tipo = rs.getString("tipo");
                double preco = rs.getDouble("preco");

                System.out.printf("%-10d %-15s %-10.2f%n", numero, tipo, preco);
            }

        }catch (SQLException erro){
            erro.printStackTrace();
        }
    }
    
}
