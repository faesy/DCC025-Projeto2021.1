/*
Hiero Henrique Barcelos Costa -202065136A 

Matheus Cardoso Faesy - 202065065A 

Thaís de Jesus Soares - 202065511B 
*/
package tratamento.eventos;

import classes.BancoDados;
import static classes.BancoDados.CAMINHO_BANCO_DADOS;
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

public class ApagaDeuses implements ActionListener, BancoDados {

    JSONObject bancoDados;
    JSONParser parser;

    public ApagaDeuses() {
        parser = new JSONParser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        manipulaJSON();
        JOptionPane.showMessageDialog(null, "Todos os deuses cadastrados foram apagados.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void manipulaJSON() {
        try {
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject deuses = (JSONObject) bancoDadosArray.get(1);
            JSONArray deusesArray = (JSONArray) deuses.get("Deuses");
            deusesArray.clear();
            FileWriter fw = null;
            fw = new FileWriter(CAMINHO_BANCO_DADOS);
            fw.write(bancoDados.toJSONString());
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ApagaConsumiveis.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ApagaConsumiveis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}