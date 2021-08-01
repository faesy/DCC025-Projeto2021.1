package tratamento.eventos;

import classes.BancoDados;
import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import classes.Deus;
import interfaces.graficas.InsereRemoveObjetos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RemoveDeus implements ActionListener, BancoDados {

    InsereRemoveObjetos objeto;
    JSONObject bancoDados;
    JSONParser parser;
    Deus deus;
    String[] nomeHabilidades;

    public RemoveDeus(InsereRemoveObjetos objeto) {
        this.objeto = objeto;
        this.parser = new JSONParser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.objeto.getTfDNome().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O preenchimento do campo Nome e obrigatorio", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        deus = new Deus();
        deus.setNome(this.objeto.getTfDNome().getText());
        manipulaJSON();
        this.objeto.getTfDNome().setText("");
        this.objeto.getTfDDescricao().setText("");
        this.objeto.getTfDPoderBase().setText("");
        this.objeto.getTfDVidaBase().setText("");
        this.objeto.getTfDNivel().setText("");
        this.objeto.getTfDH1Nome().setText("");
        this.objeto.getTfDH2Nome().setText("");
        this.objeto.getTfDH3Nome().setText("");
        this.objeto.getTfDH4Nome().setText("");
    }

    @Override
    public void manipulaJSON() {
        try {
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject deuses = (JSONObject) bancoDadosArray.get(1);
            JSONArray deusesArray = (JSONArray) deuses.get("Deuses");
            boolean existe = false;
            for (int i = 0; i < deusesArray.size(); i++) {
                JSONObject deusAux = (JSONObject) deusesArray.get(i);
                if (deusAux.get("Nome").equals(deus.getNome())) {
                    existe = true;
                    deusesArray.remove(i);
                    FileWriter fw = null;
                    fw = new FileWriter(CAMINHO_BANCO_DADOS);
                    fw.write(bancoDados.toJSONString());
                    fw.close();
                    JOptionPane.showMessageDialog(null, "O deus foi removido com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (existe == false) {
                JOptionPane.showMessageDialog(null, "O deus" + this.deus.getNome() + " nao existe.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
