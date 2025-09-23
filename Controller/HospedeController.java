package Controller;

import Model.Hospede;
import View.Attendant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.HospedeDAO;

public class HospedeController {

    public static Scanner leia = new Scanner(System.in);


    public static void cadastrarHospede() {
        System.out.println(" ");
        Attendant.tituloCadastrar();

        System.out.print("| -> Nome do Hóspede: ");
        String nome = leia.nextLine();
        System.out.print("| -> Documento (CPF ou RG): ");
        String documento = leia.nextLine();
        System.out.print("| -> Telefone: ");
        String telefone = leia.nextLine();

        Dao.HospedeDAO.cadastrarHospede(nome, documento, telefone);
    }

    public static void editarHospede(Hospede hospede) {
        System.out.println(" ");
        Attendant.tituloEditar();    

        System.out.print("| -> Nome do Hóspede (" + hospede.getNome() + "): ");
        String nome = leia.nextLine();
        System.out.print("| -> Documento (CPF ou RG) (" + hospede.getDocumento() + "): ");
        String documento = leia.nextLine();
        System.out.print("| -> Telefone (" + hospede.getTelefone() + "): ");
        String telefone = leia.nextLine();

        if (!nome.isEmpty()) {
            hospede.setNome(nome);
        }
        if (!documento.isEmpty()) {
            hospede.setDocumento(documento);
        }
        if (!telefone.isEmpty()) {
            hospede.setTelefone(telefone);
        }
        
        System.out.println("Sucesso: Dados do hóspede atualizados!");
    }


     public static void listarHospedes() {
        System.out.println(" ");
        Attendant.tituloListar();

        List <Hospede> hospedes = HospedeDAO.listarHospedes();
        if (hospedes.isEmpty()) {
            System.out.println("|        Nenhum hóspede cadastrado!        |");
        } else {
            for (Hospede hospede : hospedes) {
                System.out.println("| ID: " + hospede.getId() + 
                                   " | Nome: " + hospede.getNome() + 
                                   " | Documento: " + hospede.getDocumento() + 
                                   " | Telefone: " + hospede.getTelefone() + 
                                   " |");
            }
        }

        System.out.println("|------------------------------------------|");

    }







}
