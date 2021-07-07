
public class Deus {
    private int vidaBase;
    private int vidaAtual;
    private int vidaMax;
    private int xp;
    private int nivel;
    private int poderBase;
    private int poder;
    private Habilidade habilidades[] = new Habilidade[4];
    private static int qtdDeuses;
    private String nome;
    private boolean morto=false;

    public Deus(int vidaBase_,int poderBase_,int nivel_,String nome_) {
        this.vidaBase=vidaBase_;
        this.poderBase=poderBase_;
        this.nivel=nivel_;
        this.nome=nome_;
        
        this.FuncaoVidaMax();
        this.vidaAtual=this.vidaMax;
        qtdDeuses++;
        
}
    public void AlocarHabilidades(Habilidade[] habilidades_){
    for (int i=0;i<4;i++){
        this.habilidades[i]=habilidades_[i];
    }
}
    
    public void GanharXp(int ganho){
        this.xp=this.xp+ganho;
        FuncaoLvlUP();
    }
    
    private void FuncaoVidaMax(){
        vidaMax=(int) (vidaBase * (Math.pow(1.2,nivel)));
    }
    
    private void FuncaoLvlUP(){
        if(xp>=300)
        {
            this.nivel=1;
        }
        if(xp>=900)
        {
            this.nivel=2;
        }
        if(xp>=2700)
        {
            this.nivel=3;
        }
        if(xp>=6500)
        {
            this.nivel=4;
        }
        if(xp>=14000)
        {
            this.nivel=5;
        }
        if(xp>=23000)
        {
           this.nivel=6;
        }
        if(xp>=34000)
        {
            this.nivel=7;
        }
        if(xp>=48000)
        {
            this.nivel=8;
        }
        if(xp>=64000)
        {
            this.nivel=9;
        }
        if(xp>=85000)
        {
            this.nivel=10;
        }
    }
    public void ReduzirVida(int dano){
        this.vidaAtual=this.vidaAtual-dano;
        if (this.vidaAtual<=0)
        {
            morto=true;
        }
    }
    
    public void RecuperarVida(int recuperacao){
        this.vidaAtual=this.vidaAtual+recuperacao;
        if (this.vidaAtual>this.vidaMax){
            this.vidaAtual=this.vidaMax;
        }
    }
}
