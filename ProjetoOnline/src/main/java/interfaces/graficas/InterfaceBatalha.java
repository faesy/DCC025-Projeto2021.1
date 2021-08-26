/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.graficas;

import classes.BancoDados;
import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import classes.Bot;
import classes.Deus;
import classes.Habilidade;
import classes.Inimigo;
import classes.Jogador;
import classes.Progressao;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tratamento.eventos.CadastraJogador;
import tratamento.eventos.ChecaAcesso;
import tratamento.eventos.LogaJogador;

/**
 *
 * @author mathe
 */
public class InterfaceBatalha implements BancoDados {

    final private ImageIcon imagem = new ImageIcon("./src/main/java/imagens/fundobatalha.jpg");
    final private JLabel jl1, jl2, imagemInimigo, imagemPersonagem, separacao;
    final private JButton H1inimigo, H2inimigo, H3inimigo, H4inimigo, H1personagem, H2personagem, H3personagem, H4personagem, Consumivel, ConfirmarTurno;
    private JFrame janela;
    private JPanel painel;
    private Jogador jogador;
    private int acao = 0;

    JSONObject bancoDados;
    JSONParser parser;

    private Bot bot = new Bot();
    private Inimigo inimigo;

    private class ImagemFundo extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image imagemFundo = imagem.getImage();
            g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);

        }
    }

    @Override
    public void manipulaJSON() {
        try {
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject deuses = (JSONObject) bancoDadosArray.get(1);
            JSONArray deusesArray = (JSONArray) deuses.get("Deuses");
            boolean existe = false;
            for (int i = 0; i < deusesArray.size(); i++) {
                JSONObject deusAux = (JSONObject) deusesArray.get(i);
                if (deusAux.get("Nome").equals(inimigo.getNome())) {
                    existe = true;
                    inimigo.setDescricao(deusAux.get("Descricao").toString());
                    inimigo.setPoderBase(Integer.parseInt(deusAux.get("Poder Base").toString()));
                    inimigo.setVidaBase(Integer.parseInt(deusAux.get("Vida Base").toString()));
                    inimigo.setNivel(jogador.getDeus().getNivel());
                    inimigo.setCaminhoIcone(deusAux.get("Diretorio").toString());
                    inimigo.setTipo(deusAux.get("Tipo").toString());

                    JSONArray habilidades = (JSONArray) deusAux.get("Habilidades");

                    Habilidade[] habilidade0 = new Habilidade[4];
                    for (i = 0; i < habilidades.size(); i++) {
                        JSONObject habilidadeAux = (JSONObject) habilidades.get(i);
                        habilidade0[i] = new Habilidade();
                        habilidade0[i].setNome(habilidadeAux.get("Nome").toString());
                        habilidade0[i].setCarga(Integer.parseInt(habilidadeAux.get("Carga").toString()));
                        habilidade0[i].setDescricao(habilidadeAux.get("Descricao").toString());
                        habilidade0[i].setDano(Integer.parseInt(habilidadeAux.get("Dano").toString()));
                    }
                    inimigo.setHabilidades(habilidade0);
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterfaceBatalha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceBatalha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(InterfaceBatalha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public InterfaceBatalha(Jogador jogador, Bot bot) {

        UIManager.put("Button.background", Color.black);
        UIManager.put("Button.foreground", Color.white);

        this.bot = bot;

        this.jogador = jogador;

        parser = new JSONParser();

        this.inimigo = bot.getInimigo();

        ImageIcon enemi = new ImageIcon(bot.getInimigo().getCaminhoIcone());

        ImageIcon heroi = new ImageIcon(jogador.getDeus().getCaminhoIcone());

        UIManager.put("Label.foreground", Color.black);
        jl1 = new JLabel("<html><body><center>Nome: " + bot.getInimigo().getNome() + "<br><center>" + this.bot.getInimigo().getTipo() + "<br><center>Nivel: " + bot.getInimigo().getNivel() + "<br><center>Vida Restante: " + bot.getInimigo().getVidaAtual() + "<br&gtcom HTML!</body></html>", JLabel.CENTER);
        jl1.setFont(new Font("Georgia", Font.BOLD, 10));
        jl1.setOpaque(true);
        jl1.setBackground(Color.WHITE);
        jl1.setForeground(Color.black);

        jl2 = new JLabel("<html><body><center>Nome: " + jogador.getDeus().getNome() + "<br><center>" + jogador.getDeus().getTipo() + "<br><center>Nivel: " + jogador.getDeus().getNivel() + "<br><center>Vida Restante: " + jogador.getDeus().getVidaAtual() + "<br&gtcom HTML!</body></html>", JLabel.CENTER);
        jl2.setFont(new Font("Georgia", Font.BOLD, 10));
        jl2.setOpaque(true);
        jl2.setBackground(Color.WHITE);
        jl2.setForeground(Color.black);

        separacao = new JLabel("");

        imagemInimigo = new JLabel("");
        imagemInimigo.setIcon(enemi);

        imagemPersonagem = new JLabel("");
        imagemPersonagem.setIcon(heroi);

        H1inimigo = new JButton(bot.getInimigo().getHabilidades()[0].getNome());
        H2inimigo = new JButton(bot.getInimigo().getHabilidades()[1].getNome());
        H3inimigo = new JButton(bot.getInimigo().getHabilidades()[2].getNome());
        H4inimigo = new JButton(bot.getInimigo().getHabilidades()[3].getNome());

        H1inimigo.setEnabled(false);
        H2inimigo.setEnabled(false);
        H3inimigo.setEnabled(false);
        H4inimigo.setEnabled(false);

        H1personagem = new JButton(jogador.getDeus().getHabilidades()[0].getNome());
        H2personagem = new JButton(jogador.getDeus().getHabilidades()[1].getNome());
        H3personagem = new JButton(jogador.getDeus().getHabilidades()[2].getNome());
        H4personagem = new JButton(jogador.getDeus().getHabilidades()[3].getNome());

        Consumivel = new JButton("Elixir");

        ConfirmarTurno = new JButton("Confirmar Turno");
        ConfirmarTurno.setFont(new Font("Georgia", Font.BOLD, 12));

        this.criaJanela();
    }

    public InterfaceBatalha(Jogador jogador, String nomeAdversario) {

        UIManager.put("Button.background", Color.black);
        UIManager.put("Button.foreground", Color.white);
        UIManager.put("Label.foreground", Color.black);

        bot = new Bot();

        inimigo = new Inimigo();

        this.jogador = jogador;
        this.jogador.getDeus().funcaoVidaMax();
        this.jogador.getDeus().funcaoPoder();
        this.jogador.getDeus().setVidaAtual(this.jogador.getDeus().getVidaMax());

        parser = new JSONParser();

        inimigo.setNome(nomeAdversario);

        manipulaJSON();
        this.inimigo.funcaoPoder();
        this.inimigo.funcaoVidaMax();
        this.inimigo.setVidaAtual(this.inimigo.getVidaMax());
        bot.setInimigo(inimigo);

        ImageIcon enemi = new ImageIcon(bot.getInimigo().getCaminhoIcone());

        ImageIcon heroi = new ImageIcon(jogador.getDeus().getCaminhoIcone());

        jl1 = new JLabel("<html><body><center>Nome: " + bot.getInimigo().getNome() + "<br><center>" + this.bot.getInimigo().getTipo() + "<br><center>Nivel: " + bot.getInimigo().getNivel() + "<br><center>Vida Restante: " + bot.getInimigo().getVidaAtual() + "<br&gtcom HTML!</body></html>", JLabel.CENTER);
        jl1.setFont(new Font("Georgia", Font.BOLD, 10));
        jl1.setOpaque(true);
        jl1.setBackground(Color.WHITE);

        jl2 = new JLabel("<html><body><center>Nome: " + jogador.getDeus().getNome() + "<br><center>" + jogador.getDeus().getTipo() + "<br><center>Nivel: " + jogador.getDeus().getNivel() + "<br><center>Vida Restante: " + jogador.getDeus().getVidaAtual() + "<br&gtcom HTML!</body></html>", JLabel.CENTER);
        jl2.setFont(new Font("Georgia", Font.BOLD, 10));
        jl2.setOpaque(true);
        jl2.setBackground(Color.WHITE);

        separacao = new JLabel("");

        imagemInimigo = new JLabel("");
        imagemInimigo.setIcon(enemi);

        imagemPersonagem = new JLabel("");
        imagemPersonagem.setIcon(heroi);

        H1inimigo = new JButton(bot.getInimigo().getHabilidades()[0].getNome());
        H2inimigo = new JButton(bot.getInimigo().getHabilidades()[1].getNome());
        H3inimigo = new JButton(bot.getInimigo().getHabilidades()[2].getNome());
        H4inimigo = new JButton(bot.getInimigo().getHabilidades()[3].getNome());

        H1inimigo.setEnabled(false);
        H2inimigo.setEnabled(false);
        H3inimigo.setEnabled(false);
        H4inimigo.setEnabled(false);

        H1personagem = new JButton(jogador.getDeus().getHabilidades()[0].getNome());
        H2personagem = new JButton(jogador.getDeus().getHabilidades()[1].getNome());
        H3personagem = new JButton(jogador.getDeus().getHabilidades()[2].getNome());
        H4personagem = new JButton(jogador.getDeus().getHabilidades()[3].getNome());

        Consumivel = new JButton("Elixir");

        ConfirmarTurno = new JButton("Confirmar Turno");
        ConfirmarTurno.setFont(new Font("Georgia", Font.BOLD, 12));

        this.criaJanela();
    }

    public void criaJanela() {
        JFrame janela = new JFrame();
        janela.setSize(500, 500);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        posicionaComponentes();
        janela.add(painel);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        H1personagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                H1personagem.setBackground(Color.green);
                H2personagem.setBackground(Color.black);
                H3personagem.setBackground(Color.black);
                H4personagem.setBackground(Color.black);
                Consumivel.setBackground(Color.black);

                acao = 1;
            }
        });

        H2personagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                H1personagem.setBackground(Color.black);
                H2personagem.setBackground(Color.green);
                H3personagem.setBackground(Color.black);
                H4personagem.setBackground(Color.black);
                Consumivel.setBackground(Color.black);

                acao = 2;
            }
        });

        H3personagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                H1personagem.setBackground(Color.black);
                H2personagem.setBackground(Color.black);
                H3personagem.setBackground(Color.green);
                H4personagem.setBackground(Color.black);
                Consumivel.setBackground(Color.black);

                acao = 3;
            }
        });

        H4personagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                H1personagem.setBackground(Color.black);
                H2personagem.setBackground(Color.black);
                H3personagem.setBackground(Color.black);
                H4personagem.setBackground(Color.green);
                Consumivel.setBackground(Color.black);

                acao = 4;
            }
        });

        Consumivel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                H1personagem.setBackground(Color.black);
                H2personagem.setBackground(Color.black);
                H3personagem.setBackground(Color.black);
                H4personagem.setBackground(Color.black);
                Consumivel.setBackground(Color.green);

                acao = 5;
            }
        });

        ConfirmarTurno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (acao == 0) {

                } else {

                    janela.setVisible(false);
                    bot.getInimigo().reduzirVida((int) jogador.acao(acao));
                    jogador.getDeus().reduzirVida(bot.usaHabilidade());

                    if (jogador.getDeus().verificaMorto()) {
                        new GameOver(jogador);                        
                    } else {
                        if (bot.getInimigo().verificaMorto()) {
                            jogador.aumentaChaveDeProgresso();
                            new Progressao(jogador);
                        } else {
                            InterfaceBatalha c = new InterfaceBatalha(jogador, bot);
                        }
                    }

                }

            }
        });

    }

    private void posicionaComponentes() {

        ImagemFundo tela = new ImagemFundo();
        GridBagLayout layout = new GridBagLayout();
        tela.setLayout(layout);

        this.painel = new JPanel();
        this.painel = tela;

        H1inimigo.setPreferredSize(new Dimension(81, 45));
        H2inimigo.setPreferredSize(new Dimension(81, 45));
        H3inimigo.setPreferredSize(new Dimension(81, 45));
        H4inimigo.setPreferredSize(new Dimension(81, 45));

        H1personagem.setPreferredSize(new Dimension(81, 45));
        H2personagem.setPreferredSize(new Dimension(81, 45));
        H3personagem.setPreferredSize(new Dimension(81, 45));
        H4personagem.setPreferredSize(new Dimension(81, 45));

        Consumivel.setPreferredSize(new Dimension(70, 30));

        ConfirmarTurno.setPreferredSize(new Dimension(150, 30));

        jl1.setPreferredSize(new Dimension(150, 60));
        jl2.setPreferredSize(new Dimension(150, 60));
        //separacao.setPreferredSize(new Dimension(1, 80));

        GridBagConstraints pos = new GridBagConstraints();

        GridBagConstraints H1inimigo_ = new GridBagConstraints();
        H1inimigo_.gridy = 0;
        H1inimigo_.gridx = 1;
        H1inimigo_.insets = new Insets(-5, -5, 0, 0);
        painel.add(H1inimigo, H1inimigo_);

        GridBagConstraints H2inimigo_ = new GridBagConstraints();
        H2inimigo_.gridy = 0;
        H2inimigo_.gridx = 2;
        H2inimigo_.insets = new Insets(-5, 5, 0, 0);
        painel.add(H2inimigo, H2inimigo_);

        GridBagConstraints H3inimigo_ = new GridBagConstraints();
        H3inimigo_.gridy = 1;
        H3inimigo_.gridx = 1;
        H3inimigo_.insets = new Insets(5, -5, 0, 0);
        painel.add(H3inimigo, H3inimigo_);

        GridBagConstraints H4inimigo_ = new GridBagConstraints();
        H4inimigo_.gridy = 1;
        H4inimigo_.gridx = 2;
        H4inimigo_.insets = new Insets(5, 5, 0, 0);
        painel.add(H4inimigo, H4inimigo_);

        GridBagConstraints H1personagem_ = new GridBagConstraints();
        H1personagem_.gridy = 3;
        H1personagem_.gridx = 3;
        H1personagem_.insets = new Insets(-5, -5, 0, 0);
        painel.add(H1personagem, H1personagem_);

        GridBagConstraints H2personagem_ = new GridBagConstraints();
        H2personagem_.gridy = 3;
        H2personagem_.gridx = 4;
        H2personagem_.insets = new Insets(-5, 5, 0, 0);
        painel.add(H2personagem, H2personagem_);

        GridBagConstraints H3personagem_ = new GridBagConstraints();
        H3personagem_.gridy = 4;
        H3personagem_.gridx = 3;
        H3personagem_.insets = new Insets(5, -5, 0, 0);
        painel.add(H3personagem, H3personagem_);

        GridBagConstraints H4personagem_ = new GridBagConstraints();
        H4personagem_.gridy = 4;
        H4personagem_.gridx = 4;
        H4personagem_.insets = new Insets(5, 5, 0, 0);
        painel.add(H4personagem, H4personagem_);

        GridBagConstraints Consumivel_ = new GridBagConstraints();
        Consumivel_.gridwidth = 2;
        Consumivel_.gridheight = 2;
        Consumivel_.anchor = GridBagConstraints.CENTER;
        Consumivel_.gridy = 5;
        Consumivel_.gridx = 1;
        Consumivel_.insets = new Insets(15, -10, 0, 0);
        painel.add(Consumivel, Consumivel_);

        GridBagConstraints Finalizar_ = new GridBagConstraints();
        Finalizar_.gridwidth = 2;
        Consumivel_.gridheight = 2;
        Finalizar_.anchor = GridBagConstraints.CENTER;
        Finalizar_.gridy = 5;
        Finalizar_.gridx = 4;
        Finalizar_.insets = new Insets(45, -30, 0, 0);
        painel.add(ConfirmarTurno, Finalizar_);

//                
        GridBagConstraints iconeinimigo_ = new GridBagConstraints();
        iconeinimigo_.gridwidth = 2;
        iconeinimigo_.anchor = GridBagConstraints.CENTER;
        iconeinimigo_.gridy = 0;
        iconeinimigo_.gridx = 3;
        iconeinimigo_.insets = new Insets(0, 0, 0, 0);
        painel.add(imagemInimigo, iconeinimigo_);

        GridBagConstraints iconeperrsonagem_ = new GridBagConstraints();
        iconeperrsonagem_.gridwidth = 2;
        iconeinimigo_.anchor = GridBagConstraints.CENTER;
        iconeperrsonagem_.gridy = 3;
        iconeperrsonagem_.gridx = 1;
        iconeperrsonagem_.insets = new Insets(0, -9, 0, 0);
        painel.add(imagemPersonagem, iconeperrsonagem_);

        GridBagConstraints infInimigo_ = new GridBagConstraints();
        infInimigo_.gridwidth = 2;
        infInimigo_.gridy = 1;
        infInimigo_.gridx = 3;
        infInimigo_.insets = new Insets(0, 0, 0, 0);
        painel.add(jl1, infInimigo_);

        GridBagConstraints infPersonagem_ = new GridBagConstraints();
        infPersonagem_.gridwidth = GridBagConstraints.REMAINDER;
        infPersonagem_.gridy = 4;
        infPersonagem_.gridx = 0;
        infPersonagem_.anchor = GridBagConstraints.LINE_START;
        infPersonagem_.insets = new Insets(0, 0, 0, 0);
        painel.add(jl2, infPersonagem_);

        GridBagConstraints separacao_ = new GridBagConstraints();
        separacao_.gridwidth = 1;
        separacao_.gridy = 2;
        separacao_.gridx = 0;
        separacao_.ipady = 80;
        separacao_.insets = new Insets(0, 0, 0, 0);
        painel.add(separacao, separacao_);

    }

}
