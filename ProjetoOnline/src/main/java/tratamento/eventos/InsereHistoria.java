/*
Hiero Henrique Barcelos Costa -202065136A 

Matheus Cardoso Faesy - 202065065A 

Thaís de Jesus Soares - 202065511B 
*/
package tratamento.eventos;

import classes.BancoDados;
import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import interfaces.graficas.AdicionaRemoveHistoria;
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

public class InsereHistoria implements ActionListener, BancoDados{
    private AdicionaRemoveHistoria objeto;
    private JSONObject bancoDados;
    private JSONParser parser;
    private String chaveRecuperacao, texto;

    public InsereHistoria(AdicionaRemoveHistoria objeto) {
        this.objeto = objeto;
        parser = new JSONParser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.objeto.getTfHistoria().getText().equals("") || this.objeto.getTfChavePesquisa().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O preenchimento de todos os campos é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        texto = this.objeto.getTfHistoria().getText();
        chaveRecuperacao = this.objeto.getTfChavePesquisa().getText();
        manipulaJSON();
        this.objeto.getTfHistoria().setText("");
        this.objeto.getTfChavePesquisa().setText("");

    }

    @Override
    public void manipulaJSON() {
        try {
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject historia = (JSONObject) bancoDadosArray.get(5);
            JSONArray historiaArray = (JSONArray) historia.get("Historia");
            boolean existe = false;
            for (int i = 0; i < historiaArray.size(); i++) {
                JSONObject historiaAux = (JSONObject) historiaArray.get(i);
                if (historiaAux.get("Chave de Recuperacao").equals(this.chaveRecuperacao)) {
                    existe = true;
                    JOptionPane.showMessageDialog(null, "A história já existe.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (existe == false) {
                JSONObject historiaAux = new JSONObject();
                historiaAux.put("Chave de Recuperacao", this.chaveRecuperacao);
                historiaAux.put("Texto", this.texto);
                historiaArray.add(historiaAux);
                FileWriter fw = null;
                fw = new FileWriter(CAMINHO_BANCO_DADOS);
                fw.write(bancoDados.toJSONString());
                fw.close();
                JOptionPane.showMessageDialog(null, "História inserida com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(InsereHistoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(InsereHistoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
