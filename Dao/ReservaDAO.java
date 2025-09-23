package Dao;

import Model.Hospede;
import Model.Quarto;
import Model.Reserva;
import View.Attendant;

import java.util.ArrayList;
import java.util.Date;

public class ReservaDAO {
    
    private static ArrayList<Reserva> listaReservas = new ArrayList<>();
    private static int contadorId = 1;

    public static void cadastrarReserva(Hospede hospede, Quarto quarto, Date dataEntrada, Date dataSaida, String codigoReserva) {
        Reserva novaReserva = new Reserva(contadorId, hospede, quarto, dataEntrada, dataSaida, codigoReserva);
        listaReservas.add(novaReserva);
        contadorId++;
        System.out.println("Sucesso: Reserva cadastrada!");
    }

    public static ArrayList<Reserva> listarReservas() {
        return listaReservas;
    }

    public static void pesquisarNome(){

        String nomeHospede = Attendant.pesquisarNomeReserva();
        boolean pesquisado = false;

        for(Reserva reserva : ReservaDAO.listarReservas()){

            if(reserva.getHospede().getNome().equalsIgnoreCase(nomeHospede)){
                System.out.println("[RESULTADO DA PESQUISA]: " + reserva);

                pesquisado = true;
            }
        }

        if(!pesquisado){
            Attendant.naoEncontrado();
        }            
    }

    public static void excluirReserva(){
            String codigoRemover = Attendant.cancelarReserva();
			boolean removido = false;

			for (int indice = 0; indice < listarReservas().size(); indice++) {
				if (listarReservas().get(indice).getCodigoReserva().equalsIgnoreCase(codigoRemover)) {
					listarReservas().remove(indice);
					removido = true;
				}

				if (removido) {
					Attendant.reservaExcluida();
				} else {
					Attendant.naoEncontrado();
				}
			}
	}
}
    

