/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

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
        
        this.FuncaoVidaMax();
        this.vidaAtual=this.vidaMax;
        this.FuncaoPoder();
        
}
    public void descansar(){
        this.vidaAtual=this.vidaMax;
        this.FuncaoLvlUP();
        int i;
        for(i=0;i<4;i++){
           this.carga[i]=this.habilidades[i].carga; 
        }
        
    }
    
    private void FuncaoPoder(){
        this.poder=(int) (this.poderBase * (Math.pow(1.1,this.nivel)));
    }
  
    public int UsarHabilidade(int resposta){
        if(resposta<=0 || resposta>4){
            //habilidade invalida escolha um numero entre 1 e 4//
            return -1;
        }
        if(this.carga[resposta-1]==0){
            //essa habilidade não possui cargas escolha outra//
            return -1;
        }
        Habilidade h=habilidades[resposta-1];
        this.carga[resposta-1]=this.carga[resposta-1]-1;
        return h.dano(this.poder);
    }
    
    public void AlocarHabilidades(Habilidade[] habilidades_){
    int x[]=new int[4];
    for (int i=0;i<4;i++){
        this.habilidades[i]=habilidades_[i];
        x[i]=habilidades_[i].carga;
        carga[i]=x[i];
    }
}
    
    public void GanharXp(int ganho){
        this.xp=this.xp+ganho;
        FuncaoLvlUP();
    }
    
    private void FuncaoVidaMax(){
        this.vidaMax=(int) (this.vidaBase * (Math.pow(1.2,this.nivel)));
    }
    
    private void FuncaoLvlUP(){
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
            this.FuncaoVidaMax();
            this.FuncaoPoder();
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
