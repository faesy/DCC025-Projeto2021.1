package interfaces.graficas;

import classes.Jogador;
import classes.Progressao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import tratamento.eventos.Proximo;

public class Historia {

    String mensagem;
    String caminhoIcone;
    JPanel painel;
    Jogador jogador;
    JButton proximo;

    public Historia(String mensagem,Jogador jogador) {
        this.jogador=jogador;
        this.mensagem = mensagem;
        this.caminhoIcone = "./src/main/java/imagens/Floresta.png";
        this.criaJanela();
    }

    public void criaJanela() {
        JFrame janela = new JFrame();
        janela.setSize(940, 520);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        posicionaComponentes();
        janela.add(painel);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        proximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.setVisible(false);
                jogador.aumentaChaveDeProgresso();
                new Progressao(jogador);
            }
        });
        
    }

    private void posicionaComponentes() {
        painel = new JPanel(new BorderLayout());

        JLabel compImagem = new JLabel();
        ImageIcon imagem = new ImageIcon(caminhoIcone);
        compImagem.setIcon(imagem);
        painel.add(compImagem, BorderLayout.NORTH);

        JTextArea texto = new JTextArea(6, 70);
        texto.setText("  " + mensagem);
        texto.setFont(new Font("Arial", Font.BOLD, 12));
        texto.setEditable(false);
        texto.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        JPanel painelAux = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        painelAux.setLayout(layout);
        GridBagConstraints pos = new GridBagConstraints();
        pos.gridx = 0;
        pos.gridy = 0;
        pos.insets = new Insets(0, 0, 0, 30);
        painelAux.add(texto, pos);
        painel.add(painelAux, BorderLayout.WEST);

        proximo = new JButton("Próximo");
        pos.gridx = 1;
        pos.gridy = 0;
        pos.insets = new Insets(0, 0, -70, 30);
        painelAux.add(proximo, pos);
        painel.add(painelAux, BorderLayout.EAST);
        painel.setBackground(new Color(21, 26, 34));
        painelAux.setBackground(new Color(21, 26, 34));
    }
}
