package Dao;

import Model.Quarto;
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

}