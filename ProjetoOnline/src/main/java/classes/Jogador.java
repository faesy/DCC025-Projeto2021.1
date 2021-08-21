package classes;

public class Jogador {

    private String nome;
    private String senha;
    private Deus deus;
    private Consumivel[] consumiveis;

    public void setDeus(Deus deus) {
        this.deus = deus;
    }
    
    

    public Jogador() {
        consumiveis = new Consumivel[2];
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
    
    
}