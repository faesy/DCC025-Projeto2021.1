package interfaces.graficas;

import java.awt.*;
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
    final private JLabel jl1, jl2, jl3;
    final private JButton selzeus, selra, selskadi, confirmar;
    private JFrame janela;
    private JPanel painel;
    
    public EscolhadePersonagens() {

        jl1 = new JLabel("");
        jl1.setIcon(zeus);

        jl2 = new JLabel("");
        jl2.setIcon(ra);
        
        jl3 = new JLabel("");
        jl3.setIcon(skadi);

        selzeus = new JButton("Zeus");
        selra = new JButton("Rá");
        selskadi = new JButton("Skadi");
        confirmar = new JButton("Comfirmar");

    }
    
 private void posicionaComponentes() {
        painel = new JPanel();
        painel.setBackground(Color.black);
        GridBagLayout layout = new GridBagLayout();
        painel.setLayout(layout);
        GridBagConstraints pos = new GridBagConstraints();

        GridBagConstraints posimagenzeus = new GridBagConstraints();
        posimagenzeus.insets = new Insets(-120, -30, 50, 50);
        painel.add(jl1, posimagenzeus);
    }
        
          public void criaJanela() {
        JFrame janela = new JFrame();
        janela.setSize(290, 240);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        posicionaComponentes();
        janela.add(painel);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
  
    
}
