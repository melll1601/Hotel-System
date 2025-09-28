package Model;

public class Pessoa {
    
    private int id;
    private String nome;

    public Pessoa(){

        this.id = 0;
        this.nome = " ";
    }

    public Pessoa(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Pessoa(String nome){
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        System.out.println(" ");
        return "Pessoa | ID: " + id + " | " + " Nome: " + nome +  " | " ;
    }
}

