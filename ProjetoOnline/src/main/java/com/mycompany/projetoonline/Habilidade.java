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
public class Habilidade {
    protected int carga;
    private int dano;
    protected int dano(int poder){
        return this.dano*poder;
    }
    private String descricao;
    private String nome;
    
    public Habilidade(String nome_,String descricao_, int dano_, int carga_){
        this.carga=carga_;
        this.dano=dano_;
        this.nome=nome_;
        this.descricao=descricao_;
        
    }
}
