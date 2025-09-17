package Util;

import Service.Stock;
import View.Attendant;

public class Main {
    public static void main(String[] args) {

        Attendant attendant = new Attendant();
        Stock stock = new Stock();
        int opcaoMenuEscolhida = 0;

        do {
            opcaoMenuEscolhida = attendant.MenuPrincipal();
            stock.gerenciarEstoque(attendant, opcaoMenuEscolhida);

        }while(opcaoMenuEscolhida != 0);
    }
}
