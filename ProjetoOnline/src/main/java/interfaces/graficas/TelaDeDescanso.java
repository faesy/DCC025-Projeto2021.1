/*
 * Falta conectar as Ações pra conseguir botar a barra de progresso pra representar a vida
 *
 */
package interfaces.graficas;

import classes.Jogador;
import classes.Progressao;
import classes.Salvar;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class TelaDeDescanso {
    
    final private ImageIcon imagem = new ImageIcon("./src/main/java/imagens/Acampamento.jpg");
    final private JButton continuar, editarHabilidades, descansar, sairESalvar;
    final private JProgressBar vida;
    final private JLabel txtVida;
    private JPanel tela;
    private JFrame janela;
    
    public TelaDeDescanso(Jogador jogador) {
        
        UIManager.put("Label.background", Color.white);
        UIManager.put("Label.foreground", Color.green);
        
        txtVida = new JLabel("Vida:");
        txtVida.setFont(new Font("Georgia", Font.BOLD, 20));
        
        
        UIManager.put("Button.background", Color.black);
        UIManager.put("Button.foreground", Color.white);
        
        this.continuar = new JButton("Avançar");
        this.continuar.setPreferredSize(new Dimension(100, 50));
        
        this.editarHabilidades = new JButton("Editar Habilidades");
        this.editarHabilidades.setPreferredSize(new Dimension(150, 30));
        
        this.descansar = new JButton("Descansar");
        this.descansar.setPreferredSize(new Dimension(100, 50));
        
        this.sairESalvar = new JButton("Sair e Salvar");
        this.sairESalvar.setPreferredSize(new Dimension(100, 50));
        
        UIManager.put("ProgressBar.background", Color.white);
        UIManager.put("ProgressBar.foreground", Color.green);
        UIManager.put("ProgressBar.selectionBackground", Color.green);
        UIManager.put("ProgressBar.selectionForeground", Color.black);
        
        this.vida = new JProgressBar(0, jogador.getDeus().getVidaMax());// tem q botar vita atual/vidaMax ali como parametro.
        this.vida.setPreferredSize(new Dimension(400, 35));
        this.vida.setStringPainted(true);
        this.vida.setValue(jogador.getDeus().getVidaAtual());
        
        this.continuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.setVisible(false);
                jogador.aumentaChaveDeProgresso();
                new Progressao(jogador);
                
            }
        });
        
        this.descansar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                jogador.getDeus().funcaoLvlUp();
                jogador.getDeus().descansar();
                janela.setVisible(false);
                new TelaDeDescanso(jogador);
            }
        });
        
        this.editarHabilidades.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.setVisible(false);
                new MenuHabilidades(jogador).criaJanela();
            }
        });
        
        this.sairESalvar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
              janela.setVisible(false); 
              new Salvar(jogador);
            }
        });
        
        this.criaJanela();
    }
    
    public void criaJanela() {
        
        janela = new JFrame();
        janela.setSize(940, 520);
        janela.setResizable(false);
        
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        
        posicionaComponentes();
        
        janela.add(this.tela);
        janela.setVisible(true);
        
    }
    
    private class ImagemFundo extends JPanel {
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image imagemFundo = imagem.getImage();
            g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
            
        }
    }
    
    private void posicionaComponentes() {// arrumar o layout

        ImagemFundo painel = new ImagemFundo();
        GridBagLayout layout = new GridBagLayout();
        painel.setLayout(layout);
        
        this.tela = new JPanel();
        this.tela = painel;
        
        GridBagConstraints colocaTxtVida = new GridBagConstraints();
        colocaTxtVida.gridx = 1;
        colocaTxtVida.gridy = 0;
        colocaTxtVida.insets = new Insets(0, 0, 0, 0);
        this.tela.add(this.txtVida, colocaTxtVida);
        
        GridBagConstraints colocaContinuar = new GridBagConstraints();// canto inferior direito
        colocaContinuar.gridx = 2;
        colocaContinuar.gridy = 3;
        colocaContinuar.insets = new Insets(0, 0, -360, 0);
        this.tela.add(this.continuar, colocaContinuar);
        
        GridBagConstraints colocaEditarHabilidade = new GridBagConstraints();// centro abaixo do descansar
        colocaEditarHabilidade.gridx = 1;
        colocaEditarHabilidade.gridy = 2;
        colocaEditarHabilidade.insets = new Insets(0, 0, -250, 0);
        this.tela.add(this.editarHabilidades, colocaEditarHabilidade);
        
        GridBagConstraints colocaDescansar = new GridBagConstraints();//centro debaixo da vida
        colocaDescansar.gridx = 1;
        colocaDescansar.gridy = 1;
        colocaDescansar.insets = new Insets(0, 0, -150, 0);
        this.tela.add(this.descansar, colocaDescansar);
        
        GridBagConstraints colocaSairESalvar = new GridBagConstraints();// canto inferior esquerdo
        colocaSairESalvar.gridx = 0;
        colocaSairESalvar.gridy = 3;
        colocaSairESalvar.insets = new Insets(0, 0, -360, 0);
        this.tela.add(this.sairESalvar, colocaSairESalvar);
        
        GridBagConstraints colocaVida = new GridBagConstraints();// centro
        colocaVida.gridx = 1;
        colocaVida.gridy = 1;
        colocaVida.insets = new Insets(0, 0, -50, 0);
        this.tela.add(this.vida, colocaVida);
        
    }
    
}
