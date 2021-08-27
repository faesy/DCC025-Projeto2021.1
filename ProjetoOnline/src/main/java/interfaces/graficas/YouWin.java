/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.graficas;

import classes.Jogador;
import classes.Progressao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author Usuario
 */
public class YouWin {

    final private ImageIcon imagem = new ImageIcon("./src/main/java/imagens/YouWin.jpg");
    final private JButton reiniciar, sair;
    private JPanel tela;
    private JFrame janela;

    public YouWin(Jogador jogador) {

        UIManager.put("Button.background", Color.black);
        UIManager.put("Button.foreground", Color.white);

        this.reiniciar = new JButton("Reiniciar");
        this.reiniciar.setPreferredSize(new Dimension(100, 50));

        this.sair = new JButton("Sair");
        this.sair.setPreferredSize(new Dimension(100, 50));

        this.reiniciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                janela.setVisible(false);
                jogador.setChaveProgresso(0);
                new Progressao(jogador);

            }

        });
        this.sair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                janela.setVisible(false);
                
                Progressao.reiniciarProgresso(jogador);
                jogador.setChaveProgresso(-1);
                new Progressao(jogador);

            }

        });

        criaJanela();
    }

    private class ImagemFundo extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image imagemFundo = imagem.getImage();
            g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);

        }
    }

    private void criaJanela() {

        janela = new JFrame();
        janela.setSize(940, 520);
        janela.setResizable(false);

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        posicionaComponentes();

        janela.add(this.tela);
        janela.setVisible(true);

    }

    private void posicionaComponentes() {// arrumar o layout

        ImagemFundo painel = new ImagemFundo();
        GridBagLayout layout = new GridBagLayout();
        painel.setLayout(layout);

        this.tela = new JPanel();
        this.tela = painel;

        GridBagConstraints colocaReiniciar = new GridBagConstraints();// canto inferior esquerdo
        colocaReiniciar.gridx = 0;
        colocaReiniciar.insets = new Insets(0, 0, -360, 0);
        this.tela.add(this.reiniciar, colocaReiniciar);

        GridBagConstraints colocaSair = new GridBagConstraints();// canto inferior esquerdo
        colocaSair.gridx = 1;
        colocaSair.insets = new Insets(0, 0, -360, 0);
        this.tela.add(this.sair, colocaSair);
    }

}
