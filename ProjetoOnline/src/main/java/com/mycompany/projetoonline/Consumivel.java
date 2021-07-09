/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetoonline;

/**
 *
 * @author mathe
 */
public class Consumivel {

    protected int carga;
    protected int Tipo;//1 para recuperação de vida, 2 para aumento de poder//
    protected String nome;
    protected String descricao;

    protected Consumivel(int carga_, int Tipo_, String nome_) {
        if (Tipo_ == 1) {
            this.carga = 3;
        } else {
            this.carga = 1;
        }
    }

    protected int RecuperarVida(int intensidade, Deus c) {
        
        if (intensidade == 1) {
            return (int) (c.getVidaBaseDeus() * 0.15);
        } else if (intensidade == 2) {
            return (int) (c.getVidaBaseDeus() * 0.30);
        } else {
            return (int) (c.getVidaBaseDeus() * 0.45);
        }

    }

    //implementar o aumento de poder é mais dificil pois precisaria de um "rélogio" interno no Deus que conte por quanto tempo esse aumento de poder vale
    protected int AumentarPoder(int intensidade, Deus c) {
        
        if (intensidade == 1) {
            return (int) (c.getPoderBaseDeus() * 0.10);
        } else if (intensidade == 2) {
            return (int) (c.getPoderBaseDeus() * 0.20);
        } else {
            return (int) (c.getPoderBaseDeus() * 0.30);
        }
    }

}
