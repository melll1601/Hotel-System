package Service;

import java.util.ArrayList;
import java.util.List;

import Model.Hospede;
import Model.Quarto;
import Model.Reserva;
import Model.Servico;

import View.Attendant;

public class Stock {

    List<Hospede> hospedes;
    List<Quarto> quartos;
    List<Reserva> reservas;
    List<Servico> servicos;

    public Stock() {
        hospedes = new ArrayList<>();
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
        servicos = new ArrayList<>();
    }

    public void gerenciarEstoque (Attendant attendant, int opcaoEscolhida){

        switch (opcaoEscolhida) {
        
            case 1:
                Attendant.MenuCadastro();
                break;

            case 2:
                Attendant.MenuListar();
                break;

            case 3:
                Attendant.menuPesquisar();
                break;

            case 4:
                Attendant.editarDados();
                break;

            case 5:
                Attendant.cancelarReserva();
                break;

            case 6:
                Attendant.sairSistema();
                break;

        }
    }
}