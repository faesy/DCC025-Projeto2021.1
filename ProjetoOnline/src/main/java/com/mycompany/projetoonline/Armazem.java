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
 *
 * @author Thaís
*/

public class Armazem {
    
    protected static Map<String, Deus> deuses = new HashMap<>();
    protected static Map<String, Habilidade> habilidades = new HashMap<>();
    protected static Map<String, Jogador> jogadores = new HashMap<>();

    //Escreve no arquivo deuses.txt
    public static void escreveDeuses() {

        //Instancia objeto do tipo File
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Deuses.txt");

        try {
            //Checa se o arquivo existe e senão o cria
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            //construtor que recebe como primeiro argumento o objeto do tipo arquivo e como segundo se o conteúdo será acrescentado
            //ao invés de ser substituído (append)
            FileWriter fw = new FileWriter(arquivo, true);
            //construtor recebe como argumento o objeto do tipo FileWriter
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
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

        //Instancia objeto do tipo File
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Habilidades.txt");

        try {
            //Checa se o arquivo existe e senão o cria
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            //construtor que recebe como primeiro argumento o objeto do tipo arquivo e como segundo se o conteúdo será acrescentado
            //ao invés de ser substituído (append)
            FileWriter fw = new FileWriter(arquivo, true);
            //construtor recebe como argumento o objeto do tipo FileWriter
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
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

    //Escreve no arquivo Jogadores.txt
    public static void escreveJogadores() {

        //Instancia objeto do tipo File
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Jogadores.txt");

        try {
            //Checa se o arquivo existe e senão o cria
            if (!arquivo.exists()) {
                System.out.println("Cria");
                arquivo.createNewFile();
            }
            //construtor que recebe como primeiro argumento o objeto do tipo arquivo e como segundo se o conteúdo será acrescentado
            //ao invés de ser substituído (append)
            FileWriter fw = new FileWriter(arquivo, true);
            //construtor recebe como argumento o objeto do tipo FileWriter
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
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

    public static void leDeuses() {
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Deuses.txt");
        try {
            if (arquivo.exists()) {
                //construtor que recebe o objeto do tipo arquivo
                FileReader fr = new FileReader(arquivo);
                //construtor que recebe o objeto do tipo FileReader
                BufferedReader br = new BufferedReader(fr);

                //enquanto houver mais linhas
                while (br.ready()) {
                    //readLine() -> lê a proxima linha
                    String nome = br.readLine();
                    String descricao = br.readLine();
                    int vidaBase = Integer.parseInt(br.readLine());
                    int poderBase = Integer.parseInt(br.readLine());
                    int nivel = Integer.parseInt(br.readLine());
                    //instancia objeto do tipo deus
                    Deus deus = new Deus(nome, descricao, vidaBase, poderBase, nivel);
                    //armazena o deus no dicionario deuses, passando como chave o nome do deus
                    deuses.put(nome, deus);
                    //imprime o objeto deus com chave nome
                    System.out.println(deuses.get(nome));
                }
                //fecha os recursos
                br.close();
                fr.close();
            } else {
                System.out.println("Arquivo não encontrado!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leHabilidades() {
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Habilidades.txt");
        try {
            if (arquivo.exists()) {
                FileReader fr = new FileReader(arquivo);
                BufferedReader br = new BufferedReader(fr);

                while (br.ready()) {
                    String nome = br.readLine();
                    String descricao = br.readLine();
                    int dano = Integer.parseInt(br.readLine());
                    int carga = Integer.parseInt(br.readLine());
                    Habilidade habilidade = new Habilidade(nome, descricao, dano, carga);
                    habilidades.put(nome, habilidade);
                    System.out.println(habilidades.get(nome));
                }
                br.close();
                fr.close();
            } else {
                System.out.println("Arquivo não encontrado!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leJogadores() {
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Jogadores.txt");
        try {
            if (arquivo.exists()) {
                FileReader fr = new FileReader(arquivo);
                BufferedReader br = new BufferedReader(fr);

                while (br.ready()) {
                    String nome = br.readLine();
                    String senha = br.readLine();
                    String deus = br.readLine();
                    boolean cadastrado = Boolean.parseBoolean(br.readLine());
                    boolean logado = Boolean.parseBoolean(br.readLine());
                    Jogador jogador = new Jogador(nome, senha, deuses.get(deus), cadastrado, logado);
                    //jogadores.put(nome, jogador);
                    //System.out.println(jogador.get(nome));
                }
                br.close();
                fr.close();
            } else {
                System.out.println("Arquivo não existe!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        //leDeuses();
        //leHabilidades();
        //leJogadores();
        //escreveJogadores();
        escreveDeuses();
    }
    
}

