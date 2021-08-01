package tratamento.eventos;

import classes.BancoDados;
import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import classes.Consumivel;
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

public class RemoveConsumivel implements ActionListener, BancoDados {

    InsereRemoveObjetos objeto;
    JSONObject bancoDados;
    JSONParser parser;
    Consumivel consumivel;

    public RemoveConsumivel(InsereRemoveObjetos objeto) {
        this.objeto = objeto;
        this.parser = new JSONParser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.objeto.getTfCNome().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O preenchimento do campo Nome e obrigatorio", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        consumivel = new Consumivel();
        consumivel.setNome(this.objeto.getTfCNome().getText());
        manipulaJSON();
        this.objeto.getTfCNome().setText("");
        this.objeto.getTfCDescricao().setText("");
        this.objeto.getTfCCarga().setText("");
    }

    @Override
    public void manipulaJSON() {
        try {
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject consumiveis = (JSONObject) bancoDadosArray.get(3);
            JSONArray consumiveisArray = (JSONArray) consumiveis.get("Consumiveis");
            boolean existe = false;
            for (int i = 0; i < consumiveisArray.size(); i++) {
                JSONObject consumivelAux = (JSONObject) consumiveisArray.get(i);
                if (consumivelAux.get("Nome").equals(consumivel.getNome())) {
                    existe = true;
                    consumiveisArray.remove(i);
                    FileWriter fw = null;
                    fw = new FileWriter(CAMINHO_BANCO_DADOS);
                    fw.write(bancoDados.toJSONString());
                    fw.close();
                    JOptionPane.showMessageDialog(null, "O consumivel foi removido com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (existe == false) {
                JOptionPane.showMessageDialog(null, "O consumivel nao existe.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}