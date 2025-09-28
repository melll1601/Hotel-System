package Util;

import Service.Stock;
import View.Attendant;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Attendant attendant = new Attendant();
        Stock stock = new Stock();
        int opcaoMenuEscolhida = 0;

        do {

            opcaoMenuEscolhida = Attendant.MenuPrincipal();
            stock.gerenciarEstoque(opcaoMenuEscolhida, attendant);

        } while(opcaoMenuEscolhida != 0);
        
    }
}
