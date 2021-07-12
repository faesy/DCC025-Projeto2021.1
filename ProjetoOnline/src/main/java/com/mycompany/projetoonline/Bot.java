/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetoonline;

/**
 * Hiero Henrique Barcelos Costa -202065136A 
 * Matheus Cardoso Faesy - 202065065A
 * Thaís de Jesus Soares - 202065511B 
*
 */
public class Bot {
    
    //Atributos da classe Bot
    private Inimigo inimigo;
    private Inimigo boss;
    private int modoDeJogo; // dificuldade: facil =1 // dificil =2 // pesadelo=3

    //Métodos da classe Bot
    public Bot() {
        this.modoDeJogo = 1;
        novoInimigo();
        //ainda não foi implementado
        //inimigo.AlocarHabilidades(" vetor habilidade "); 

    }

    private int usaHabilidade(int escolha) {
        // só um começo, tem q botar ainda se vai ter parametro ou se vai ocorrer alguma coisa dentro da propria classe
        if (inimigo.verificaCarga(escolha)) {
            return inimigo.usarHabilidade(escolha);
        } else if (inimigo.verificaCarga(escolha)) {
            return inimigo.usarHabilidade(escolha);
        } else if (inimigo.verificaCarga(escolha)) {
            return inimigo.usarHabilidade(escolha);
        } else if (inimigo.verificaCarga(escolha)) {
            return inimigo.usarHabilidade(escolha);
        } else {
            return 0;
        }

    }

    private void novoInimigo() {
        this.inimigo = new Inimigo(this.modoDeJogo, "Inimigo");
    }

    private void retiraInimigo() {
        this.inimigo = null;
    }

    private void recebeAtaque(int danoRecebido) {
        this.inimigo.manejaVida(danoRecebido);
        if (this.inimigo.verificaMorto()) {
            retiraInimigo();
        }
    }

}
