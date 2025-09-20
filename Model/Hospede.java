package Model;

public class Hospede {
    
    private int id;
    private String nome;
    private String documento;
    private String telefone;

    public Hospede() {
        this.id = 0;
        this.nome = null;
        this.documento = null;
        this.telefone = null;
    }

    public Hospede(int id, String nome, String documento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        System.out.println(" ");
        return "Hospede | ID: " + id + " Nome: " + nome + " Documento: " + documento + " Telefone: " + telefone;
    }
}
