package Model;

public class Servico {
    
    private String tipo;
    private double preco;

    public Servico() {
        this.tipo = null;
        this.preco = 0.0;
    }

    public Servico(String tipo, double preco) {
        this.tipo = tipo;
        this.preco = preco;
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
        return "Servico | Tipo: " + tipo + " | Preco: " + preco;
    }

}
