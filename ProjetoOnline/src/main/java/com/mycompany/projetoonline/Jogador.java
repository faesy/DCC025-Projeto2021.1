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
public class Jogador {
    protected Deus DeusEscolhido;
    private String nome;
    private String Senha;
    private boolean cadastrado;
    private boolean logado;
    private Consumivel[] ConsumiveisEquipados=new Consumivel[3];
     
     public void MenuDeEscolhas(){
         
     }
     public void MenuDeCombate(){
         
     }
     private void EscolherHablidade(){
         
     }
     private void EscolherConsumivel(){
         
     }
     private void SelecionarDeus(){
         
     }
     public Jogador(){
        if (this.cadastrado==true){
                 //Realize o Cadastro
                 this.Cadastrar();
         }
        else{
            //Realize o Login
            String nomeDigitado="0";
            String senhaDigitada="0";
            if(this.VerificarLogin(nomeDigitado, senhaDigitada)){
                this.logado=true;
            }
        }
     }
     
     private void Deslogar(){
         this.logado=false;
     }
             
     private void Cadastrar(){
         
         
         
         this.SelecionarDeus();
     }
     private boolean VerificarLogin(String nomeDigitado,String senhaDigitada){
         
     }
}
