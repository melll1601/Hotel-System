package Model;

public class Quarto {

    private int id;
    private int numero;
    private Tipo tipo;
    private double preco;

    public enum Tipo {
        simples,
        duplo,
        suite
    }

    public Quarto() {}

    public Quarto(int id, int numero, Tipo tipo, double preco) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
    }

    public Quarto(int numero, Tipo tipo, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public int getNumero() {
        return numero;
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

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipoPedido() {
        String tipoQuarto = String.valueOf(tipo);
        return tipoQuarto;
    }


}
