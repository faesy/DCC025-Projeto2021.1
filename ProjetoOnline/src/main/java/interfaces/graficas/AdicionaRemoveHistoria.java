/*
Hiero Henrique Barcelos Costa -202065136A 

Matheus Cardoso Faesy - 202065065A 

Thaís de Jesus Soares - 202065511B 
*/
package interfaces.graficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import tratamento.eventos.InsereHistoria;
import tratamento.eventos.RemoveHistoria;

public class AdicionaRemoveHistoria implements ActionListener {
    private JTextField tfChavePesquisa;
    private JTextArea tfHistoria;
    private JLabel chavePesquisa, historia;
    private JPanel painel;
    private ConfiguracoesInternas ci;
    private JMenuItem inserirHistoria;
    private JButton inserir;
    private JButton remover;

    public AdicionaRemoveHistoria(ConfiguracoesInternas ci, JMenuItem inserirHistoria) {
        this.chavePesquisa = new JLabel("Chave de Recuperação");
        chavePesquisa.setFont(new Font("Arial", Font.BOLD, 12));
        this.tfChavePesquisa = new JTextField(15);
        this.historia = new JLabel("História");
        historia.setFont(new Font("Arial", Font.BOLD, 12));
        tfHistoria = new JTextArea(18, 65);
        tfHistoria.setBorder(BorderFactory.createEtchedBorder());
        this.ci = ci;
        this.inserirHistoria = inserirHistoria;
        this.inserir = new JButton("Inserir");
        this.inserir.addActionListener(new InsereHistoria(this));
        this.remover = new JButton("Remover");
        this.remover.addActionListener(new RemoveHistoria(this));
        inserir.setToolTipText("Para inserir uma história todos os campos devem estar preenchidos.");
        remover.setToolTipText("Para remover uma história basta informar sua chave de recuperação.");
        
    }
    
    private void posicionaComponentes(){
       GridBagConstraints pos = new GridBagConstraints();
       pos.gridx = 0;
       pos.gridy = 0;
       pos.insets = new Insets(-100,5,5,10);
       painel.add(this.chavePesquisa,pos);
       pos.gridx = 1;
       pos.gridy = 0;
       pos.insets = new Insets(-100,-550,0,0);
       painel.add(this.tfChavePesquisa,pos);
       pos.gridx = 0;
       pos.gridy = 1;
       pos.insets = new Insets(-290,5,5,10);
       painel.add(this.historia,pos);
       pos.gridx = 1;
       pos.gridy = 1;
       pos.insets = new Insets(-25,0,-20,0);
       painel.add(this.tfHistoria,pos);
       pos.gridx = 0;
       pos.gridy = 2;
       pos.insets = new Insets(0,0,-100,-1250);
       painel.add(this.inserir,pos);
       pos.gridx = 1;
       pos.gridy = 2;
       pos.insets = new Insets(0,0,-100,-600);
       painel.add(this.remover,pos);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        painel = new JPanel();
        painel.setBackground(Color.WHITE);
        Border borda = BorderFactory.createEtchedBorder();
        TitledBorder titulo = BorderFactory.createTitledBorder(borda, "História");
        titulo.setTitleJustification(TitledBorder.CENTER);
        titulo.setTitlePosition(TitledBorder.TOP);
        painel.setBorder(titulo);
        painel.setLayout(new GridBagLayout());
        posicionaComponentes();
        this.ci.setPainel(painel);
        this.ci.getJanela().add(this.ci.getPainel());
        this.inserirHistoria.setEnabled(false);
        this.ci.getJanela().repaint();
        this.ci.getJanela().validate();
    }

    public JTextField getTfChavePesquisa() {
        return tfChavePesquisa;
    }

    public void setTfChavePesquisa(JTextField tfChavePesquisa) {
        this.tfChavePesquisa = tfChavePesquisa;
    }

    public JTextArea getTfHistoria() {
        return tfHistoria;
    }

    public void setTfHistoria(JTextArea tfHistoria) {
        this.tfHistoria = tfHistoria;
    }
    
    
    
    
}
