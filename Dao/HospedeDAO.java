package Dao;

import Model.Hospede;
import View.Attendant;

import java.util.ArrayList;
import java.util.List;

public class HospedeDAO {

    private static ArrayList<Hospede> listaHospedes = new ArrayList<>();
    private static int contadorId = 1;

    public static void cadastrarHospede(String nome, String documento, String telefone) {
        Hospede novoHospede = new Hospede(contadorId, nome, documento, telefone);
        listaHospedes.add(novoHospede);
        contadorId++;
        System.out.println("Sucesso: Hóspede cadastrado!");
    }

    public static Hospede buscarPorId(int id) {
        for (Hospede hospede : listaHospedes) {
            if (hospede.getId() == id) {
                return hospede;
            }
        }
        return null;
    }

    public static List<Hospede> listarHospedes() {
        return listaHospedes;
    }

    public static void pesquisarHospede(){

        String nomePesquisa = Attendant.pesquisarNome();
        boolean pesquisado = false;

        for(Hospede hospede : HospedeDAO.listarHospedes()){

            if(hospede.getNome().equalsIgnoreCase(nomePesquisa)){
                System.out.println("[RESULTADO DA PESQUISA]: " + hospede);

                pesquisado = true;
            }
        }

        if(!pesquisado){
            Attendant.naoEncontrado();
        }            
    }
}