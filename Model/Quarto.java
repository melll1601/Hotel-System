package Model;

public class Quarto {
    
    private int numero;
    private String tipo;
    private double preco;

    public Quarto() {
        this.numero = 0;
        this.tipo = null;
        this.preco = 0.0;
    }

    public Quarto (int numero, String tipo, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        System.out.println(" ");
        return "Quarto | Número: " + numero + " Tipo: " + tipo + " Preço: " + preco;
    }

}
