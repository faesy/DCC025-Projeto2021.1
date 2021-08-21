/*
Hiero Henrique Barcelos Costa -202065136A
Matheus Cardoso Faesy - 202065065A
Thaís de Jesus Soares - 202065511B
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetoonline;

import static java.lang.Math.pow;

/**
 * Hiero Henrique Barcelos Costa -202065136A 
 * Matheus Cardoso Faesy - 202065065A
 * Thaís de Jesus Soares - 202065511B 
*
 */
public class Inimigo extends Deus {

    //atributos da classe Inimigo
    
    private int xpDada;
    private int nivelDesafio;// 1 2 ou 3

    public Inimigo(String nome, String descricao, int vidaBase, int poderBase, int nivel,int transicaoHistoria,int nivelDesafio) {
        super(nome, descricao, vidaBase, poderBase, nivel);
        categorizaXP(transicaoHistoria, nivelDesafio);
    }
   
    //Métodos da classe Habilidade

    @Override
    protected int getPoderBase() {
        return super.getPoderBase(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected int getVidaBase() {
        return super.getVidaBase(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void recuperarVida(int recuperacao) {
        super.recuperarVida(recuperacao); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void reduzirVida(int dano) {
        super.reduzirVida(dano); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected int usaConsumivel() {
        return super.usaConsumivel(); //To change body of generated methods, choose Tools | Templates.
    }

    private void categorizaXP(int transicaoHistoria,int nivelDesafio) {
        // categoriza xp de acordo om o nivel de dificuldade e modo de jogo
        if (transicaoHistoria == 1) {
            this.xpDada = 900*nivelDesafio;
        } else if (transicaoHistoria == 2) {
            this.xpDada = 2700*nivelDesafio;
        } else {
            this.xpDada = 8100*nivelDesafio;
        }

    }

    //assume-se que a funcao verifica carga foi chamada antes

    @Override
    public int usarHabilidade(int resposta) {
        return super.usarHabilidade(resposta); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alocarHabilidades(Habilidade[] habilidades) {
        super.alocarHabilidades(habilidades); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean verificaCarga(int slot) {
        return super.verificaCarga(slot); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean verificaMorto() {
        return super.verificaMorto(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
