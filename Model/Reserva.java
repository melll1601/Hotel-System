package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva {

    private int id;
    private Hospede hospede;
    private Quarto quarto;
    private Date data_entrada;
    private Date data_saida;
    private List<Servico> servicos = new ArrayList<>();
    
    public Reserva() {
        this.id = 0;
        this.hospede = null;
        this.quarto = null;
        this.data_entrada = null;
        this.data_saida = null;
    }

    public Reserva(int id, Hospede hospede, Quarto quarto, Date data_entrada, Date data_saida) {
        this.id = id;
        this.hospede = hospede;
        this.quarto = quarto;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    @Override
    public String toString() {
        return "Reserva | ID: " + id + " | Hospede: " + hospede + " | Quarto: " + quarto + " | Data_entrada: " + data_entrada + " | Data_saida: "
                + data_saida + " | Serviços: " + servicos;
    }

}
