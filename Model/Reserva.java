package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva {

    private int id;
    private Hospede hospede;
    private Quarto quarto;
    private Date dataEntrada;
    private Date dataSaida;
    private List<Servico> servicos = new ArrayList<>();
    
    public Reserva() {
        this.id = 0;
        this.hospede = null;
        this.quarto = null;
        this.dataEntrada = null;
        this.dataSaida = null;
    }

    public Reserva(int id, Hospede hospede, Quarto quarto, Date dataEntrada, Date dataSaida) {
        this.id = id;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
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

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    @Override
    public String toString() {
        return "Reserva | ID: " + id + " | Hospede: " + hospede + " | Quarto: " + quarto + " | DataEntrada: " + dataEntrada + " | DataSaida: "
                + dataSaida + " | Serviços: " + servicos;
    }

}
