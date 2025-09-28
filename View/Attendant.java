package View;

import java.util.List;
import java.util.Scanner;

import Dao.HospedeDAO;
import Dao.QuartoDAO;
import Model.Hospede;
import Model.Quarto;
import Util.Validate;

public class Attendant {

    public static Scanner leia = new Scanner(System.in);

    // Menus de Cadastro

    public static String loginUsuario(){

        System.out.println("|------------------------------------------|");
        System.out.println("|     ---   Gabelm Hotel Login    ---      |");
        System.out.println("|------------------------------------------|");
        System.out.print("| -> Digite a senha de ADMIN:");

        String senhaLogin = leia.nextLine();
        return senhaLogin;
    }



public static int MenuPrincipal(){

    System.out.println(" ");

    System.out.println("|------------------------------------------|");
    System.out.println("|     ---       Gabelm Hotel      ---      |");
    System.out.println("|------------------------------------------|");
    System.out.println("| 1 - Cadastros      | 2 - Listagem        |");
    System.out.println("|------------------------------------------|");
    System.out.println("| 3 - Pesquisar      | 4 - Editar          |");
    System.out.println("|------------------------------------------|");
    System.out.println("| 5 - Cancelar       | 6 - Reservas        |");
    System.out.println("|------------------------------------------|");
    System.out.println("| 0 - Sair                                 |");
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


    public static int editarDados(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|    ---  Gabelm Hotel Edição      ---     |");
        System.out.println("|------------------------------------------|");
        System.out.print  ("|-- Digite o ID do hóspede: ");

        int opcao = Validate.ValidarInt();
        return opcao;

    }


    public static String cancelarReserva(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|    ---  Gabelm Hotel Cancelamento  ---   |");
        System.out.println("|------------------------------------------|");
        System.out.print  ("|-- Digite o código da reserva: ");

        return leia.nextLine();
    }

    public static void sairSistema(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|    ---  Gabelm Hotel - Até Logo!   ---   |");
        System.out.println("|------------------------------------------|");
    }

    // Métodos lógicos do Sistema

    public static void tituloCadastrar() {
        System.out.println(" ");
        System.out.println("|------------------------------------------|");
        System.out.println("|     ---   Gabelm Hotel Cadastro    ---   |");
        System.out.println("|------------------------------------------|");
    }

    public static void tituloEditar(){
        System.out.println(" ");
        System.out.println("|------------------------------------------|");
        System.out.println("|     ---   Gabelm Hotel Edição     ---    |");
        System.out.println("|------------------------------------------|");
    }


    public static void tituloListar() {
        System.out.println(" ");
        System.out.println("|------------------------------------------------------|");
        System.out.println("|           ---   Gabelm Hotel Listagem      ---       |");
        System.out.println("|------------------------------------------------------|");
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

    public static String pesquisarNome(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|    ---  Gabelm Hotel Pesquisa    ---     |");
        System.out.println("|------------------------------------------|");
        System.out.print  ("|    - Digite o nome: ");

        String nomeHospede = leia.nextLine();
        return nomeHospede;

    }

    public static void naoEncontrado(){

        System.out.println(" ");
        System.out.println("[NÃO FOI POSSÍVEL ENCONTRAR]");
    }

    public static String pesquisarTipo(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|    ---  Gabelm Hotel Pesquisa    ---     |");
        System.out.println("|------------------------------------------|");
        System.out.print  ("|    - Digite o tipo: ");

        String tipoQuarto = leia.nextLine();
        return tipoQuarto;

    }

    public static String pesquisarNomeReserva(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|    ---  Gabelm Hotel Pesquisa    ---     |");
        System.out.println("|------------------------------------------|");
        System.out.print  ("|    - Digite o nome: ");

        String nomeReserva = leia.nextLine();
        return nomeReserva;
    }

    public static void reservaExcluida(){
        System.out.println(" ");
        System.out.println("[RESERVA EXCLUÍDA]");
    }

    public static void retornarMenu(){
        System.out.println(" ");
        System.out.println("[RETORNANDO AO MENU PRINCIPAL...]");
    }

    public static void opcaoInvalida(){
        System.out.println(" ");
        System.out.println("[OPÇÃO INVÁLIDA! TENTE NOVAMENTE.]");
    }

    public static int menuServico(){

        System.out.println(" ");

        System.out.println("|----------------------------------------------|");
        System.out.println("|      ---  Gabelm Hotel Serviços    ---       |");
        System.out.println("|----------------------------------------------|");
        System.out.println("| 1 - Adicionar Serviço | 2 - Listar Serviços  |");
        System.out.println("|----------------------------------------------|");
        System.out.println("| 0 - Voltar            |                      |");
        System.out.println("|----------------------------------------------|");
        

        int opcao = Validate.ValidarInt();
        return opcao;

    }

    public static int pedirIdReserva(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|    ---  Gabelm Hotel Serviços    ---     |");
        System.out.println("|------------------------------------------|");
        System.out.print  ("|-- Digite o ID da reserva: ");

        int idReserva = Validate.ValidarInt();
        return idReserva;
    }

    public static int menuTipoServico(){

        System.out.println(" ");

        System.out.println("|----------------------------------------------|");
        System.out.println("|      ---  Gabelm Hotel Serviços    ---       |");
        System.out.println("|----------------------------------------------|");
        System.out.println("| 1 - Café da Manhã     | 2 - Almoço           |");
        System.out.println("|----------------------------------------------|");
        System.out.println("| 3 - Jantar            | 4 - Room Service     |");
        System.out.println("|----------------------------------------------|");
        System.out.println("| 5 - Lavanderia        | 0 - Voltar           |");
        System.out.println("|----------------------------------------------|");


        int opcao = Validate.ValidarInt();
        return opcao;

    }

}   
