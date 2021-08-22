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





    public double usaConsumivel() {
        double efeito = Consumivel.efeitoPot(this.consumivel.getNome());
        if (this.consumivel.getEfeito().equals("Cura")) {
            deus.recuperarVida((int) (deus.getVidaMax() * efeito));
            return 0;
        }
        if (this.consumivel.getEfeito().equals("Poder")) {
            deus.poderMomentaneo(efeito);
            return 0;

        }
        if (this.consumivel.getEfeito().equals("Veneno")) {
            return efeito;
        }
        return 0;
    }

    public double acao(int action) {
        double acontecimento = 0;
        if (action == 1) {
            acontecimento = deus.usarHabilidade(action);
            return acontecimento;
        } else if (action == 2) {
            acontecimento = deus.usarHabilidade(action);
            return acontecimento;
        } else if (action == 3) {
            acontecimento = deus.usarHabilidade(action);
            return acontecimento;
        } else if (action == 4) {
            acontecimento = deus.usarHabilidade(action);
            return acontecimento;
        } else if (action == 5) {
            acontecimento = usaConsumivel();
            return acontecimento;
        }
        return -1;

    }

    public Deus getDeus() {
        return deus;
    }

    //deus.funcaoPoder(efeito);
}

