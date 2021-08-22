package classes;

public class Jogador {

    private String nome;
    private int ChaveDeProgresso = 0;
    private String senha;
    private Deus deus;
    private Consumivel consumivel;
    private int carga;

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
        ChaveDeProgresso = ChaveDeProgresso + 1;
    }

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
        }
        if (this.consumivel.getEfeito().equals("Veneno")) {

        }
    }

    public Deus getDeus() {
        return deus;
    }

    //deus.funcaoPoder(efeito);
}


