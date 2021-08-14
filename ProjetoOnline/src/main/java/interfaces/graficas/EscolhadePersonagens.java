package interfaces.graficas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import tratamento.eventos.CadastraJogador;
import tratamento.eventos.ChecaAcesso;
import tratamento.eventos.LogaJogador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathe
 */
public class EscolhadePersonagens {
    
    final private ImageIcon zeus = new ImageIcon("./src/main/java/imagens/zeus.png");
    final private ImageIcon ra = new ImageIcon("./src/main/java/imagens/rá.png");
    final private ImageIcon skadi = new ImageIcon("./src/main/java/imagens/Skadi.png");
    final private JLabel jl1, jl2, jl3,titulo,jl4;
    final private JButton selzeus, selra, selskadi, confirmar;
    private JFrame janela;
    private JPanel painel;
    
       public void criaJanela() {
        JFrame janela = new JFrame();
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
                jl4.setText("<html><body>Tipo: Eletricidade<br>Vida Inicial: ---<br>Poder Inicial: ---<br>Habilidade 1: ---<br>Habilidade 2: ---<br>Habilidade 3: ---<br>Habilidade 4: ---<br&gtcom HTML!</body></html>");
            }
        }); 
        
         selra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selzeus.setBackground(Color.red);
                selra.setBackground(Color.green);
                selskadi.setBackground(Color.red);
                jl4.setFont(new Font("Georgia", Font.BOLD, 10));
                jl4.setText("<html><body>Tipo: Fogo<br>Vida Inicial: ---<br>Poder Inicial: ---<br>Habilidade 1: ---<br>Habilidade 2: ---<br>Habilidade 3: ---<br>Habilidade 4: ---<br&gtcom HTML!</body></html>");
            }
        });
         
         selskadi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selzeus.setBackground(Color.red);
                selra.setBackground(Color.red);
                selskadi.setBackground(Color.green);
                jl4.setFont(new Font("Georgia", Font.BOLD, 10));
                jl4.setText("<html><body>Tipo: Gelo<br>Vida Inicial: ---<br>Poder Inicial: ---<br>Habilidade 1: ---<br>Habilidade 2: ---<br>Habilidade 3: ---<br>Habilidade 4: ---<br&gtcom HTML!</body></html>");
            }
        });
        
    }
    
    public EscolhadePersonagens() {

        jl1 = new JLabel("");
        jl1.setIcon(zeus);

        jl2 = new JLabel("");
        jl2.setIcon(ra);
        
        jl3 = new JLabel("");
        jl3.setIcon(skadi);
        
        jl4 =new JLabel("");
        jl4.setBorder(BorderFactory.createLineBorder(Color.black));
        jl4.setPreferredSize(new Dimension(60, 100)); 
        jl4.setText("<html><body><br&gtcom HTML!</body></html>");
        
        titulo =new JLabel("Selecione o deus Inicial",JLabel.CENTER);
        titulo.setFont(new Font("Georgia", Font.BOLD, 20));

        selzeus = new JButton("Zeus");
        selra = new JButton("Rá");
        selskadi = new JButton("Skadi");
        confirmar = new JButton("Confirmar");

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
        
        GridBagConstraints botconfirmar = new GridBagConstraints();
        botconfirmar.gridy = 3;
        botconfirmar.gridx = 2;
        botconfirmar.insets = new Insets(0,0,-160,-30);
        painel.add(confirmar, botconfirmar);
        
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
