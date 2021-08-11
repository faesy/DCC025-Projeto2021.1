package interfaces.graficas;

import classes.BancoDados;
import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import classes.Deus;
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
import javax.swing.ImageIcon;
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
    private JPanel painel;
    private JSONObject bancoDados;
    private JSONParser parser;
    private String[] nomeHabilidades;
    private JComboBox[] listaHabilidades;
    private JButton proximo;

    public MenuHabilidades(Deus deus) {
        this.deus = deus;
        parser = new JSONParser();
        manipulaJSON();
        listaHabilidades = new JComboBox[4];
        for (int i = 0; i < 4; i++) {
            listaHabilidades[i] = new JComboBox(nomeHabilidades);
        }
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
    }

    private void posicionaComponentes() {
        painel = new JPanel();
        painel.setBackground(Color.WHITE);
        GridBagLayout layout = new GridBagLayout();
        painel.setLayout(layout);
        GridBagConstraints pos = new GridBagConstraints();

        JLabel iconeDeus = new JLabel();
        iconeDeus.setIcon(new ImageIcon(deus.getCaminhoIcone()));
        //iconeDeus.setIcon(new ImageIcon("./src/main/java/imagens/zeus.jpg"));
        iconeDeus.setPreferredSize(new Dimension(200, 200));
        pos.gridx = 0;
        pos.gridy = 0;
        pos.insets = new Insets(-100, -50, 0, 0);
        painel.add(iconeDeus, pos);

        JLabel nomeDeus = new JLabel(deus.getNome());
        nomeDeus.setForeground(Color.BLACK);
        nomeDeus.setFont(new Font("Georgia", Font.BOLD, 30));
        pos.gridx = 1;
        pos.gridy = 0;
        pos.insets = new Insets(150, -700, 0, 0);
        painel.add(nomeDeus, pos);

        listaHabilidades[0].setPreferredSize(new Dimension(300, 30));
        listaHabilidades[1].setPreferredSize(new Dimension(300, 30));
        listaHabilidades[2].setPreferredSize(new Dimension(300, 30));
        listaHabilidades[3].setPreferredSize(new Dimension(300, 30));

        pos.insets = new Insets(-250, 200, 0, 0);
        listaHabilidades[0].addItemListener(new SalvaHabilidadeEscolhida(this, 0));
        painel.add(listaHabilidades[0], pos);

        pos.insets = new Insets(-150, 200, 0, 0);
        listaHabilidades[1].addItemListener(new SalvaHabilidadeEscolhida(this, 1));
        painel.add(listaHabilidades[1], pos);

        pos.insets = new Insets(-50, 200, 0, 0);
        listaHabilidades[2].addItemListener(new SalvaHabilidadeEscolhida(this, 2));
        painel.add(listaHabilidades[2], pos);

        pos.insets = new Insets(50, 200, 0, 0);
        listaHabilidades[3].addItemListener(new SalvaHabilidadeEscolhida(this, 3));
        painel.add(listaHabilidades[3], pos);

        proximo = new JButton("Próximo");
        proximo.addActionListener(new Proximo());
        pos.insets = new Insets(400, 0, 0, -650);
        painel.add(proximo, pos);

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
}
