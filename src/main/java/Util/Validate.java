package Util;

import View.Attendant;

import java.util.Scanner;

public class Validate {

    public static Scanner leia = new Scanner(System.in);

    public static int ValidarInt(){

        int opcaoEscolhida = 0;
        boolean opcaoInvalida = true;

        while(opcaoInvalida) {

            System.out.println();
            System.out.print("[OPÇÃO]-> ");
            String texto = leia.nextLine();
            System.out.println();

            try {
                opcaoEscolhida = Integer.parseInt(texto);
                opcaoInvalida = false;
            } catch (NumberFormatException erro) {
                System.out.println("[Número Inválido]");
            }
        }
        return opcaoEscolhida;
    }



    public static int verificacaoMenu() {

        int opcaoMenuEscolhida = 0;
        boolean opcaoInvalida = true;

        do {
            System.out.println();
            System.out.print("[OPÇÃO] –→ ");
            String texto = leia.nextLine();
            System.out.println();

            try {
                opcaoMenuEscolhida = Integer.parseInt(texto);

                if (opcaoMenuEscolhida > 0 && opcaoMenuEscolhida < 6) {
                    opcaoInvalida = false;

                } else {
                    throw new IllegalArgumentException("[O NÚMERO DIGITADO NÃO ESTÁ NO MENU]");
                }

            } catch (IllegalArgumentException erro) {
                System.out.println("[ERRO:] " + erro.getMessage());
            }

        }while(opcaoInvalida == true);
        return opcaoMenuEscolhida;
    }
}

