package interfaces.graficas;

import classes.BancoDados;
import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import classes.Deus;
import java.awt.BorderLayout;
import classes.Jogador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tratamento.eventos.Proximo;
import tratamento.eventos.SalvaHabilidadeEscolhida;

public class MenuHabilidades implements BancoDados {

    private Deus deus;
    private Jogador jogador;
    private JPanel painel;
    private JSONObject bancoDados;
    private JSONParser parser;
    private String[] nomeHabilidades;
    private JComboBox[] listaHabilidades;
    private JButton proximo;
    private JLabel titulo;
    private JLabel habilidadesInfo;
    private JFrame janela;

    public MenuHabilidades(Jogador jogador) {
        this.jogador = jogador;
        this.deus = jogador.getDeus();
        parser = new JSONParser();
        manipulaJSON();
        listaHabilidades = new JComboBox[4];
        for (int i = 0; i < 4; i++) {
            listaHabilidades[i] = new JComboBox(nomeHabilidades);
        }
        habilidadesInfo = new JLabel("");
        habilidadesInfo.setFont(new Font("Georgia", Font.BOLD, 12));
        habilidadesInfo.setBorder(BorderFactory.createLineBorder(Color.black));
        habilidadesInfo.setPreferredSize(new Dimension(180, 150));
        titulo = new JLabel("Selecione as Habilidades Desejadas", JLabel.CENTER);
        titulo.setFont(new Font("Georgia", Font.BOLD, 20));
        proximo = new JButton("Próximo");
        //proximo.addActionListener(new Proximo());
        
    }

    public void criaJanela() {
        janela = new JFrame();
        janela.setSize(500, 296);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        posicionaComponentes();
        janela.add(painel);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void posicionaComponentes() {

        painel = new JPanel();
        painel.setBackground(Color.WHITE);
        painel.setLayout(new BorderLayout());
    
        painel.add(titulo, BorderLayout.NORTH);

        listaHabilidades[0].setPreferredSize(new Dimension(230, 30));
        listaHabilidades[1].setPreferredSize(new Dimension(230, 30));
        listaHabilidades[2].setPreferredSize(new Dimension(230, 30));
        listaHabilidades[3].setPreferredSize(new Dimension(230, 30));

        GridBagLayout layout = new GridBagLayout();
        JPanel painelAux = new JPanel();
        painelAux.setBackground(Color.WHITE);
        painelAux.setPreferredSize(new Dimension(250, 250));
        painelAux.setLayout(layout);

        GridBagConstraints pos = new GridBagConstraints();
        pos.gridx = 0;
        pos.gridy = 0;
        pos.insets = new Insets(5, 5, 5, 10);
        listaHabilidades[0].addItemListener(new SalvaHabilidadeEscolhida(this, 0));
        painelAux.add(listaHabilidades[0], pos);

        pos.gridx = 0;
        pos.gridy = 1;
        pos.insets = new Insets(5, 5, 5, 10);
        listaHabilidades[1].addItemListener(new SalvaHabilidadeEscolhida(this, 1));
        painelAux.add(listaHabilidades[1], pos);

        pos.gridx = 0;
        pos.gridy = 2;
        pos.insets = new Insets(5, 5, 5, 10);
        listaHabilidades[2].addItemListener(new SalvaHabilidadeEscolhida(this, 2));
        painelAux.add(listaHabilidades[2], pos);

        pos.gridx = 0;
        pos.gridy = 3;
        pos.insets = new Insets(5, 5, 5, 10);
        listaHabilidades[3].addItemListener(new SalvaHabilidadeEscolhida(this, 3));
        painelAux.add(listaHabilidades[3], pos);

        pos.gridx = 0;
        pos.gridy = 4;
        pos.insets = new Insets(5, 5, 5, 5);
        painelAux.add(proximo, pos);

        painel.add(painelAux, BorderLayout.EAST);

        GridBagLayout layoutInfo = new GridBagLayout();
        JPanel painelAux2 = new JPanel();
        painelAux2.setLayout(layoutInfo);
        painelAux2.setBackground(Color.WHITE);
        painelAux2.setPreferredSize(new Dimension(200, 200));
 
        pos.insets = new Insets(-10, 20, 25, 0);
        painelAux2.add(habilidadesInfo, pos);
        painel.add(painelAux2, BorderLayout.WEST);

    }

    @Override
    public void manipulaJSON() {
        try {
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject habilidades = (JSONObject) bancoDadosArray.get(2);
            JSONArray habilidadesArray = (JSONArray) habilidades.get("Habilidades");
            nomeHabilidades = new String[habilidadesArray.size()];
            for (int i = 0; i < habilidadesArray.size(); i++) {
                JSONObject habilidadeAux = (JSONObject) habilidadesArray.get(i);
                nomeHabilidades[i] = (String) habilidadeAux.get("Nome");
            }
        } catch (IOException ex) {
            Logger.getLogger(MenuHabilidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(MenuHabilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JComboBox getListaHabilidades(int indice) {
        return listaHabilidades[indice];
    }

    public Deus getDeus() {
        return deus;
    }
    
    public JButton getProximo()
    {
        return proximo;
    }
    
    public JLabel getHabilidadeInfo()
    {
        return habilidadesInfo;
    }
    
    public JFrame getJanela(){
        return janela;
    }
}
