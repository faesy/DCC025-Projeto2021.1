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

public class RemoveHistoria implements ActionListener, BancoDados{
    private AdicionaRemoveHistoria objeto;
    private JSONObject bancoDados;
    private JSONParser parser;
    private String chaveRecuperacao;

    public RemoveHistoria(AdicionaRemoveHistoria objeto) {
        this.objeto = objeto;
        parser = new JSONParser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.objeto.getTfChavePesquisa().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O preenchimento do campo \"Chave de Recuperação\" é obrigatório.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
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
                    historiaArray.remove(i);
                    FileWriter fw = null;
                    fw = new FileWriter(CAMINHO_BANCO_DADOS);
                    fw.write(bancoDados.toJSONString());
                    fw.close();
                    JOptionPane.showMessageDialog(null, "A história foi removida com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (existe == false) {
                JOptionPane.showMessageDialog(null, "Não existe uma história com chave de recuperação " + this.chaveRecuperacao + " ", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(InsereHistoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(InsereHistoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }