package Controller;

import java.util.List;
import java.util.Scanner;

import Dao.HospedeDAO;
import Dao.QuartoDAO;
import Model.Hospede;
import Model.Quarto;
import Util.Validate;
import View.Attendant;
import Model.Servico;
import Model.Reserva;
import Dao.ReservaDAO;

public class ReservaController {
    
    public static Scanner leia = new Scanner(System.in);


    public static void cadastrarReserva() {
        System.out.println(" ");
        Attendant.tituloCadastrar();

        System.out.print("| -> ID do Hóspede: ");
        int idHospede = Validate.ValidarInt();
        System.out.print("| -> ID do Quarto: ");
        int idQuarto = Validate.ValidarInt();
        System.out.print("| -> Data de Entrada: ");
        String Entrada = leia.nextLine();
        System.out.print("| -> Data de Saída: ");
        String Saida = leia.nextLine();
        System.out.print("| -> Código da Reserva: ");
        String codigoReserva = leia.nextLine();

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

    if (ReservaDAO.quartoJaReservado(idQuarto)) {
        System.out.println("| Erro: Este quarto já está reservado!");
        return;
    }

    ReservaDAO.cadastrarReserva(hospede, quarto, dataEntrada, dataSaida, codigoReserva);
        System.out.println("| Reserva cadastrada com sucesso!");
    }

    public static void listarReservas() {
        System.out.println();
        Attendant.tituloListar();

        List<Model.Reserva> reservas = Dao.ReservaDAO.listarReservas();
        if (reservas.isEmpty()) {
            System.out.println("|            Nenhuma reserva cadastrada!               |");

        } else {

            System.out.printf("| %-3s | %-7s | %-6s | %-7s | %-8s | %-6s |\n",
                    "ID", "Hóspede", "Quarto", "Entrada", "Saída", "Código");
            System.out.println("|------------------------------------------------------|");

            for (Model.Reserva r : reservas) {
                System.out.printf("| %-3s | %-7s | %-6s | %-7s | %-8s | %-6s |\n",
                        r.getId(),
                        r.getHospede().getNome(),
                        r.getQuarto().getNumero(),
                        new java.text.SimpleDateFormat("dd/MM").format(r.getDataEntrada()),
                        new java.text.SimpleDateFormat("dd/MM").format(r.getDataSaida()),
                        r.getCodigoReserva());
            }
            System.out.println("|------------------------------------------------------|");
    }
}


    public static void adicionarServico(int idReserva, int opcaoServico) {
        Reserva reserva = ReservaDAO.buscarPorId(idReserva);
        if (reserva == null) {
                System.out.println("Reserva não encontrada.");
                return;
            }

            Servico servico = null;

            switch (opcaoServico) {
                case 1:
                    servico = new Servico("Café da Manhã", 20.0);
                    break;
                case 2:
                    servico = new Servico("Almoço", 50.0);
                    break;
                case 3:
                    servico = new Servico("Jantar", 70.0);
                    break;
                case 4:
                    servico = new Servico("Serviço de Quarto", 30.0);
                    break;
                case 5:
                    servico = new Servico("Lavanderia", 40.0);
                    break;
                default:
                    System.out.println("Opção de serviço inválida.");
                    return;
            }

            reserva.getServicos().add(servico);
            System.out.println("Serviço adicionado com sucesso.");
        }

    public static void listarServicos(int idReserva) {
        Reserva reserva = ReservaDAO.buscarPorId(idReserva);
        if (reserva == null) {
            System.out.println("Reserva não encontrada.");
            return;
        }

        if (reserva.getServicos().isEmpty()) {
            System.out.println("Nenhum serviço adicionado.");
        } else {
            System.out.println("Serviços adicionados:");
            for (Servico servico : reserva.getServicos()) {
                System.out.println(servico);
            }
        }
    }

}
