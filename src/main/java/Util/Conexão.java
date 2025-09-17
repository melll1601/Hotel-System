package Util;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexão {

    private static final String URL = "jdbc:mysql://localhost:3356/meu-banco?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String SENHA = "mysqlPW";

    public static Conexão conectar() throws SQLException {
        return (Conexão) DriverManager.getConnection(URL,USER,SENHA);
    }
}

