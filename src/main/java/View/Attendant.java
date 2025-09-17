package View;

import Util.Validate;
import src.main.java.Util.*;

public class Attendant {

    public static int MenuPrincipal(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|     ---       Gabelm Hotel      ---      |");
        System.out.println("|------------------------------------------|");
        System.out.println("| 1 - Cadastros      | 2 - Listagem        |");
        System.out.println("|------------------------------------------|");
        System.out.println("| 3 - Pesquisar      | 4 - Editar          |");
        System.out.println("|------------------------------------------|");
        System.out.println("| 5 - Cancelar       | 6 - Sair            |");
        System.out.println("|------------------------------------------|");


        int opcaoMenuPrincipal = Validate.verificacaoMenu();
        return opcaoMenuPrincipal;
    }

    public static int MenuCadastro(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|    ---  Gabelm Hotel Cadastro    ---     |");
        System.out.println("|------------------------------------------|");
        System.out.println("| 1 - Cad. Hóspede   | 2 - Cad. Quarto     |");
        System.out.println("|------------------------------------------|");
        System.out.println("| 3 - Cad. Reserva   | 0 - Voltar          |");
        System.out.println("|------------------------------------------|");

        int opcao = Validate.ValidarInt();
        return opcao;
    }

    public static int MenuListar(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|    ---  Gabelm Hotel Listagem    ---     |");
        System.out.println("|------------------------------------------|");
        System.out.println("| 1 - List. Hóspede  | 2 - List. Quarto    |");
        System.out.println("|------------------------------------------|");
        System.out.println("| 3 - List. Reserva  | 0 - Voltar          |");
        System.out.println("|------------------------------------------|");

        int opcao = Validate.ValidarInt();
        return opcao;
    }

    public static int menuPesquisar(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|    ---  Gabelm Hotel Pesquisa    ---     |");
        System.out.println("|------------------------------------------|");
        System.out.println("| 1 - Pesq. Hóspede  | 2 - Pesq. Quarto    |");
        System.out.println("|------------------------------------------|");
        System.out.println("| 3 - Pesq. Reserva  | 0 - Voltar          |");
        System.out.println("|------------------------------------------|");

        int opcao = Validate.ValidarInt();
        return opcao;

    }


    public static int editarDados(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|    ---  Gabelm Hotel Edição      ---     |");
        System.out.println("|------------------------------------------|");
        System.out.print  ("|-- Digite o ID do hóspede: ");

        int opcao = Validate.ValidarInt();
        return opcao;

    }


    public static int cancelarReserva(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|    ---  Gabelm Hotel Cancelamento  ---   |");
        System.out.println("|------------------------------------------|");
        System.out.print  ("|-- Digite o ID da reserva: ");

        int opcao = Validate.ValidarInt();
        return opcao;
    }

    public static void sairSistema(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|    ---  Gabelm Hotel - Até Logo!   ---   |");
        System.out.println("|------------------------------------------|");
    }
}
