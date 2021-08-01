package tratamento.eventos;

import classes.Administrador;
import classes.BancoDados;
import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import interfaces.graficas.ConfiguracoesInternas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Ok implements ActionListener, BancoDados {

    private ChecaAcesso objeto;
    Administrador administrador;
    JSONObject bancoDados;
    JSONParser parser;

    public Ok(ChecaAcesso objeto) {
        this.objeto = objeto;
        this.parser = new JSONParser();
    }

    @Override
    public void manipulaJSON() {
        try {
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject chave = (JSONObject) bancoDadosArray.get(4);
            if (!chave.get("Chave de Seguranca").equals(administrador.getChaveSeguranca())) {
                JOptionPane.showMessageDialog(null, "Acesso Negado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                objeto.janela.setEnabled(false);
                objeto.janela.setVisible(false);
                new ConfiguracoesInternas().criaJanela();
            }

        } catch (IOException ex) {
            Logger.getLogger(Ok.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Ok.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        administrador = new Administrador();
        administrador.setChaveSeguranca(new String(this.objeto.getTfChave().getPassword()));
        manipulaJSON();
        this.objeto.getTfChave().setText("");
    }

}