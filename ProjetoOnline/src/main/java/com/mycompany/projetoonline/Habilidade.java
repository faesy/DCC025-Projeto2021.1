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
public class Habilidade {

    //Atributos da classe Habilidade
    protected int carga;
    private int dano;
    private String descricao;
    private String nome;

    //Métodos da classe Habilidade
    protected int dano(int poder) {
        return this.dano * poder;
    }

    public Habilidade(String nomer, String descricao, int dano, int carga) {
        this.carga = carga;
        this.dano = dano;
        this.nome = nomer;
        this.descricao = descricao;

    }
}
