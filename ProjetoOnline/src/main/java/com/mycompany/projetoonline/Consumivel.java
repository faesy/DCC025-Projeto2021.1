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
 * Hiero Henrique Barcelos Costa -202065136A 
 * Matheus Cardoso Faesy - 202065065A
 * Thaís de Jesus Soares - 202065511B 
*
 */
public class Consumivel {

    //Atributos da Classe Consumivel
    protected int carga;
    protected int tipo;             //1 para recuperação de vida, 2 para aumento de poder//
    protected String nome;
    protected String descricao;

    //Metodos da classe
    protected Consumivel(int tipo) {
        if (tipo != 1 && tipo != 2) {
            //Tipo de Consumível Inválido!
        } else if (tipo == 1) {
            this.carga = 3;
            this.nome = "Poção de cura";
            this.descricao = "Recupera Vida";
        } else {
            this.carga = 1;
            this.nome = "Poção de poder";
            this.descricao = "Aumenta poder";
        }
    }

    protected int recuperarVida(int intensidade, Deus c) {
        if (this.tipo == 1 && this.carga > 0) {
            this.carga -= 1;
            if (intensidade == 1) {
                return (int) (c.getVidaBase() * 0.15);
            } else if (intensidade == 2) {
                return (int) (c.getVidaBase() * 0.30);
            } else {
                return (int) (c.getVidaBase() * 0.45);
            }
        }
        return 0;
    }

    //implementar o aumento de poder é mais dificil pois precisaria de um "rélogio"
    //interno no Deus que conte por quanto tempo esse aumento de poder vale
    protected int AumentarPoder(int intensidade, Deus c) {
        if (this.tipo == 2 && this.carga > 0) {
            this.carga -= 1;
            if (intensidade == 1) {
                return (int) (c.getPoderBase() * 0.10);
            } else if (intensidade == 2) {
                return (int) (c.getPoderBase() * 0.20);
            } else {
                return (int) (c.getPoderBase() * 0.30);
            }
        }
        return 0;
    }

}
