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
        System.out.print  ("|-- Digite o nome do Hospede: ");

        String nomeHospede = leia.nextLine();
        return nomeHospede;
    }

    public static void sairSistema(){

        System.out.println(" ");

        System.out.println("|------------------------------------------|");
        System.out.println("|    ---  Gabelm Hotel - Até Logo!   ---   |");
        System.out.println("|------------------------------------------|");
    }

    // Métodos lógicos do Sistema

    public static void cadastrarHospede() {
        System.out.println(" ");
        System.out.println("|------------------------------------------|");
        System.out.println("|     ---   Gabelm Hotel Cadastro    ---   |");
        System.out.println("|------------------------------------------|");
        System.out.print("| -> Nome do Hóspede: ");
        String nome = leia.nextLine();
        System.out.print("| -> Documento (CPF ou RG): ");
        String documento = leia.nextLine();
        System.out.print("| -> Telefone: ");
        String telefone = leia.nextLine();

        Dao.HospedeDAO.cadastrarHospede(nome, documento, telefone);
    }

    public static void cadastrarQuarto() {
        System.out.println(" ");
        System.out.println("|------------------------------------------|");
        System.out.println("|     ---   Gabelm Hotel Cadastro    ---   |");
        System.out.println("|------------------------------------------|");
        System.out.print("| -> Tipo do Quarto (Simples, Luxo, Suite, Presidencial): ");
        String tipo = leia.nextLine();
        System.out.print("| -> Preço da Diária: ");
        double preco = Validate.ValidarDouble();

        Dao.QuartoDAO.cadastrarQuarto(tipo, preco);
    }

    public static void cadastrarReserva() {
        System.out.println(" ");
        System.out.println("|------------------------------------------|");
        System.out.println("|     ---   Gabelm Hotel Cadastro    ---   |");
        System.out.println("|------------------------------------------|");
        System.out.print("| -> ID do Hóspede: ");
        int idHospede = Validate.ValidarInt();
        System.out.print("| -> ID do Quarto: ");
        int idQuarto = Validate.ValidarInt();
        System.out.print("| -> Data de Entrada: ");
        String Entrada = leia.nextLine();
        System.out.print("| -> Data de Saída: ");
        String Saida = leia.nextLine();

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        java.util.Date dataEntrada = null;
        java.util.Date dataSaida = null;

        try {
            dataEntrada = sdf.parse(Entrada);
            dataSaida = sdf.parse(Saida);
        } catch (java.text.ParseException e) {
            System.out.println("Erro: Formato de data inválido.");
            return;
        }

        Hospede hospede = HospedeDAO.buscarPorId(idHospede);
        Quarto quarto = QuartoDAO.buscarPorNumero(idQuarto);

        if (hospede == null || quarto == null) {
            System.out.println("Erro: Hóspede ou quarto não encontrado.");
            return;
        }

        Dao.ReservaDAO.cadastrarReserva(hospede, quarto, dataEntrada, dataSaida);
    }

    public static void listarHospedes() {
        System.out.println(" ");
        System.out.println("|------------------------------------------|");
        System.out.println("|     ---   Gabelm Hotel Listagem    ---   |");
        System.out.println("|------------------------------------------|");

        List <Hospede> hospedes = HospedeDAO.listarHospedes();
        if (hospedes.isEmpty()) {
            System.out.println("|        Nenhum hóspede cadastrado!        |");
        } else {
            for (Hospede hospede : hospedes) {
                System.out.println("| ID: " + hospede.getId() + 
                                   " | Nome: " + hospede.getNome() + 
                                   " | Documento: " + hospede.getDocumento() + 
                                   " | Telefone: " + hospede.getTelefone() + 
                                   " |");
            }
        }

        System.out.println("|------------------------------------------|");

    }

    public static void listarQuartos() {
        System.out.println(" ");
        System.out.println("|------------------------------------------|");
        System.out.println("|     ---   Gabelm Hotel Listagem    ---   |");
        System.out.println("|------------------------------------------|");

        List <Quarto> quartos = QuartoDAO.listarQuartos();
        if (quartos.isEmpty()) {
            System.out.println("|        Nenhum quarto cadastrado!         |");
        } else {
            for (Quarto quarto : quartos) {
                System.out.println("| Número: " + quarto.getNumero() + 
                                   " | Tipo: " + quarto.getTipo() + 
                                   " | Preço: " + quarto.getPreco() + 
                                   " |");
            }
        }

        System.out.println("|------------------------------------------|");

    }

    public static void listarReservas() {
        System.out.println(" ");
        System.out.println("|------------------------------------------|");
        System.out.println("|     ---   Gabelm Hotel Listagem    ---   |");
        System.out.println("|------------------------------------------|");

        List <Model.Reserva> reservas = Dao.ReservaDAO.listarReservas();
        if (reservas.isEmpty()) {
            System.out.println("|        Nenhuma reserva cadastrada!       |");
        } else {
            for (Model.Reserva reserva : reservas) {
                System.out.println("| ID: " + reserva.getId() + 
                                   " | Hóspede: " + reserva.getHospede().getNome() + 
                                   " | Quarto: " + reserva.getQuarto().getNumero() + 
                                   " | Entrada: " + new java.text.SimpleDateFormat("dd/MM/yyyy").format(reserva.getDataEntrada()) + 
                                   " | Saída: " + new java.text.SimpleDateFormat("dd/MM/yyyy").format(reserva.getDataSaida()) + 
                                   " |");
            }
        }

        System.out.println("|------------------------------------------|");

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




}   
