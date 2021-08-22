package classes;

public class Jogador {

    private String nome;
    private int ChaveDeProgresso=0;
    private String senha;
    private Deus deus;
    private Consumivel[] consumiveis;

    public void setDeus(Deus deus) {
        this.deus = deus;
    }

    public int getChaveDeProgresso() {
        return ChaveDeProgresso;
    }

    public void setChaveDeProgresso(int ChaveDeProgresso) {
        this.ChaveDeProgresso = ChaveDeProgresso;
    }
    
    public void aumentaChaveDeProgresso() {
        ChaveDeProgresso=ChaveDeProgresso+1;
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

    public Deus getDeus() {
        return deus;
    }
    
    
}