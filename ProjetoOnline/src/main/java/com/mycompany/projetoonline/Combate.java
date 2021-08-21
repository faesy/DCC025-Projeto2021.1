/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetoonline;

import interfaces.graficas.InterfaceBatalha;

/**
 *
 * @author mathe
 */
public class Combate {
    
    public int Combate(Jogador personagem,Inimigo adversario){
        Deus heroi=personagem.deusEscolhido;
        
        while(heroi.vidaAtual<=0 && adversario.vidaAtual<= 0)
            {
            new InterfaceBatalha().criaJanela();
            }
        if(heroi.vidaAtual<=0){
        adversario.vidaAtual=adversario.getVidaBase();
        return 0;
        }
        else{
        adversario.vidaAtual=adversario.getVidaBase();
        return 1;
        }
        
    }
    
}
