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

public class ApagaConsumiveis implements ActionListener, BancoDados {

    JSONObject bancoDados;
    JSONParser parser;

    public ApagaConsumiveis() {
        parser = new JSONParser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        manipulaJSON();
        JOptionPane.showMessageDialog(null, "Todos os consumíveis cadastrados foram apagados.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void manipulaJSON() {
        try {
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject consumiveis = (JSONObject) bancoDadosArray.get(3);
            JSONArray consumiveisArray = (JSONArray) consumiveis.get("Consumiveis");
            consumiveisArray.clear();
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