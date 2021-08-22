package interfaces.graficas;

import classes.Jogador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import tratamento.eventos.CadastraJogador;
import tratamento.eventos.ChecaAcesso;
import tratamento.eventos.LogaJogador;
import classes.BancoDados;
import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import classes.Deus;
import classes.Habilidade;
import classes.Progressao;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathe
 */
public class EscolhadePersonagens implements BancoDados{
    
    final private ImageIcon zeus = new ImageIcon("./src/main/java/imagens/zeus.png");
    final private ImageIcon ra = new ImageIcon("./src/main/java/imagens/rá.png");
    final private ImageIcon skadi = new ImageIcon("./src/main/java/imagens/Skadi.png");
    final private JLabel jl1, jl2, jl3,titulo,jl4;
    final private JButton selzeus, selra, selskadi, confirmarzeus,confirmarra,confirmarskadi;
    private JFrame janela;
    private JPanel painel;
    private Jogador jogador;
    JSONObject bancoDados;
    JSONParser parser;
    private Deus deus=new Deus();
    
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
                if (deusAux.get("Nome").equals(deus.getNome())) {
                    existe = true;
                    deus.setNome(deusAux.get("Nome").toString());
                    deus.setDescricao(deusAux.get("Descricao").toString());
                    deus.setPoderBase(Integer.parseInt(deusAux.get("Poder Base").toString()));
                    deus.setVidaBase(Integer.parseInt(deusAux.get("Vida Base").toString()));
                    deus.setNivel(Integer.parseInt(deusAux.get("Nivel").toString()));
                    deus.setCaminhoIcone(deusAux.get("Diretorio").toString());
                    
                    JSONArray habilidades = (JSONArray) deusAux.get("Habilidades");
                    
                    Habilidade[] habilidade0 = new Habilidade[4];
                    for(i = 0; i < habilidades.size(); i++){
                        JSONObject habilidadeAux= (JSONObject) habilidades.get(i);
                        habilidade0[i] = new Habilidade();
                        habilidade0[i].setNome(habilidadeAux.get("Nome").toString());
                        habilidade0[i].setCarga(Integer.parseInt(habilidadeAux.get("Carga").toString()));
                        habilidade0[i].setDescricao(habilidadeAux.get("Descricao").toString());
                        habilidade0[i].setDano(Integer.parseInt(habilidadeAux.get("Dano").toString()));
                    }

                    deus.setHabilidades(habilidade0);
                }
            }    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscolhadePersonagens.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscolhadePersonagens.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(EscolhadePersonagens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public void criaJanela() {
        janela = new JFrame();
        janela.setSize(348, 288);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        posicionaComponentes();
        janela.add(painel);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selzeus.setBackground(Color.red);
        selra.setBackground(Color.red);
        selskadi.setBackground(Color.red);
        
        selzeus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selzeus.setBackground(Color.green);
                selra.setBackground(Color.red);
                selskadi.setBackground(Color.red);
                jl4.setFont(new Font("Georgia", Font.BOLD, 10));
                confirmarzeus.setVisible(true);
                confirmarra.setVisible(false);
                confirmarskadi.setVisible(false);
                
                
                deus.setNome("Zeus");
                manipulaJSON();
                jogador.setDeus(deus);
                jl4.setText("<html><body>Tipo: Eletricidade<br>Vida Inicial: "+deus.getVidaBase()+"<br>Poder Inicial: "+deus.getPoderBase()+"<br>Habilidade 1: "+deus.getHabilidades()[0].getNome()+"<br>Habilidade 2: "+deus.getHabilidades()[1].getNome()+"<br>Habilidade 3: "+deus.getHabilidades()[2].getNome()+"<br>Habilidade 4: "+deus.getHabilidades()[3].getNome()+"<br&gtcom HTML!</body></html>");
            }
        }); 
        
         selra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selzeus.setBackground(Color.red);
                selra.setBackground(Color.green);
                selskadi.setBackground(Color.red);
                confirmarzeus.setVisible(false);
                confirmarra.setVisible(true);
                confirmarskadi.setVisible(false);
                jl4.setFont(new Font("Georgia", Font.BOLD, 10));
                
                deus.setNome("Rá");
                manipulaJSON();
                jogador.setDeus(deus);
                jl4.setText("<html><body>Tipo: Fogo<br>Vida Inicial: "+deus.getVidaBase()+"<br>Poder Inicial: "+deus.getPoderBase()+"<br>Habilidade 1: "+deus.getHabilidades()[0].getNome()+"<br>Habilidade 2: "+deus.getHabilidades()[1].getNome()+"<br>Habilidade 3: "+deus.getHabilidades()[2].getNome()+"<br>Habilidade 4: "+deus.getHabilidades()[3].getNome()+"<br&gtcom HTML!</body></html>");
            }
        });
         
         selskadi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selzeus.setBackground(Color.red);
                selra.setBackground(Color.red);
                selskadi.setBackground(Color.green);
                confirmarzeus.setVisible(false);
                confirmarra.setVisible(false);
                confirmarskadi.setVisible(true);;
                jl4.setFont(new Font("Georgia", Font.BOLD, 10));
                
                deus.setNome("Skadi");
                manipulaJSON();
                jogador.setDeus(deus);
                jl4.setText("<html><body>Tipo: Gelo<br>Vida Inicial: "+deus.getVidaBase()+"<br>Poder Inicial: "+deus.getPoderBase()+"<br>Habilidade 1: "+deus.getHabilidades()[0].getNome()+"<br>Habilidade 2: "+deus.getHabilidades()[1].getNome()+"<br>Habilidade 3: "+deus.getHabilidades()[2].getNome()+"<br>Habilidade 4: "+deus.getHabilidades()[3].getNome()+"<br&gtcom HTML!</body></html>");
            }
        });
         
         confirmarzeus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogador.aumentaChaveDeProgresso();
                new Progressao(jogador);
                janela.setVisible(false);
            }
        });
         
         confirmarra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogador.aumentaChaveDeProgresso();
                new Progressao(jogador);
                janela.setVisible(false);
            }
        });
         
         confirmarskadi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogador.aumentaChaveDeProgresso();
                new Progressao(jogador);
                janela.setVisible(false);
            }
        });
        
    }
    
    public EscolhadePersonagens(Jogador JogadorAtual) {
        
        jogador=JogadorAtual;
        
        parser=new JSONParser();
       
        jl1 = new JLabel("");
        jl1.setIcon(zeus);

        jl2 = new JLabel("");
        jl2.setIcon(ra);
        
        jl3 = new JLabel("");
        jl3.setIcon(skadi);
        
        jl4 =new JLabel("");
        jl4.setBorder(BorderFactory.createLineBorder(Color.black));
        jl4.setPreferredSize(new Dimension(60, 100)); 
        
        titulo =new JLabel("Selecione o deus Inicial",JLabel.CENTER);
        titulo.setFont(new Font("Georgia", Font.BOLD, 20));

        selzeus = new JButton("Zeus");
        selra = new JButton("Rá");
        selskadi = new JButton("Skadi");
        confirmarzeus = new JButton("Confirmar");
        confirmarra = new JButton("Confirmar");
        confirmarskadi = new JButton("Confirmar");
        
        confirmarzeus.setVisible(false);
        confirmarra.setVisible(false);
        confirmarskadi.setVisible(false);
        
        this.criaJanela();

    }
    
 private void posicionaComponentes() {

        selzeus.setPreferredSize(new Dimension(84,24));
        selra.setPreferredSize(new Dimension(84,24));
        selskadi.setPreferredSize(new Dimension(84,24));
 
        painel = new JPanel();
        painel.setBackground(Color.white);
        GridBagLayout layout = new GridBagLayout();
        painel.setLayout(layout);
        GridBagConstraints pos = new GridBagConstraints();
        
        GridBagConstraints postitulo = new GridBagConstraints();
        postitulo.fill = GridBagConstraints.HORIZONTAL;
        postitulo.ipady = 40;      //make this component tall
        postitulo.weightx = 0;
        postitulo.gridwidth = 3;
        postitulo.gridy = 0;
        postitulo.gridx = 0;
        postitulo.insets = new Insets(-250,0,0,0);
        painel.add(titulo, postitulo);

        GridBagConstraints posimagenzeus = new GridBagConstraints();
        posimagenzeus.gridy = 1;
        posimagenzeus.gridx = 0;
        posimagenzeus.insets = new Insets(-120,0,0,0);
        painel.add(jl1, posimagenzeus);
        
        GridBagConstraints posimagenra = new GridBagConstraints();
        posimagenra.gridy = 1;
        posimagenra.gridx = 1;
        posimagenra.insets = new Insets(-120,0,0,0);
        painel.add(jl2, posimagenra);
        
        GridBagConstraints posimagenskadi = new GridBagConstraints();
        posimagenskadi.gridy = 1;
        posimagenskadi.gridx = 2;
        posimagenskadi.insets = new Insets(-120,0,0,0);
        painel.add(jl3, posimagenskadi);
        
        
        GridBagConstraints botselskadi = new GridBagConstraints();
        botselskadi.gridy = 2;
        botselskadi.gridx = 2;
        botselskadi.insets = new Insets(-20,5,0,5);
        painel.add(selskadi, botselskadi);
        
        GridBagConstraints botselzeus = new GridBagConstraints();
        botselzeus.gridy = 2;
        botselzeus.gridx = 0;
        botselzeus.insets = new Insets(-20,5,0,5);
        painel.add(selzeus, botselzeus);
        
        GridBagConstraints botselra = new GridBagConstraints();
        botselra.gridy = 2;
        botselra.gridx = 1;
        botselra.insets = new Insets(-20,5,0,5);
        painel.add(selra, botselra);
        
        GridBagConstraints botconfirmarzeus = new GridBagConstraints();
        botconfirmarzeus.gridy = 3;
        botconfirmarzeus.gridx = 2;
        botconfirmarzeus.insets = new Insets(0,0,-160,-30);
        painel.add(confirmarzeus, botconfirmarzeus);
        
        GridBagConstraints botconfirmarra = new GridBagConstraints();
        botconfirmarra.gridy = 3;
        botconfirmarra.gridx = 2;
        botconfirmarra.insets = new Insets(0,0,-160,-30);
        painel.add(confirmarra, botconfirmarra);
        
        GridBagConstraints botconfirmarskadi = new GridBagConstraints();
        botconfirmarskadi.gridy = 3;
        botconfirmarskadi.gridx = 2;
        botconfirmarskadi.insets = new Insets(0,0,-160,-30);
        painel.add(confirmarskadi, botconfirmarskadi);
        
        GridBagConstraints informacoes = new GridBagConstraints();
        informacoes.fill = GridBagConstraints.HORIZONTAL;   
        informacoes.weightx = 0;
        informacoes.gridwidth = 2;
        informacoes.gridy = 3;
        informacoes.gridx = 0;
        informacoes.insets = new Insets(0,0,-130,0);
        painel.add(jl4, informacoes);   
        
    }  
}
