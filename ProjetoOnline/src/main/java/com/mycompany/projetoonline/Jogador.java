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
 * Hiero Henrique Barcelos Costa -202065136A 
 * Matheus Cardoso Faesy - 202065065A
 * Thaís de Jesus Soares - 202065511B 
*
 */
public class Jogador {

    //Atributos da classe Jogador
    protected Deus deusEscolhido;
    private String nome;
    private int final_;
    private int chave_Progresso;
    private String senha;
    private boolean cadastrado;
    private boolean logado;
    private Consumivel[] consumiveisEquipados = new Consumivel[2];

    //Funções a serem implementadas por interface gráfica
    public void menuEscolhas() {

    }

    public void menuCombate() {

    }

    private void escolherHablidade() {

    }

    private void escolherConsumivel() {

    }

    private void selecionarDeus() {
        /*  
        if("nome do deus" == "botao igual nome do deus"){
             this.deusEscolhido = new Deus("vem do arquivo");
         }else{
             //deus invalido, é quipado um deus padrão
             this.deusEscolhido = new Deus("vem do arquivo");
        }
         */

    }

    // só um começo, tem q botar ainda se vai ter parametro ou se vai ocorrer alguma coisa dentro da propria classe
    // encontra-se comentado porque os arquivos ainda não foram feitos
    private int usaHabilidade() {
        /*
         if(Deus.verificaCarga(1)){
             return Deus.usarHabilidade(1);
         }else if(Deus.verificaCarga(2)){
             return Deus.usarHabilidade(2);
         }else if(Deus.verificaCarga(3)){
            return  Deus.usarHabilidade(3);
         }else if(Deus.verificaCarga(4)){
            return  Deus.usarHabilidade(4);
         }else{
             return 0;
         }
         */
        return 0;
    }

    //contrutor utilizado para ler dados do arquivo, o deus não está sendo lido pois
    //essa parte ainda não foi implementada
    protected Jogador(String nome, String senha, boolean cadastrado, boolean logado) {
        //this.deusEscolhido = deusEscolhido;
        this.nome = nome;
        this.senha = senha;
        this.cadastrado = cadastrado;
        this.logado = logado;
    }

    //o aperto do botão cadastrar retorna false para cadastrado e 
    //o do login retorna true, hipoteticamente
    //System.out.println foi usado para testar a implementação
    //a variavel deusEscolhido nao esta sendo coniderada ainda
    public Jogador(boolean cadastrado) {
        if (cadastrado == false) {
            System.out.println("Cadastrar");
            this.cadastrar();
        } else {
            System.out.println("Logar");
            this.logar();
        }
    }

    public void logar() {
        //armazena os valores digitados pelo usuário
        String nome, senha;
        System.out.println("Digite seu nome: ");
        Scanner teclado = new Scanner(System.in);
        nome = teclado.nextLine();
        System.out.println("Digite a senha: ");
        senha = teclado.nextLine();

        //a esrrutura Map, jogadores, vai receber os dados dos jogadores já existentes
        Map<String, Jogador> jogadores = Armazem.getJogadores();
        //verifica se o jogador já esta cadastrado no jogo
        Jogador jogador = jogadores.get(nome);
        //se não estiver é pedido que esse se cadastre
        if (jogador == null) {
            //usuario inexistente, faça o cadastro
            System.out.println("Cadastre-se");
            this.cadastrar();
        } else {
            this.logado = false;
            while (this.logado == false) {
                //verifica se a senha informada é válida, se o for, atualiza nos dados do jogador
                //que este está logado e interrompe-se o laço
                if (jogador.getSenha().equals(senha)) {
                    this.logado = true;
                    this.nome = nome;
                    this.senha = senha;
                    this.cadastrado = true;
                    break;
                } //se a senha for inválida, é pedido que o jogador tente novamente
                else {
                    //armazena os dados digitados pelo usuario
                    System.out.println("Digite seu nome: ");
                    nome = teclado.nextLine();
                    System.out.println("Digite a senha: ");
                    senha = teclado.nextLine();
                    //verifica se o novo nome informado é válido
                    jogador = jogadores.get(nome);
                    //se não for é pedido que esse se cadastre
                    if (jogador == null) {
                        //usuario inexistente, faça o cadastro
                        System.out.println("Cadastre-se");
                        this.cadastrar();
                    }
                }
            }
            //remove o jogador com o nome informado pelo usuário da estrutura jogadores
            jogadores.remove(nome);
            //adiciona-o novamente, agora com this.logado == true
            jogadores.put(this.nome, this);
            //atualiza os dados no arquivo
            Armazem.atualizaJogadores(jogadores);
        }
    }

