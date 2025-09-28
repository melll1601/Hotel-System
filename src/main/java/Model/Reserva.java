package Model;

import java.time.LocalDate;

public class Reserva {

    private int id;
    private int quarto_id;
    private int hospede_id;
    private LocalDate data_entrada;
    private LocalDate data_saida;

    public Reserva() {}

    public Reserva(int id, int quarto_id, int hospede_id, LocalDate data_entrada, LocalDate data_saida) {
        this.id = id;
        this.quarto_id = quarto_id;
        this.hospede_id = hospede_id;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
    }

    public Reserva(int quarto_id, int hospede_id, LocalDate data_entrada, LocalDate data_saida) {
        this.quarto_id = quarto_id;
        this.hospede_id = hospede_id;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
    }

    public int getId() {
        return id;
    }

    public int getQuarto_id() {
        return quarto_id;
    }

    public int getHospede_id() {
        return hospede_id;
    }

    public LocalDate getData_entrada() {
        return data_entrada;
    }

    public LocalDate getData_saida() {
        return data_saida;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuarto_id(int quarto_id) {
        this.quarto_id = quarto_id;
    }

    public void setHospede_id(int hospede_id) {
        this.hospede_id = hospede_id;
    }

    public void setData_entrada(LocalDate data_entrada) {
        this.data_entrada = data_entrada;
    }

    public void setData_saida(LocalDate data_saida) {
        this.data_saida = data_saida;
    }
}
