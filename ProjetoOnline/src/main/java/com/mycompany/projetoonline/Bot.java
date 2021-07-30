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
        //só uma base de começo, tem muitas modificações que talvez sejam implementadas no futuro.
        //while esta sendo utilizado para manter o bot utilizando suas habilidades até que elas acabem.
        while (escolha <= 4 & escolha >= 1) {
            if (inimigo.verificaCarga(escolha)) {
                return inimigo.usarHabilidade(escolha);
            } else if (inimigo.verificaCarga(escolha)) {
                return inimigo.usarHabilidade(escolha);
            } else if (inimigo.verificaCarga(escolha)) {
                return inimigo.usarHabilidade(escolha);
            } else if (inimigo.verificaCarga(escolha)) {
                return inimigo.usarHabilidade(escolha);
            } else {
                escolha = (int) (1 + Math.random()*4);
            }
        }
        return 0;//exite para considerar a situação que todas cargas acabaram, assim mostra que ele não faz nada nesse caso.
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
