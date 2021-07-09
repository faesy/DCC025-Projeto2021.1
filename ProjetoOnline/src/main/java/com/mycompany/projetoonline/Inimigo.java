/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetoonline;

import static java.lang.Math.pow;

/**
 *
 * @author Usuario
 */
public class Inimigo {

    private int vidaBase;
    private int vidaAtual;
    private int vidaMax;
    private int xpDada;
    private int nivelDeDesafio;
    private int poderBase;
    private int poder;
    private Habilidade habilidades[] = new Habilidade[4];
    private String nome;
    private boolean morto = false;
    private int carga[] = new int[4];

    public Inimigo(int modo, String nomeGenerico) {
        // modo simboliza a dificuldade do jogo
        //pode variar de facil,dificil e pesadelo(1,2,3 respectivamente)
        this.vidaBase = 100 * modo;
        this.nivelDeDesafio = (int) (modo + Math.random() * (10 + modo));
        this.poderBase = 10 * modo;
        estabeleceVida();
        estabelecePoder();
        categorizaXP(modo);
        this.nome = nomeGenerico;
    }

    private void estabeleceVida() {
        this.vidaMax = (int) (this.vidaBase + Math.random() * this.nivelDeDesafio);
        this.vidaAtual = this.vidaMax;
    }

    private void categorizaXP(int modo) {
        // categoriza xp de acordo om o nivel de dificuldade e modo de jogo
        if (modo == 1) {
            this.xpDada = (int) (10 * pow(1.5, this.nivelDeDesafio));
        } else if (modo == 2) {
            this.xpDada = (int) (10 * pow(1.5, this.nivelDeDesafio)) / 2;
        } else {
            this.xpDada = (int) (10 * pow(1.5, this.nivelDeDesafio)) / 3;
        }

    }

    private void estabelecePoder() {
        /*faz o poder variar de acordo com a dificuldade e o modo q a pessoa ta jogano
        vai de 10*1.1^1 até 10*1.1^11 pro modo facil
        vai de 10*1.1^2 até 10*1.1^12 pro modo dificil
        vai de 10*1.1^3 até 10*1.1^13 pro modo pesadelo*/
        this.poder = (int) (this.poderBase * (Math.pow(1.1, this.nivelDeDesafio)));

    }

    private void manejaVida(int dano) {

        this.vidaAtual = this.vidaAtual - dano;
        if (this.vidaAtual <= 0) {
            this.morto = true;
        }
    }

    public int UsarHabilidade(int resposta) {
        if (resposta <= 0 || resposta > 4) {
            //habilidade invalida escolha um numero entre 1 e 4//
            return -1;
        }
        if (this.carga[resposta - 1] == 0) {
            //essa habilidade não possui cargas escolha outra//
            return -1;
        }
        Habilidade h = habilidades[resposta - 1];
        this.carga[resposta - 1] = this.carga[resposta - 1] - 1;
        return h.dano(this.poder);
    }

    public void AlocarHabilidades(Habilidade[] habilidades_) {
        int x[] = new int[4];
        for (int i = 0; i < 4; i++) {
            this.habilidades[i] = habilidades_[i];
            x[i] = habilidades_[i].carga;
            carga[i] = x[i];
        }
    }
}
