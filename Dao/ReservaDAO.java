package Dao;

import Model.Hospede;
import Model.Quarto;
import Model.Reserva;
import java.util.ArrayList;
import java.util.Date;

public class ReservaDAO {
    
    private static ArrayList<Reserva> listaReservas = new ArrayList<>();
    private static int contadorId = 1;

    public static void cadastrarReserva(Hospede hospede, Quarto quarto, Date dataEntrada, Date dataSaida) {
        Reserva novaReserva = new Reserva(contadorId, hospede, quarto, dataEntrada, dataSaida);
        listaReservas.add(novaReserva);
        contadorId++;
        System.out.println("Sucesso: Reserva cadastrada!");
    }
    
}
