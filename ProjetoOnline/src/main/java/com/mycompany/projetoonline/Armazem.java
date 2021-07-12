/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetoonline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

/**
 * Hiero Henrique Barcelos Costa -202065136A 
 * Matheus Cardoso Faesy - 202065065A
 * Thaís de Jesus Soares - 202065511B 
*
 */
public class Armazem {

    //Declaração das estruturas estáticas que vão armazenar os dados do programa.
    private static Map<String, Deus> deuses = new HashMap<>();
    private static Map<String, Habilidade> habilidades = new HashMap<>();
    private static Map<String, Jogador> jogadores = new HashMap<>();

    //Escreve no arquivo deuses.txt
    public static void escreveDeuses() {

        //Instancia objeto do tipo File passando o caminho relativo até o arquivo que se deseja manipular
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Deuses.txt");

        //Estrutura try{...}catch(..){} trata possivel exceção
        try {
            //Checa se o arquivo existe e senão o cria
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            //construtor que recebe como primeiro argumento o objeto do tipo arquivo e como segundo se o conteúdo será acrescentado
            //ao final do arquivo ao invés de substituir o já existente
            FileWriter fw = new FileWriter(arquivo, true);
            //construtor recebe como argumento o objeto do tipo FileWriter
            BufferedWriter bw = new BufferedWriter(fw);
            //escreve no arquivo
            bw.write("Escreve no arquivo");
            //quebra de linha
            bw.newLine();
            //fecha os recursos
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Escreve no arquivo Habilidades.txt
    public static void escreveHabilidades() {

        //Instancia objeto do tipo File passando o caminho relativo até o arquivo que se deseja manipular
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Habilidades.txt");
        //Estrutura try{...}catch(..){} trata possivel exceção
        try {
            //Checa se o arquivo existe e senão o cria
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            //construtor que recebe como primeiro argumento o objeto do tipo arquivo e como segundo se o conteúdo será acrescentado
            //ao final do arquivo ao invés de substituir o já existente
            FileWriter fw = new FileWriter(arquivo, true);
            //construtor recebe como argumento o objeto do tipo FileWriter
            BufferedWriter bw = new BufferedWriter(fw);
            //escreve no arquivo
            bw.write("Escreve no arquivo");
            //quebra de linha
            bw.newLine();
            //fecha os recursos
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Escreve no arquivo Jogadores.txt sem receber nenhum argumento
    public static void escreveJogadores() {

        //Instancia objeto do tipo File passando o caminho relativo até o arquivo que se deseja manipular
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Jogadores.txt");
        //Estrutura try{...}catch(..){} trata possivel exceção
        try {
            //Checa se o arquivo existe e senão o cria
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            //construtor que recebe como primeiro argumento o objeto do tipo arquivo e como segundo se o conteúdo será acrescentado
            //ao final do arquivo ao invés de substituir o já existente
            FileWriter fw = new FileWriter(arquivo, true);
            //construtor recebe como argumento o objeto do tipo FileWriter
            BufferedWriter bw = new BufferedWriter(fw);
            //escreve no arquivo
            bw.write("Escreve no arquivo");
            //quebra de linha
            bw.newLine();
            //fecha os recursos
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Escreve no arquivo Jogadores.txt recebendo como parametro um objeto da classe Jogador
    public static void escreveJogadores(Jogador j) {

        //Instancia objeto do tipo File passando o caminho relativo até o arquivo que se deseja manipular
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Jogadores.txt");
        //Estrutura try{...}catch(..){} trata possivel exceção
        try {
            //Checa se o arquivo existe e senão o cria
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            //construtor que recebe como primeiro argumento o objeto do tipo arquivo e como segundo se o conteúdo será acrescentado
            //ao final do arquivo ao invés de substituir o já existente
            FileWriter fw = new FileWriter(arquivo, true);
            //construtor recebe como argumento o objeto do tipo FileWriter
            BufferedWriter bw = new BufferedWriter(fw);
            //escreve no arquivo o nome do jogador
            bw.write(j.getNome());
            //quebra de linha
            bw.newLine();
            //escreve no arquivo a senha do jogador
            bw.write(j.getSenha());
            //quebra de linha
            bw.newLine();
            //escreve no arquivo o nome do deus escolhido pelo jogador
            //bw.write(j.getDeusEscolhido().getNome());
            //quebra de linha
            //bw.newLine();

            //verifica sequencialmente se o jogador está cadastrado e logado no jogo
            //o resultado é escrito no arquivo como uma String, dado que tentativas 
            //de escreve-lo como boolean não tiveram sucesso
            if (j.isCadastrado()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            //quebra de linha
            bw.newLine();
            if (j.isLogado()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            //quebra de linha
            bw.newLine();

            //fecha os recursos
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Atualiza os dados dos jogadores contidos em um arquivo, através de jogadores_, estrutura
    //de tipo Map que vai conter os dados já atualizados
    public static void atualizaJogadores(Map<String, Jogador> jogadores_) {

        //Instancia objeto do tipo File passando o caminho relativo até o arquivo que se deseja manipular
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Jogadores.txt");
        //Estrutura try{...}catch(..){} trata possivel exceção
        try {
            //Checa se o arquivo existe. Caso a condição seja atendido, este é deletado e em 
            //seguida recriado vazio
            if (arquivo.exists()) {
                arquivo.delete();
                arquivo.createNewFile();
            }
            //construtor que recebe como primeiro argumento o objeto do tipo arquivo e como segundo se o conteúdo será acrescentado
            //ao final do arquivo ao invés de substituir o já existente
            FileWriter fw = new FileWriter(arquivo, true);
            //construtor recebe como argumento o objeto do tipo FileWriter
            BufferedWriter bw = new BufferedWriter(fw);
            //percorre todas as chaves contidas em jogadores_, escrevendo seus valores no arquivo Jogadores.txt
            for (String chave : jogadores_.keySet()) {
                //obtem os dados referenciados por uma dada chave
                Jogador jogador = jogadores_.get(chave);
                //chama a funcao escreveJogadores para escrever esses dados no arquivo
                escreveJogadores(jogador);
            }
            //Chama a funcao leJogadores para atualizar o atributo jogadores, com os novos dados inseridos no arquivo
            leJogadores();
            //fecha os recursos
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leDeuses() {
        //Instancia objeto do tipo File passando o caminho relativo até o arquivo que se deseja manipular
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Deuses.txt");
        //Estrutura try{...}catch(..){} trata possivel exceção
        try {
            //Checa se o arquivo existe e senão o cria
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            } else {
                //construtor que recebe como argumento o objeto do tipo arquivo 
                FileReader fr = new FileReader(arquivo);
                //construtor recebe como argumento o objeto do tipo FileWriter
                BufferedReader br = new BufferedReader(fr);
                //while() continua enquanto houver mais linhas
                while (br.ready()) {
                    //le os atributos de um deus do arquivo
                    String nome = br.readLine();
                    String descricao = br.readLine();
                    int vidaBase = Integer.parseInt(br.readLine());
                    int poderBase = Integer.parseInt(br.readLine());
                    int nivel = Integer.parseInt(br.readLine());
                    //cria um objeto deus com os atributos lidos
                    Deus deus = new Deus(nome, descricao, vidaBase, poderBase, nivel);
                    //insere o deus em deuses passando o nome deste como chave
                    deuses.put(nome, deus);
                }
                //fecha os recursos
                br.close();
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leHabilidades() {
        //Instancia objeto do tipo File passando o caminho relativo até o arquivo que se deseja manipular
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Habilidades.txt");
        //Estrutura try{...}catch(..){} trata possivel exceção
        try {
            //Checa se o arquivo existe e senão o cria
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            } else {
                //construtor que recebe como argumento o objeto do tipo arquivo
                FileReader fr = new FileReader(arquivo);
                //construtor recebe como argumento o objeto do tipo FileWriter
                BufferedReader br = new BufferedReader(fr);
                //while() continua enquanto houver mais linhas
                while (br.ready()) {
                    //le os atributos de uma habilidade do arquivo
                    String nome = br.readLine();
                    String descricao = br.readLine();
                    int dano = Integer.parseInt(br.readLine());
                    int carga = Integer.parseInt(br.readLine());
                    //cria um objeto habilidade com os atributos lidos
                    Habilidade habilidade = new Habilidade(nome, descricao, dano, carga);
                    //insere a habilidade em habilidade passando o nome desta como chave
                    habilidades.put(nome, habilidade);
                }
                //fecha os recursos
                br.close();
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leJogadores() {
        //Instancia objeto do tipo File passando o caminho relativo até o arquivo que se deseja manipular
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Jogadores.txt");
        //Estrutura try{...}catch(..){} trata possivel exceção
        try {
            //Checa se o arquivo existe e senão o cria
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            } else {
                //construtor que recebe como argumento o objeto do tipo arquivo
                FileReader fr = new FileReader(arquivo);
                //construtor recebe como argumento o objeto do tipo FileWriter
                BufferedReader br = new BufferedReader(fr);
                //while() continua enquanto houver mais linhas
                while (br.ready()) {
                    //le os atributos de um jogador do arquivo
                    String nome = br.readLine();
                    String senha = br.readLine();
                    //String deus = br.readLine();
                    boolean cadastrado = Boolean.parseBoolean(br.readLine());
                    boolean logado = Boolean.parseBoolean(br.readLine());
                    //cria um objeto habilidade com os atributos lidos
                    Jogador jogador = new Jogador(nome, senha, cadastrado, logado);
                    //insere a habilidade em habilidade passando o nome desta como chave
                    jogadores.put(nome, jogador);
                }
                //fecha os recursos
                br.close();
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Funcoes get -> retornam os atributos privatos da classe Armazem
    public static Map<String, Deus> getDeuses() {
        leDeuses();
        return deuses;
    }

    public static Map<String, Habilidade> getHabilidades() {
        leHabilidades();
        return habilidades;
    }

    public static Map<String, Jogador> getJogadores() {
        leJogadores();
        return jogadores;
    }
}
