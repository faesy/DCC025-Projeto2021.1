package classes;

public class Jogador {

    private String nome;
    private String senha;
    private Deus deus;
    private Consumivel consumivel;
    private int carga;

    public Jogador() {

    }

    public void setConsumivel(Consumivel consumivel) {
        this.consumivel = consumivel;
        carga = this.consumivel.getCarga();
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

    public void usaConsumivel() {
        double efeito = Consumivel.efeitoPot(this.consumivel.getNome());
        if (this.consumivel.getEfeito().equals("Cura")) {
            //deus.recuperarVida(deus.);
        }
        if (this.consumivel.getEfeito().equals("Poder")) {
    
            //deus.funcaoPoder(efeito);
        }
        if (this.consumivel.getEfeito().equals("Veneno")) {

        }
        

    }

}