    private void deslogar() {
        //verifica se o jogador esta logado
        if (this.logado == true) {
            //recupera os dados dos jogadores do arquivo
            Map<String, Jogador> jogadores = Armazem.getJogadores();
            //procura o jogador no sistema
            Jogador jogador = jogadores.get(this.nome);
            //se este não estiver no sistema é dado como usuário inválido
            if (jogador == null) {
                //usuario inexistente, faça o cadastro
            } else {
                //o jogador é removido do arquivo
                jogadores.remove(this.nome);
                //seu valor para logado é atualizado
                this.logado = false;
                jogadores.put(this.nome, this);
                Armazem.atualizaJogadores(jogadores);
            }
        }
    }

    private void cadastrar() {
        //armazena os valores digitados pelo usuário
        String nome, senha;
        System.out.println("Digite seu nome: ");
        Scanner teclado = new Scanner(System.in);
        nome = teclado.nextLine();
        System.out.println("Digite a senha: ");
        senha = teclado.nextLine();
        //a esrrutura Map, jogadores, vai receber os dados dos jogadores já existentes
        Map<String, Jogador> jogadores = Armazem.getJogadores();
        //verifica se o jogador já esta cadastrado no jogo, se não estiver o cadastro é feito 
        //com sucesso
        Jogador jogador = jogadores.get(nome);
        if (jogador == null) {
            this.nome = nome;
            this.senha = senha;
            this.cadastrado = true;
            selecionarDeus();
        }
        //se já existir um usuário com o mesmo nome, pede que o usuário informe
        //novos dados
        while (jogador != null) {
            //armazena os novos valores digitados pelo usuário
            System.out.println("Digite seu nome: ");
            nome = teclado.nextLine();
            System.out.println("Digite a senha: ");
            senha = teclado.nextLine();

            jogador = jogadores.get(nome);
            //verifica se o jogador já esta cadastrado no jogo, se não estiver o cadastro é feito 
            //com sucesso
            if (jogador == null) {
                //não existe nenhum outro usuario com o mesmo nome
                this.nome = nome;
                this.senha = senha;
                this.cadastrado = true;
                this.selecionarDeus();
                break;
            }
        }
        //se o cadastro foi feito com sucesso, acrescenta-se os dados do jogador ao arquivo
        if (cadastrado == true) {
            Armazem.escreveJogadores(this);
            jogadores = Armazem.getJogadores();
        }
    }

    //funcoes get -> retornam os atributos do jogador
    public boolean isCadastrado() {
        return cadastrado;
    }

    public boolean isLogado() {
        return logado;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    //impressão padrão de um objeto Jogador
    @Override
    public String toString() {
        return "Jogador{" + "nome=" + nome + ", senha=" + senha + ", cadastrado=" + cadastrado + ", logado=" + logado + '}';
    }

    //main utilizada para testar a implementacao das funcoes cadastrar, logar e deslogar
    //é preciso adiciona a classe Jogador no pom como a classe principal para esse teste, visto que a atualmente configurada é 
    //a Jogo
    public static void main(String[] args) {
        Jogador j = new Jogador(true);
        j.deslogar();
    }

}
