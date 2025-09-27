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
    private String codigoReserva;
    private List<Servico> servicos = new ArrayList<>();
    
    public Reserva() {
        this.id = 0;
        this.hospede = null;
        this.quarto = null;
        this.dataEntrada = null;
        this.dataSaida = null;
        this.codigoReserva = null;
    }

    public Reserva(int id, Hospede hospede, Quarto quarto, Date dataEntrada, Date dataSaida) {
        this.id = id;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Reserva(int id, Hospede hospede, Quarto quarto, Date dataEntrada, Date dataSaida, String codigoReserva) {
        this.id = id;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.codigoReserva = codigoReserva;
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

        public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public void adicionarServico(Servico servico) {
        this.servicos.add(servico);
    }

    public void removerServico(Servico servico) {
        this.servicos.remove(servico);
    }

    public void listarServicos() {
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço adicionado.");
        } else {
            System.out.println("Serviços adicionados:");
            for (Servico servico : servicos) {
                System.out.println(servico);
            }
        }
    }

    @Override
    public String toString() {
        return "Reserva | ID: " + id + " | Hospede: " + hospede + " | Quarto: " + quarto + " | DataEntrada: " + dataEntrada + " | DataSaida: "
                + dataSaida + " | Serviços: " + servicos + " | Código da Reserva: " + codigoReserva + " |";
    }

}
