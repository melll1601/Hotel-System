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


    public static double ValidarDouble() {

        double numero = 0;
        boolean opcaoInvalida = true;

        while (opcaoInvalida) {
            System.out.print("[VALOR]-> ");
            String texto = leia.nextLine();

            try {
                numero = Double.parseDouble(texto);
                opcaoInvalida = false;
            } catch (NumberFormatException erro) {
                System.out.println("[Número decimal inválido, use ponto para casas decimais.]");
            }
        }
        return numero;
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

    public static String verificarSenha(Scanner leia){

        boolean opcaoInvalida = true;
        String senhaAdmin = "Adm123Bruno";
        int tentativas = 3;
        String senhaDigitada = null;
        do{
            System.out.println();
            System.out.print("[INSIRA A SENHA]-> ");
            senhaDigitada = leia.nextLine();

            try{
                if (senhaDigitada.equals(senhaAdmin)) {

                    opcaoInvalida = false;
                    System.out.println();
                    System.out.println("[BEM VINDO DE VOLTA!]");  
                }else{
                    tentativas = tentativas - 1;
                    throw new IllegalArgumentException("[SENHA INCORRETA - TENTATIVAS RESTANTES " + tentativas + " ]");
                }
            }catch(IllegalArgumentException erro){
                System.out.println(erro.getMessage());
            }

        }while(tentativas > 0 && opcaoInvalida == true);

        return opcaoInvalida ? null : senhaDigitada;

    }
}

