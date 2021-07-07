/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

/**
 *
 * @author mathe
 */
public class Consumivel {
    protected int carga;
    protected int Tipo;//1 para recuperação de vida, 2 para aumento de poder//
    protected String nome;
    protected String descricao;
    protected int RecuperarVida(){
        return 0;
    }
    //implementar o aumento de poder é mais dificil pois precisaria de um "rélogio" interno no Deus que conte por quanto tempo esse aumento de poder vale
    protected int AumentarPoder(){
        return 0;
    }
    
}
