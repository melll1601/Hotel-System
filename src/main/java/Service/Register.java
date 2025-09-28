package Service;

import DAO.HospedeDAO;
import DAO.QuartoDAO;
import DAO.ReservaDAO;
import Model.Hospede;
import Model.Quarto;
import Model.Reserva;
import Util.Validate;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Register {

    public static Scanner leia = new Scanner(System.in);
    static List<Hospede> listHospede = new ArrayList<>();

    public static Hospede cadastroHospede(Scanner leia) throws SQLException {

        var dao = new HospedeDAO();

        System.out.print("[NOME]: ");
        String nome = leia.nextLine();

        System.out.println();

        System.out.print("[DOCUMENTO]: ");
        String documento = leia.nextLine();

        System.out.println();

        System.out.print("[TELEFONE]: ");
        String telefone = leia.nextLine();

        System.out.println();

        return new Hospede(nome, documento, telefone);

    }

    public static Quarto cadastroQuarto(Scanner leia) throws SQLException {

        var dao = new QuartoDAO();

        System.out.println("[NÚMERO]: ");
        int numero = 0;
        while (true) {
            try {
                numero = Integer.parseInt(leia.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ALGO DEU ERRADO] Digite um número válido!");
            }
        }

        System.out.println();

        System.out.println("[TIPO]: ");
        for (Quarto.Tipo tipo : Quarto.Tipo.values()) {
            System.out.println("- " + tipo);
        }
        Quarto.Tipo tipoQuarto = Validate.tipoQuarto();

        System.out.println();

        System.out.println("[PREÇO]: ");
        double preco = 0;
        while (true) {
            try {
                String entrada = leia.nextLine().replace(",", ".");
                preco = Double.parseDouble(entrada);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ALGO DEU ERRADO] Digite um preço válido!");
            }
        }

        System.out.println();

        return new Quarto(numero, tipoQuarto, preco);
    }


    public static Reserva cadastroReserva(Scanner leia) throws SQLException{

        var dao = new ReservaDAO();

        System.out.print("[ID QUARTO]: ");
        int quartoId = leia.nextInt();
        leia.nextLine();

        System.out.print("[ID HOSPEDE]: ");
        int hospedeId = leia.nextInt();
        leia.nextLine();

        System.out.print("[DATA ENTRADA]: ");
        LocalDate entrada = LocalDate.parse((leia.nextLine()));


        System.out.print("[DATA SAÍDA]: ");
        LocalDate saida = LocalDate.parse((leia.nextLine()));

        return new Reserva(quartoId, hospedeId, entrada, saida);

    }
    
}
