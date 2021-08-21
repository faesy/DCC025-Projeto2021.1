/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.graficas;

import com.mycompany.projetoonline.Deus;
import com.mycompany.projetoonline.Inimigo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import tratamento.eventos.CadastraJogador;
import tratamento.eventos.ChecaAcesso;
import tratamento.eventos.LogaJogador;


/**
 *
 * @author mathe
 */
public class InterfaceBatalha {
   
    final private JLabel jl1, jl2,imagemInimigo,imagemPersonagem,separacao;
    final private JButton H1inimigo,H2inimigo,H3inimigo,H4inimigo,H1personagem,H2personagem,H3personagem,H4personagem,Consumivel,ConfirmarTurno;
    private JFrame janela;
    private JPanel painel;
    
    public InterfaceBatalha(/*Deus personagem, Inimigo oponente*/) {
        
        ImageIcon inimigo = new ImageIcon("./src/main/java/imagens/Odin.png");
        
        ImageIcon heroi = new ImageIcon("./src/main/java/imagens/Odin.png");
        
        jl1= new JLabel("<html><body><center>NOME<br><center>TIPO<br><center>NIVEL<br><center>PV: VIDA<br&gtcom HTML!</body></html>",JLabel.CENTER);
        jl1.setFont(new Font("Georgia", Font.BOLD, 10));
        
        jl2=new JLabel ("<html><body><center>NOME<br><center>TIPO<br><center>NIVEL<br><center>PV: VIDA<br&gtcom HTML!</body></html>",JLabel.CENTER);
        jl2.setFont(new Font("Georgia", Font.BOLD, 10));
        
        separacao = new JLabel("");
        
        imagemInimigo = new JLabel("");
        imagemInimigo.setIcon(inimigo);

        imagemPersonagem = new JLabel("");
        imagemPersonagem.setIcon(heroi);

        H1inimigo = new JButton("");
        H2inimigo = new JButton("");
        H3inimigo = new JButton("");
        H4inimigo = new JButton("");
        
        H1personagem = new JButton("");
        H2personagem = new JButton("");
        H3personagem = new JButton("");
        H4personagem = new JButton("");

        Consumivel = new JButton("Elixir");

        ConfirmarTurno = new JButton("Confirmar Turno");
        ConfirmarTurno.setFont(new Font("Georgia", Font.BOLD, 12));
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

       
}
     private void posicionaComponentes() {
         
         H1inimigo.setPreferredSize(new Dimension(81,45));
         H2inimigo.setPreferredSize(new Dimension(81,45));
         H3inimigo.setPreferredSize(new Dimension(81,45));
         H4inimigo.setPreferredSize(new Dimension(81,45));
         
         H1personagem.setPreferredSize(new Dimension(81,45));
         H2personagem.setPreferredSize(new Dimension(81,45));
         H3personagem.setPreferredSize(new Dimension(81,45));
         H4personagem.setPreferredSize(new Dimension(81,45));
         
         Consumivel.setPreferredSize(new Dimension(70,30));
         
         ConfirmarTurno.setPreferredSize(new Dimension(150,30));
         
         jl1.setPreferredSize(new Dimension(150, 60));
         jl2.setPreferredSize(new Dimension(150, 60));
         //separacao.setPreferredSize(new Dimension(1, 80));
         
         painel = new JPanel();
        painel.setBackground(Color.white);
        GridBagLayout layout = new GridBagLayout();
        painel.setLayout(layout);
        GridBagConstraints pos = new GridBagConstraints();
        
        GridBagConstraints  H1inimigo_= new GridBagConstraints();
        H1inimigo_.gridy = 0;
        H1inimigo_.gridx = 1;
        H1inimigo_.insets = new Insets(-5,-5,0,0);
        painel.add(H1inimigo, H1inimigo_);
        
        GridBagConstraints  H2inimigo_= new GridBagConstraints();
        H2inimigo_.gridy = 0;
        H2inimigo_.gridx = 2;
        H2inimigo_.insets = new Insets(-5,5,0,0);
        painel.add(H2inimigo, H2inimigo_);
        
        GridBagConstraints  H3inimigo_= new GridBagConstraints();
        H3inimigo_.gridy = 1;
        H3inimigo_.gridx = 1;
        H3inimigo_.insets = new Insets(5,-5,0,0);
        painel.add(H3inimigo, H3inimigo_);
        
        GridBagConstraints  H4inimigo_= new GridBagConstraints();
        H4inimigo_.gridy = 1;
        H4inimigo_.gridx = 2;
        H4inimigo_.insets = new Insets(5,5,0,0);
        painel.add(H4inimigo, H4inimigo_);
        
        
        
        GridBagConstraints  H1personagem_= new GridBagConstraints();
        H1personagem_.gridy = 3;
        H1personagem_.gridx = 3;
        H1personagem_.insets = new Insets(-5,-5,0,0);
        painel.add(H1personagem, H1personagem_);
        
        GridBagConstraints  H2personagem_= new GridBagConstraints();
        H2personagem_.gridy = 3;
        H2personagem_.gridx = 4;
        H2personagem_.insets = new Insets(-5,5,0,0);
        painel.add(H2personagem, H2personagem_);
        
        GridBagConstraints  H3personagem_= new GridBagConstraints();
        H3personagem_.gridy = 4;
        H3personagem_.gridx = 3;
        H3personagem_.insets = new Insets(5,-5,0,0);
        painel.add(H3personagem, H3personagem_);
        
        GridBagConstraints  H4personagem_= new GridBagConstraints();
        H4personagem_.gridy = 4;
        H4personagem_.gridx = 4;
        H4personagem_.insets = new Insets(5,5,0,0);
        painel.add(H4personagem, H4personagem_);
        
        GridBagConstraints  Consumivel_= new GridBagConstraints();
        Consumivel_.gridwidth = 2;
        Consumivel_.gridheight = 2;
        Consumivel_.anchor = GridBagConstraints.CENTER;
        Consumivel_.gridy = 5;
        Consumivel_.gridx = 1;
        Consumivel_.insets = new Insets(15,-10,0,0);
        painel.add(Consumivel, Consumivel_);
        
        GridBagConstraints  Finalizar_= new GridBagConstraints();
        Finalizar_.gridwidth = 2;
        Consumivel_.gridheight = 2;
        Finalizar_.anchor = GridBagConstraints.CENTER;
        Finalizar_.gridy = 5;
        Finalizar_.gridx = 4;
        Finalizar_.insets = new Insets(45,-30,0,0);
        painel.add(ConfirmarTurno, Finalizar_);
        
        
        
//                
        GridBagConstraints  iconeinimigo_= new GridBagConstraints();
        iconeinimigo_.gridwidth = 2;
        iconeinimigo_.anchor = GridBagConstraints.CENTER;
        iconeinimigo_.gridy = 0;
        iconeinimigo_.gridx = 3;
        iconeinimigo_.insets = new Insets(0,0,0,0);
        painel.add(imagemInimigo, iconeinimigo_);
        
        GridBagConstraints  iconeperrsonagem_= new GridBagConstraints();
        iconeperrsonagem_.gridwidth = 2;
        iconeinimigo_.anchor = GridBagConstraints.CENTER;
        iconeperrsonagem_.gridy = 3;
        iconeperrsonagem_.gridx = 1;
        iconeperrsonagem_.insets = new Insets(0,-9,0,0);
        painel.add(imagemPersonagem, iconeperrsonagem_);
        
        GridBagConstraints  infInimigo_= new GridBagConstraints();
        infInimigo_.gridwidth = 2;
        infInimigo_.gridy = 1;
        infInimigo_.gridx = 3;
        infInimigo_.insets = new Insets(0,0,0,0);
        painel.add(jl1, infInimigo_);
        
        GridBagConstraints  infPersonagem_= new GridBagConstraints();
        infPersonagem_.gridwidth = GridBagConstraints.REMAINDER;
        infPersonagem_.gridy = 4;
        infPersonagem_.gridx = 0;
        infPersonagem_.anchor=GridBagConstraints.LINE_START;
        infPersonagem_.insets = new Insets(0,0,0,0);
        painel.add(jl2, infPersonagem_);
        
        
        
        GridBagConstraints  separacao_= new GridBagConstraints();
        separacao_.gridwidth = 1;
        separacao_.gridy = 2;
        separacao_.gridx = 0;
        separacao_.ipady = 80;
        separacao_.insets = new Insets(0,0,0,0);
        painel.add(separacao,separacao_ );
        
     }

}
