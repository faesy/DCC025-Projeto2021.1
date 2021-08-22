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

/**
 * Hiero Henrique Barcelos Costa -202065136A Matheus Cardoso Faesy - 202065065A
 * Thaís de Jesus Soares - 202065511B
 *
 */
public class Deus {


    protected int vidaBase;
    protected int vidaAtual;
    protected int vidaMax;
    protected int xp;
    protected int nivel;
    protected int poderBase;
    protected int poder;
    protected Habilidade habilidades[] = new Habilidade[4];
    protected String nome;
    protected String descricao;
    protected boolean morto = false;
    protected int carga[] = new int[4];
    protected static int qtddDeuses;


    //Bloco estático para inicializar a variável qtddDeuses
    static {
        qtddDeuses = 0;
    }

    //Métodos da classe Deus
    public Deus(String nome, String descricao, int vidaBase, int poderBase, int nivel) {
        this.vidaBase = vidaBase;
        this.poderBase = poderBase;
        this.nivel = nivel;
        this.nome = nome;
        this.descricao = descricao;

        this.funcaoVidaMax();
        this.vidaAtual = this.vidaMax;
        this.funcaoPoder();

        qtddDeuses++;
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

    private void funcaoPoder() {
        this.poder = (int) (this.poderBase * (Math.pow(1.1, this.nivel)));
    }

    public int usarHabilidade(int resposta) {
        if (resposta <= 0 || resposta > 4) {
            //habilidade invalida escolha um numero entre 1 e 4//
            return -1;
        }
        if (verificaCarga(resposta)) {
            return -1;
        }
        Habilidade h = habilidades[resposta - 1];
        this.carga[resposta - 1] = this.carga[resposta - 1] - 1;
        return h.dano(this.poder);
    }

    protected boolean verificaCarga(int slot) {
        if (this.carga[slot - 1] == 0) {
            //essa habilidade não possui cargas escolha outra//
            return false;
        } else {
            return true;
        }
    }

    public void alocarHabilidades(Habilidade[] habilidades) {
        int x[] = new int[4];
        for (int i = 0; i < 4; i++) {
            this.habilidades[i] = habilidades[i];
            x[i] = habilidades[i].carga;
            carga[i] = x[i];
        }
    }

    public void ganharXp(int ganho) {
        this.xp = this.xp + ganho;
        funcaoLvlUp();
    }

    public void perderXp(int perda) {
        this.xp -= perda;
        funcaoLvlUp();
    }

    private void funcaoVidaMax() {
        this.vidaMax = (int) (this.vidaBase * (Math.pow(1.2, this.nivel)));
    }

    private void funcaoLvlUp() {
        int i = 0;
        i = this.nivel;
        if (xp >= 300) {
            this.nivel = 1;
        }
        if (xp >= 900) {
            this.nivel = 2;
        }
        if (xp >= 2700) {
            this.nivel = 3;
        }
        if (xp >= 6500) {
            this.nivel = 4;
        }
        if (xp >= 14000) {
            this.nivel = 5;
        }
        if (xp >= 23000) {
            this.nivel = 6;
        }
        if (xp >= 34000) {
            this.nivel = 7;
        }
        if (xp >= 48000) {
            this.nivel = 8;
        }
        if (xp >= 64000) {
            this.nivel = 9;
        }
        if (xp >= 85000) {
            this.nivel = 10;
        }
        if (i > this.nivel) {
            //Você diminuiu de nível"
            this.funcaoVidaMax();
            this.funcaoPoder();

        } else {
            if (i < this.nivel) {
                //Parabéns! Você subiu de nível
                this.funcaoVidaMax();
                this.funcaoPoder();
                this.recuperarVida(this.vidaMax);
            }
        }
    }

    protected void reduzirVida(int dano) {
        this.vidaAtual = this.vidaAtual - dano;
        if (this.vidaAtual <= 0) {
            morto = true;
            //Você perdeu o confronto
            perderXp(100);
            funcaoLvlUp();
        }
    }

    protected void recuperarVida(int recuperacao) {
        this.vidaAtual = this.vidaAtual + recuperacao;
        if (this.vidaAtual > this.vidaMax) {
            this.vidaAtual = this.vidaMax;
        }
    }

    protected int getVidaBase() {
        return this.vidaBase;
    }

    protected int getPoderBase() {
        return this.poderBase;
    }

    //não foi implementada ainda
    protected int usaConsumivel() {
        return 0;
    }

    protected boolean verificaMorto() {
        if (this.morto) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Deus{" + "nome=" + nome + ", descricao=" + descricao + ", vidaBase=" + vidaBase + ", nivel=" + nivel + ", poderBase=" + poderBase + '}';
    }
}
