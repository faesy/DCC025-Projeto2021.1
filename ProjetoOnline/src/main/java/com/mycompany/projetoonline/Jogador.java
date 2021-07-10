/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetoonline;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

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

    protected Jogador(String nome, String senha, boolean cadastrado, boolean logado) {
        this.deusEscolhido = deusEscolhido;
        this.nome = nome;
        this.senha = senha;
        this.cadastrado = cadastrado;
        this.logado = logado;
    }

    //o aperto do botão cadastrar retorna false para cadastrado e 
    //o do login retorna true, hipoteticamente
    //System.out.println foi usado para testar a implementação
    //a variavel deusEscolhido nao esta seno coniderada ainda
    public Jogador(boolean cadastrado_) {
        if (cadastrado_ == false) {
            System.out.println("Cadastrar");
            this.cadastrar();
        } else {
            System.out.println("Logar");
            this.logar();
        }
    }

    public void logar() {
        //armazena os valores digitados pelo usuário
        String nome_, senha_;
        System.out.println("Digite seu nome: ");
        Scanner teclado = new Scanner(System.in);
        nome_ = teclado.nextLine();
        System.out.println("Digite a senha: ");
        senha_ = teclado.nextLine();

        Map<String, Jogador> jogadores = Armazem.getJogadores();
        
        Jogador jogador = jogadores.get(nome_);

        if (jogador == null) {
            //usuario inexistente, faça o cadastro
            System.out.println("Cadastre-se");
            this.cadastrar();
        } else {
            this.logado = false;
            while (this.logado == false) {
                if (jogador.getSenha().equals(senha_)) {
                    this.logado = true;
                    this.nome = nome_;
                    this.senha = senha_;
                    this.cadastrado = true;
                    break;
                }
                else{
                //dados inválidos, tente novamente
                //armazena os dados digitados pelo usuario
                System.out.println("Digite seu nome: ");
                nome_ = teclado.nextLine();
                System.out.println("Digite a senha: ");
                senha_ = teclado.nextLine();
                jogador = jogadores.get(nome_);
                }
                
     
            }
            jogadores.remove(nome_);
            jogadores.put(this.nome,this);
            Armazem.atualizaJogadores(jogadores);
        }
    }
    

    public String getSenha() {
        return senha;
    }

    private void deslogar() {
        if(this.logado == true){
        Map<String, Jogador> jogadores = Armazem.getJogadores();
        
        Jogador jogador = jogadores.get(this.nome);
        jogadores.remove(this.nome);
        this.logado = false;
            jogadores.put(this.nome,this);
            Armazem.atualizaJogadores(jogadores);
        }
    }

    private void cadastrar() {
        //armazena os valores digitados pelo usuário
        String nome_, senha_;
        System.out.println("Digite seu nome: ");
        Scanner teclado = new Scanner(System.in);
        nome_ = teclado.nextLine();
        System.out.println("Digite a senha: ");
        senha_ = teclado.nextLine();

        Map<String, Jogador> jogadores = Armazem.getJogadores();
        Jogador jogador = jogadores.get(nome_);

        if (jogador == null) {
            this.nome = nome_;
            this.senha = senha_;
            this.cadastrado = true;
            selecionarDeus();
        }
        while (jogador != null) {
            //armazena os novos valores digitados pelo usuário
            System.out.println("Digite seu nome: ");
            nome_ = teclado.nextLine();
            System.out.println("Digite a senha: ");
            senha_ = teclado.nextLine();

            jogador = jogadores.get(nome_);

            if (jogador == null) {
                //não existe nenhum outro usuario com o mesmo nome
                this.nome = nome_;
                this.senha = senha_;
                this.cadastrado = true;
                this.selecionarDeus();
                break;
            }
        }
        if (cadastrado == true) {
            Armazem.escreveJogadores(this);
            jogadores = Armazem.getJogadores();
        }
    }

    public boolean isCadastrado() {
        return cadastrado;
    }

    public boolean isLogado() {
        return logado;
    }
    
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Jogador{" + "nome=" + nome + ", senha=" + senha + ", cadastrado=" + cadastrado + ", logado=" + logado + '}';
    }

    public static void main(String[] args) {
        Jogador j = new Jogador(true);
        j.deslogar();
    }
    
}
