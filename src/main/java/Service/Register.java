package Service;

import DAO.HospedeDAO;
import Model.Hospede;
import Model.Quarto;
import Model.Reserva;
import Util.Validate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.main.java.DAO.QuartoDAO;
import src.main.java.DAO.ReservaDAO;

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

    public static Quarto cadastroQuarto(Scanner leia) throws SQLException{

        var dao = new QuartoDAO();

        System.out.println("[NÚMERO]: ");
        int numero = leia.nextInt();

        System.out.println();

        System.out.println("[TIPO]: ");
        String tipo = leia.nextLine();

        System.out.println();

        System.out.println("[PREÇO]: ");
        double preco = leia.nextDouble();

        System.out.println();

        Quarto.Tipo tipoQuarto = Validate.tipoQuarto();

        return new Quarto(numero, tipoQuarto, preco);
    }
}
