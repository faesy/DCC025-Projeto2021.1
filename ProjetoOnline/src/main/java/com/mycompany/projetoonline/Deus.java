/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetoonline;

/**
 *
 * @author mathe
 */
public class Deus {
    private int vidaBase;
    private int vidaAtual;
    private int vidaMax;
    private int xp;
    private int nivel;
    private int poderBase;
    private int poder;
    private Habilidade habilidades[] = new Habilidade[4];
    private String nome;
    private boolean morto=false;
    private int carga[]=new int[4];

    public Deus(int vidaBase_,int poderBase_,int nivel_,String nome_) {
        this.vidaBase=vidaBase_;
        this.poderBase=poderBase_;
        this.nivel=nivel_;
        this.nome=nome_;
        
        this.funcaoVidaMax();
        this.vidaAtual=this.vidaMax;
        this.funcaoPoder();
        
}
    public void descansar(){
        this.vidaAtual=this.vidaMax;
        this.funcaoLvlUP();
        int i;
        for(i=0;i<4;i++){
           this.carga[i]=this.habilidades[i].carga; 
        }
        // tem q botar pra recuperar as cargas das poçoes aqui
        
    }
    
    private void funcaoPoder(){
        this.poder=(int) (this.poderBase * (Math.pow(1.1,this.nivel)));
    }
  
    public int usarHabilidade(int resposta) {
        Habilidade h = habilidades[resposta - 1];
        this.carga[resposta - 1] = this.carga[resposta - 1] - 1;
        return h.dano(this.poder);
    }

    protected boolean verificaSeTemCarga(int slot) {
        if(this.carga[slot-1]==0){
            //essa habilidade não possui cargas escolha outra//
            return false;
        }else{
            return true;
        }
    }
    
    public void alocarHabilidades(Habilidade[] habilidades_){
    int x[]=new int[4];
    for (int i=0;i<4;i++){
        this.habilidades[i]=habilidades_[i];
        x[i]=habilidades_[i].carga;
        carga[i]=x[i];
    }
}
    
    public void ganharXp(int ganho){
        this.xp=this.xp+ganho;
        funcaoLvlUP();
    }
    
    private void funcaoVidaMax(){
        this.vidaMax=(int) (this.vidaBase * (Math.pow(1.2,this.nivel)));
    }
    
    private void funcaoLvlUP(){
        int i=0;
        i=this.nivel;
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
        if(i!=this.nivel){
            //parabens agora vc é lvl this.nivel//
            this.funcaoVidaMax();
            this.funcaoPoder();
        }
    }
    protected void reduzirVida(int dano){
        this.vidaAtual=this.vidaAtual-dano;
        if (this.vidaAtual<=0)
        {
            morto=true;
        }
    }
    
    protected void recuperarVida(int recuperacao){
        this.vidaAtual=this.vidaAtual+recuperacao;
        if (this.vidaAtual>this.vidaMax){
            this.vidaAtual=this.vidaMax;
        }
    }
    protected int getVidaBaseDeus(){
        return this.vidaBase;
    }
    protected int getPoderBaseDeus(){
        return this.poderBase;
    }
    
    protected int usaConsumivel(){
        return 0;
    }
}