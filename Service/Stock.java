package Service;

import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.List;

import Controller.HospedeController;
import Controller.QuartoController;
import Controller.ReservaController;
import Model.Hospede;
import Model.Quarto;
import Model.Reserva;
import Model.Servico;

import Dao.HospedeDAO;
import Dao.QuartoDAO;
import Dao.ReservaDAO;
import View.Attendant;



public class Stock {


    public void gerenciarEstoque (Attendant attendant, int opcaoEscolhida){

        switch (opcaoEscolhida) {
        
            case 1:
                int opcaoCadastro = Attendant.MenuCadastro();

                switch (opcaoCadastro) {
                    case 1:
                        HospedeController.cadastrarHospede();
                        break;

                    case 2:
                        QuartoController.cadastrarQuarto();
                        break;

                    case 3:
                        ReservaController.cadastrarReserva();
                        break;

                    case 0:
                        Attendant.retornarMenu();
                        break;

                    default:
                        Attendant.opcaoInvalida();
                        break;
                }
                
                break;

            case 2:
                int opcaoListar = Attendant.MenuListar();
                switch (opcaoListar) {
                    case 1:
                        HospedeController.listarHospedes();
                        break;

                    case 2:
                        QuartoController.listarQuartos();
                        break;

                    case 3:
                        ReservaController.listarReservas();
                        break;

                    case 0:
                        Attendant.retornarMenu();
                        break;

                    default:
                        Attendant.opcaoInvalida();
                        break;
                }
                break;

            case 3:
                int opcaoPesquisar = Attendant.menuPesquisar();

                switch(opcaoPesquisar){

                    case 1:
                        HospedeDAO.pesquisarHospede();
                        break;
                    case 2: 
                        QuartoDAO.pesquisarQuarto();
                        break;
                    case 3:
                        ReservaDAO.pesquisarNome();
                        break;
                }

            break;
            
            case 4:
                HospedeDAO.editarDados();
                break;

            case 5:
                ReservaDAO.excluirReserva();
                break;

            case 6:
                Attendant.sairSistema();
                break;

        }
    }
}