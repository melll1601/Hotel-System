package Service;

import DAO.HospedeDAO;
import DAO.QuartoDAO;
import DAO.ReservaDAO;
import View.Attendant;
import java.sql.SQLException;
import java.util.Scanner;

public class Stock {

    public static Scanner leia = new Scanner(System.in);

    public void gerenciarEstoque (int opcaoEscolhida, Attendant attendant) throws SQLException {

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

            case 6 ->{
                Attendant.sairSistema();
            }
        }
    }
}
