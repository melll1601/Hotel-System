package Dao;

import Model.Hospede;
import Model.Quarto;
import View.Attendant;

import java.util.ArrayList;

public class QuartoDAO {

    private static ArrayList<Quarto> listaQuartos = new ArrayList<>();
    private static int contadorId = 1;

    public static void cadastrarQuarto(String tipo, double preco) {
        Quarto novoQuarto = new Quarto(contadorId, tipo, preco);
        listaQuartos.add(novoQuarto);
        contadorId++;
        System.out.println("Sucesso: Quarto cadastrado!");
    }

    public static Quarto buscarPorNumero(int numero) {
        for (Quarto quarto : listaQuartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }

    public static ArrayList<Quarto> listarQuartos() {
        return listaQuartos;
    }

    public static void pesquisarQuarto(){

        String tipoPesquisa = Attendant.pesquisarTipo();
        boolean pesquisado = false;

        for(Quarto quarto : QuartoDAO.listarQuartos()){

            if(quarto.getTipo().equalsIgnoreCase(tipoPesquisa)){
                System.out.println("[RESULTADO DA PESQUISA]: " + quarto);

                pesquisado = true;
            }
        }

        if(!pesquisado){
            Attendant.naoEncontrado();
        }
    }

}