/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Usuario
 */
public class Bot {

    //Atributos da classe Bot
    private Inimigo inimigo;
    //private int modoDeJogo; // dificuldade: facil =1 // dificil =2 // pesadelo=3

    //Métodos da classe Bot
    public Bot() {
         
    }

    public void setInimigo(Inimigo inimigo) {
        this.inimigo = inimigo;
       this.inimigo.funcaoPoder();
       this.inimigo.funcaoVidaMax();
       
    }

    public Inimigo getInimigo() {
        return inimigo;
    }

    public int usaHabilidade() {
        //só uma base de começo, tem muitas modificações que talvez sejam implementadas no futuro.
        //while esta sendo utilizado para manter o bot utilizando suas habilidades até que elas acabem.
        int escolha = (int) (1 + Math.random() * 4);
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
                escolha = (int) (1 + Math.random() * 4);
            }
        }
        return 0;//exite para considerar a situação que todas cargas acabaram, assim mostra que ele não faz nada nesse caso.
    }

    private void retiraInimigo() {
        this.inimigo = null;
    }

    private void recebeAtaque(int danoRecebido) {
        this.inimigo.reduzirVida(danoRecebido);
        if (this.inimigo.verificaMorto()) {
            retiraInimigo();
        }
    }

}

