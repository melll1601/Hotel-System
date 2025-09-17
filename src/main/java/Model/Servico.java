package src.main.java.Model;

public class Servico {

    private int id;
    private int reserva_id;
    private Tipo tipo;
    private double preco;

    public enum Tipo {
        cafe_da_manha,
        lavanderia,
        spa,
        academia
    }

    public Servico(int id, int reserva_id, Tipo tipo, double preco) {
        this.id = id;
        this.reserva_id = reserva_id;
        this.tipo = tipo;
        this.preco = preco;
    }

    public Servico(int reserva_id, Tipo tipo, double preco) {
        this.reserva_id = reserva_id;
        this.tipo = tipo;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public int getReserva_id() {
        return reserva_id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReserva_id(int reserva_id) {
        this.reserva_id = reserva_id;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
