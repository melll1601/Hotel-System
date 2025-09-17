package src.main.java.Util;

import src.main.java.Service.Stock;
import src.main.java.View.Attendant;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();
        int opcaoMenuEscolhida = 0;

        do {
            opcaoMenuEscolhida = Attendant.MenuPrincipal(); // não precisa criar 'attendant'
            stock.gerenciarEstoque(opcaoMenuEscolhida); // chame sem passar 'attendant'
        } while(opcaoMenuEscolhida != 0);
    }
}
