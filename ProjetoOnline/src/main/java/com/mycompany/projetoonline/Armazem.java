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

    private static Map<String, Deus> deuses = new HashMap<>();
    private static Map<String, Habilidade> habilidades = new HashMap<>();
    private static Map<String, Jogador> jogadores = new HashMap<>();

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
    public static void escreveJogadores(Jogador j) {

        //Instancia objeto do tipo File
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Jogadores.txt");

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
            //escreve no arquivoth
            bw.write(j.getNome());
            //quebra de linha
            bw.newLine();
            bw.write(j.getSenha());
            bw.newLine();
            //bw.write(j.getDeusEscolhido().getNome());
            //bw.newLine();

            if (j.isCadastrado()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();
            if (j.isLogado()) {
                bw.write("true");
            } else {
                bw.write("false");
            }
            bw.newLine();

            //fecha os recursos
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void atualizaJogadores(Map<String, Jogador> jogadores_) {
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Jogadores.txt");
        try {
            if (arquivo.exists()) {
                arquivo.delete();
                arquivo.createNewFile();
            }
            FileWriter fw = new FileWriter(arquivo, true);
            //construtor recebe como argumento o objeto do tipo FileWriter
            BufferedWriter bw = new BufferedWriter(fw);
            //escreve no arquivo
            for (String chave : jogadores.keySet()) {
                Jogador jogador = jogadores.get(chave);
                escreveJogadores(jogador);
                leJogadores();
            }
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
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            } else {
                FileReader fr = new FileReader(arquivo);
                BufferedReader br = new BufferedReader(fr);

                while (br.ready()) {
                    String nome = br.readLine();
                    String descricao = br.readLine();
                    int vidaBase = Integer.parseInt(br.readLine());
                    int poderBase = Integer.parseInt(br.readLine());
                    int nivel = Integer.parseInt(br.readLine());
                    Deus deus = new Deus(nome, descricao, vidaBase, poderBase, nivel);
                    deuses.put(nome, deus);
                }
                br.close();
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leHabilidades() {
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Habilidades.txt");
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            } else {
                FileReader fr = new FileReader(arquivo);
                BufferedReader br = new BufferedReader(fr);

                while (br.ready()) {
                    String nome = br.readLine();
                    String descricao = br.readLine();
                    int dano = Integer.parseInt(br.readLine());
                    int carga = Integer.parseInt(br.readLine());
                    Habilidade habilidade = new Habilidade(nome, descricao, dano, carga);
                    habilidades.put(nome, habilidade);
                }
                br.close();
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leJogadores() {
        File arquivo = new File("./src/main/java/com/mycompany/projetoonline/Jogadores.txt");
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            } else {
                FileReader fr = new FileReader(arquivo);
                BufferedReader br = new BufferedReader(fr);

                while (br.ready()) {
                    String nome = br.readLine();
                    String senha = br.readLine();
                    //String deus = br.readLine();
                    boolean cadastrado = Boolean.parseBoolean(br.readLine());
                    boolean logado = Boolean.parseBoolean(br.readLine());
                    Jogador jogador = new Jogador(nome, senha, cadastrado, logado);
                    jogadores.put(nome, jogador);
                }
                br.close();
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
