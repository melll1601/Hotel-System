package Controller;

import java.util.List;
import java.util.Scanner;

import Dao.HospedeDAO;
import Dao.QuartoDAO;
import Model.Hospede;
import Model.Quarto;
import Util.Validate;
import View.Attendant;

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

        Dao.ReservaDAO.cadastrarReserva(hospede, quarto, dataEntrada, dataSaida, codigoReserva);
    }

    public static void listarReservas() {
        System.out.println(" ");
        Attendant.tituloListar();

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
                                   " | Código Reserva: " + reserva.getCodigoReserva() + 
                                   " |");
            }
        }

        System.out.println("|------------------------------------------|");

    }




}
