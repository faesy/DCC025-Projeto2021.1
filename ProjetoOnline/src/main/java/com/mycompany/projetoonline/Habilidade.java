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

    public Habilidade(String nome_, String descricao_, int dano_, int carga_) {
        this.carga = carga_;
        this.dano = dano_;
        this.nome = nome_;
        this.descricao = descricao_;

    }
}
