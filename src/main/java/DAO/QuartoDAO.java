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
}
