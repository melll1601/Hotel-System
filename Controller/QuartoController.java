package Controller;

import java.util.List;
import java.util.Scanner;

import Dao.QuartoDAO;
import Model.Quarto;
import View.Attendant;

import Util.Validate;

public class QuartoController {

    public static Scanner leia = new Scanner(System.in);


    public static void cadastrarQuarto() {
        System.out.println(" ");
        Attendant.tituloCadastrar();

        System.out.print("| -> Tipo do Quarto (Simples, Luxo, Suite, Presidencial): ");
        String tipo = leia.nextLine();
        System.out.print("| -> Preço da Diária: ");
        double preco = Validate.ValidarDouble();

        Dao.QuartoDAO.cadastrarQuarto(tipo, preco);
    }

    public static void listarQuartos() {
        System.out.println(" ");
        Attendant.tituloListar();

        List <Quarto> quartos = QuartoDAO.listarQuartos();
        if (quartos.isEmpty()) {
            System.out.println("|              Nenhum quarto cadastrado!               |");
        } else {
            System.out.printf("| %-14s | %-16s | %-16s | \n",
                            "Número", "Tipo", "Preço");

            System.out.println("|------------------------------------------------------|");

            for (Quarto quarto : quartos) {
                System.out.printf("| %-14s | %-16s | %-16s | \n",

                quarto.getNumero() ,
                quarto.getTipo() ,
                quarto.getPreco());
            
            }
        }

        System.out.println("|------------------------------------------------------|");

    }




}