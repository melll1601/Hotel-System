package Util;

import java.util.Scanner;

import Service.Stock;
import View.Attendant;

public class Main {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);

        Attendant attendant = new Attendant();
        Stock stock = new Stock();
        int opcaoMenuEscolhida = 0;

         if (Validate.verificarSenha(leia) == null) { 
            System.out.println("PROGRAMA BLOQUEADO - TENTATIVAS EXCEDIDAS !!");

            return;  
        }

        do {

            opcaoMenuEscolhida = attendant.MenuPrincipal();
            stock.gerenciarEstoque(attendant, opcaoMenuEscolhida);

        } while (opcaoMenuEscolhida != 0);
    }
}
