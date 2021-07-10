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

    protected Deus deusEscolhido;
    private String nome;
    private String senha;
    private boolean cadastrado;
    private boolean logado;
    private Consumivel[] consumiveisEquipados = new Consumivel[3];

    public void menuEscolhas() {

    }

    public void menuCombate() {

    }

    private void escolherHablidade() {

    }

    private int usaHabilidade() {
        // só um começo, tem q botar ainda se vai ter parametro ou se vai ocorrer alguma coisa dentro da propria classe
        /* ta comentado pq ainda n conseguimos fazer o arquivo com os bagulho.
         if(Deus.verificaSeTemCarga(1)){
             return Deus.usarHabilidade(1);
         }else if(Deus.verificaSeTemCarga(2)){
             return Deus.usarHabilidade(2);
         }else if(Deus.verificaSeTemCarga(3)){
            return  Deus.usarHabilidade(3);
         }else if(Deus.verificaSeTemCarga(4)){
            return  Deus.usarHabilidade(4);
         }else{
             return 0;
         }*/
        return 0;
    }

    private void escolherConsumivel() {

    }

    private void selecionarDeus() {
        /*  if("nome do deus" == "botao igual nome do deus"){
             this.deusEscolhido = new Deus("vem do arquivo");
         }else{
             this.deusEscolhido = new Deus("vem do arquivo");
         }*/

    }

    public Jogador(String nome, String senha,Deus deusEscolhido, boolean cadastrado, boolean logado) {
        this.deusEscolhido = deusEscolhido;
        this.nome = nome;
        this.senha = senha;
        this.cadastrado = cadastrado;
        this.logado = logado;
    }

    
    public Jogador() {
        if (this.cadastrado == false) {
            //Realize o Cadastro
            this.cadastrar();
        } else {
            //cadastrar();
            // bota um bagui pra voltar pra tela inicial. ou só transforma o if em um while e dps continua.
            //Realize o Login
            String nomeDigitado = "0";
            String senhaDigitada = "0";
            if (this.verificarLogin(nomeDigitado, senhaDigitada)) {
                this.logado = true;
            }
        }
    }

    private void deslogar() {
        this.logado = false;
    }

    private void cadastrar() {

        this.selecionarDeus();
    }

    private boolean verificarLogin(String nomeDigitado, String senhaDigitada) {
        return false;
    }
}
