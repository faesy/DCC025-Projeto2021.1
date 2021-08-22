package classes;

public class Deus {

    private String nome, descricao;
    private int vidaBase, nivel, poderBase, vidaMax, vidaAtual, poder, xp;
    private int[] carga = new int[4];
    private Habilidade[] habilidades;
    private String caminhoIcone;
    private boolean morto = false;

    public Deus() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getVidaBase() {
        return vidaBase;
    }

    public void setVidaBase(int vidaBase) {
        this.vidaBase = vidaBase;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPoderBase() {
        return poderBase;
    }

    public void setPoderBase(int poderBase) {
        this.poderBase = poderBase;
    }

    public Habilidade[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Habilidade[] habilidades) {
        this.habilidades = habilidades;
        for (int i = 0; i < 4; i++) {
            carga[i]= this.habilidades[i].getCarga();
        }
    }

    public String getCaminhoIcone() {
        return caminhoIcone;
    }

    public void setCaminhoIcone(String caminhoIcone) {
        this.caminhoIcone = caminhoIcone;
    }

    public void descansar() {
        this.vidaAtual = this.vidaMax;
        this.funcaoLvlUp();
        int i;
        for (i = 0; i < 4; i++) {
            this.carga[i] = this.habilidades[i].carga;
        }
        // tem que colocar para recuperar as cargas das poçoes aqui ainda

    }

    protected void funcaoPoder() {
        this.poder = (int) (this.poderBase * (Math.pow(1.1, this.nivel)));
    }

    public int usarHabilidade(int slotHabilidade) {
        if (slotHabilidade <= 0 || slotHabilidade > 4) {
            //habilidade invalida escolha um numero entre 1 e 4//
            return -1;
        }
        if (verificaCarga(slotHabilidade)) {
            return -1;
        }
        Habilidade h = habilidades[slotHabilidade - 1];
        this.carga[slotHabilidade - 1] = this.carga[slotHabilidade - 1] - 1;
        return h.causaDano(this.poder);
    }

    protected boolean verificaCarga(int slot) {
        if (this.carga[slot - 1] == 0) {
            //essa habilidade não possui cargas escolha outra//
            return false;
        } else {
            return true;
        }
    }

    protected void funcaoVidaMax() {
        this.vidaMax = (int) (this.vidaBase * (Math.pow(1.2, this.nivel)));
    }

    private void funcaoLvlUp() {
        this.nivel += 1;

        this.funcaoVidaMax();
        this.funcaoPoder();
       
    }

    protected void reduzirVida(int dano) {
        this.vidaAtual = this.vidaAtual - dano;
        if (this.vidaAtual <= 0) {
            morto = true;
        }
    }

    protected void recuperarVida(int recuperacao) {
        this.vidaAtual = this.vidaAtual + recuperacao;
        if (this.vidaAtual > this.vidaMax) {
            this.vidaAtual = this.vidaMax;
        }
    }

    protected boolean verificaMorto() {
        if (this.morto) {
            return false;
        } else {
            return true;
        }
    }
    protected void poderMomentaneo(int efeito){
        this.poder = this.poder*(1+efeito);
    }
}
