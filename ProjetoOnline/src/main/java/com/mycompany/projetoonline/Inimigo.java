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
public class Inimigo {

    //atributos da classe Inimigo
    private int vidaBase;
    private int vidaAtual;
    private int vidaMax;
    private int xpDada;
    private int nivelDesafio;
    private int poderBase;
    private int poder;
    private Habilidade habilidades[] = new Habilidade[4];
    private String nome;
    private boolean morto = false;
    private int carga[] = new int[4];

    //Métodos da classe Habilidade
    public Inimigo(int modo, String nomeGenerico) {
        //modo simboliza a dificuldade do jogo
        //pode variar de facil,dificil e pesadelo(1,2,3 respectivamente)
        this.vidaBase = 100 * modo;
        this.nivelDesafio = (int) (modo + Math.random() * (10 + modo));
        this.poderBase = 10 * modo;
        estabeleceVida();
        estabelecePoder();
        categorizaXP(modo);
        this.nome = nomeGenerico;
        // acho q ainda ta faltando algo aqui no construtor pfv dps deem uma olhada.
        // sinto q tinha q botar o aloca habilidade aqui direto.
    }

    private void estabeleceVida() {
        //estavelece a vida do Inimigo
        this.vidaMax = (int) (this.vidaBase + Math.random() * this.nivelDesafio);
        this.vidaAtual = this.vidaMax;
    }

    private void categorizaXP(int modo) {
        // categoriza xp de acordo om o nivel de dificuldade e modo de jogo
        if (modo == 1) {
            this.xpDada = (int) (10 * pow(1.5, this.nivelDesafio));
        } else if (modo == 2) {
            this.xpDada = (int) (10 * pow(1.5, this.nivelDesafio)) / 2;
        } else {
            this.xpDada = (int) (10 * pow(1.5, this.nivelDesafio)) / 3;
        }

    }

    private void estabelecePoder() {
        /*faz o poder variar de acordo com a dificuldade e o modo que a pessoa esta jogando
        vai de 10*1.1^1 até 10*1.1^11 pro modo facil
        vai de 10*1.1^2 até 10*1.1^12 pro modo dificil
        vai de 10*1.1^3 até 10*1.1^13 pro modo pesadelo*/
        this.poder = (int) (this.poderBase * (Math.pow(1.1, this.nivelDesafio)));

    }

    protected void manejaVida(int dano) {
        //atualiza a vida do Inimigo após sofrer danos
        this.vidaAtual = this.vidaAtual - dano;
        if (this.vidaAtual <= 0) {
            this.morto = true;
        }
    }

    //assume-se que a funcao verifica carga foi chamada antes
    public int usarHabilidade(int resposta) {
        Habilidade h = habilidades[resposta - 1];
        this.carga[resposta - 1] = this.carga[resposta - 1] - 1;
        return h.dano(this.poder);
    }

    public void alocarHabilidades(Habilidade[] habilidades_) {
        int x[] = new int[4];
        for (int i = 0; i < 4; i++) {
            this.habilidades[i] = habilidades_[i];
            x[i] = habilidades_[i].carga;
            carga[i] = x[i];
        }
    }

    protected boolean verificaCarga(int slot) {
        if (this.carga[slot - 1] == 0) {
            //essa habilidade não possui cargas escolha outra//
            return false;
        } else {
            return true;
        }
    }

    protected boolean verificaMorto() {
        if (this.morto) {
            return false;
        } else {
            return true;
        }
    }
}
