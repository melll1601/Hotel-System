package Service;

import DAO.HospedeDAO;
import DAO.QuartoDAO;
import DAO.ReservaDAO;
import View.Attendant;
import java.sql.SQLException;
import java.util.Scanner;

public class Stock {

    public static Scanner leia = new Scanner(System.in);

    public int gerenciarEstoque (int opcaoEscolhida, Attendant attendant) throws SQLException {

        switch (opcaoEscolhida){

            case 1 ->{

                int opcaoCadastro = Attendant.MenuCadastro();

                switch (opcaoCadastro){

                    case 1 ->{
                        
                        var hospede = Register.cadastroHospede(leia);

                        try{
                            HospedeDAO.cadastroHospede(hospede);
                            System.out.println("[CADASTRO CONCLUÍDO]");
                        }catch (SQLException erro){
                            erro.printStackTrace();
                        }
                    }

                    case 2 ->{
                        
                        var quarto = Register.cadastroQuarto(leia);

                        try{
                           QuartoDAO.cadastroQuarto(quarto);
                           System.out.println("[CADASTRO CONCLUÍDO]");
                        }catch (SQLException erro){
                            erro.printStackTrace();
                        }
                    }

                    case 3 ->{

                        var reserva = Register.cadastroReserva(leia);

                        try{
                            ReservaDAO.cadastrarReserva(reserva);
                            System.out.println("[CADASTRO CONCLUÍDO]");
                        }catch (SQLException erro){
                            erro.printStackTrace();
                        }
                    }
                }
            }

            case 2 ->{

                int escolhaListar = Attendant.MenuListar();

                switch (escolhaListar){

                    case 1 ->{
                        HospedeDAO.listarHospedes();
                        break;
                    }

                    case 2 ->{
                        QuartoDAO.listarQuartos();
                        break;
                    }

                    case 3 ->{
                        ReservaDAO.listarReservas();
                        break;
                    }

                    case 0 -> {
                        Attendant.MenuPrincipal();
                        break;
                    }

                    default -> {
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                    }
                }
            }

            case 3 -> {

                int escolhaPesquisar = Attendant.menuPesquisar();

                switch (escolhaPesquisar) {
                    
                    case 1 -> {
                        System.out.println("Digite o nome do hóspede que deseja pesquisar: ");
                        String nome = leia.nextLine();
                        var hospedes = HospedeDAO.pesqHospedesPorNome(nome);

                        if (hospedes.isEmpty()) {
                            System.out.println("Nenhum hóspede encontrado.");
                        } else {
                            for (var hospede : hospedes) {
                                System.out.println(" ");
                                System.out.printf("ID: %d, Nome: %s, Documento: %s, Telefone: %s%n",
                                        hospede.getId(), hospede.getNome(), hospede.getDocumento(), hospede.getTelefone());
                            }
                        }
                    }

                    case 2 -> {
                        System.out.println("Digite o número do quarto que deseja pesquisar: ");
                        int numero = leia.nextInt();
                        leia.nextLine();
                        var quartos = QuartoDAO.pesqQuartosPorNumero(numero);

                        if (quartos.isEmpty()) {
                            System.out.println("Nenhum quarto encontrado.");
                        } else {
                            for (var quarto : quartos) {
                                System.out.println(" ");
                                System.out.printf("ID: %d, Número: %d, Tipo: %s, Preço: %.2f%n",
                                        quarto.getId(), quarto.getNumero(), quarto.getTipo(), quarto.getPreco());
                            }
                        }
                    }

                    case 3 -> {
                        System.out.println("Digite o nome do hóspede para listar suas reservas: ");
                        String nome = leia.nextLine();
                        var reservas = ReservaDAO.pesqReservasPorNomeHospede(nome);

                        if (reservas.isEmpty()) {
                            System.out.println("Nenhuma reserva encontrada.");
                        } else {
                            for (var reserva : reservas) {
                                System.out.println(" ");
                                System.out.printf("ID: %d, Quarto: %d, Hóspede: %d, Data Entrada: %s, Data Saída: %s%n",
                                        reserva.getId(), reserva.getQuarto_id(), reserva.getHospede_id(),
                                        reserva.getData_entrada(), reserva.getData_saida());
                            }
                        }
                    }

                    case 0 -> {
                        Attendant.MenuPrincipal();
                        break;
                    }

                    default -> {
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                    }
                }
            }

            case 4 -> {

                int id = Attendant.editarDados();
                var hospede = HospedeDAO.pesqHospedesPorId(id);

                if (hospede != null) {
                    System.out.println("Hóspede encontrado:");
                    System.out.printf("ID: %d, Nome: %s, Documento: %s, Telefone: %s%n",
                            hospede.getId(), hospede.getNome(), hospede.getDocumento(), hospede.getTelefone());

                    System.out.println("Digite os novos dados do hóspede:");
                    System.out.print("Nome: ");
                    String nome = leia.nextLine();
                    System.out.print("Documento: ");
                    String documento = leia.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = leia.nextLine();

                    hospede.setNome(nome);
                    hospede.setDocumento(documento);
                    hospede.setTelefone(telefone);

                    HospedeDAO.editarHospede(hospede);
                    System.out.println("[EDITADO COM SUCESSO]");
                } else {
                    System.out.println("Nenhum hóspede encontrado com o ID fornecido.");
                }
            }

            case 5 -> {

                int idReserva = Attendant.cancelarReserva();
                var reserva = ReservaDAO.pesqReservasPorId(idReserva);

                if (reserva != null) {
                    System.out.println("Reserva encontrada:");
                    System.out.printf("ID: %d, Quarto: %d, Hóspede: %d, Data Entrada: %s, Data Saída: %s%n",
                            reserva.getId(), reserva.getQuarto_id(), reserva.getHospede_id(),
                            reserva.getData_entrada(), reserva.getData_saida());

                    System.out.print("Tem certeza que deseja cancelar esta reserva? (s/n): ");
                    String confirmacao = leia.nextLine();

                    if (confirmacao.equalsIgnoreCase("s")) {
                        ReservaDAO.cancelarReserva(idReserva);
                        System.out.println("[RESERVA CANCELADA COM SUCESSO]");
                    } else {
                        System.out.println("Cancelamento de reserva abortado.");
                    }
                } else {
                    System.out.println("Nenhuma reserva encontrada com o ID fornecido.");
                }
            }

            case 6 ->{
                Attendant.sairSistema();
                return 0;
            }
        }

        return opcaoEscolhida;
        
    }
}
