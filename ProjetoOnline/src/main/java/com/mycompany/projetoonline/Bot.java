/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetoonline;

/**
 *
 * @author Usuario
 */
public class Bot {
     private Inimigo inimigo;
     private int modoDeJogo; // dificuldade: facil =1 // dificil =2 // pesadelo=3
     public Bot(){
         this.modoDeJogo = 1;
         novoInimigo();
         // inimigo.AlocarHabilidades(" vetor habilidade "); // sei como vai funcionar isso ainda n.
         
     }
     
     private int usaHabilidade(int escolha){
         // só um começo, tem q botar ainda se vai ter parametro ou se vai ocorrer alguma coisa dentro da propria classe
         if(inimigo.verificaSeTemCarga(escolha)){
             return inimigo.usarHabilidade(escolha);
         }else if(inimigo.verificaSeTemCarga(escolha)){
             return inimigo.usarHabilidade(escolha);
         }else if(inimigo.verificaSeTemCarga(escolha)){
            return  inimigo.usarHabilidade(escolha);
         }else if(inimigo.verificaSeTemCarga(escolha)){
            return  inimigo.usarHabilidade(escolha);
         }else{
             return 0;
         }
         
     
}
     private void novoInimigo(){
         this.inimigo = new Inimigo(this.modoDeJogo,"Inimigo");
     }
     
     private void retiraInimigo(){
         this.inimigo = null;
     }
     
     private void recebeAtaque(int danoRecebido){
         this.inimigo.manejaVida(danoRecebido);
         if(this.inimigo.verificaSeTaMorto()){
             retiraInimigo();
         }
     }
   
     
}

