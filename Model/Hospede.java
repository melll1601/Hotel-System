package Model;

public class Hospede extends Pessoa {
    
    private String documento;
    private String telefone;

    public Hospede() {
        super();
        this.documento = null;
        this.telefone = null;
    }

    public Hospede(int id, String nome, String documento, String telefone) {
        super(id, nome);
        this.documento = documento;
        this.telefone = telefone;
    }

        public Hospede(String nome, String documento, String telefone) {
        super(nome);
        this.documento = documento;
        this.telefone = telefone;
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
        return "Hospede | " + " Documento: " + documento + " | " + " Telefone: " + telefone + " | " ;
    }
}
