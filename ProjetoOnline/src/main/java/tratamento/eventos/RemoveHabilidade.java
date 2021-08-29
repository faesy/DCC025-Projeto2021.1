/*
Hiero Henrique Barcelos Costa -202065136A 

Matheus Cardoso Faesy - 202065065A 

Thaís de Jesus Soares - 202065511B 
*/
package tratamento.eventos;

import classes.BancoDados;
import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import classes.Habilidade;
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

public class RemoveHabilidade implements ActionListener, BancoDados {

    InsereRemoveObjetos objeto;
    JSONObject bancoDados;
    JSONParser parser;
    Habilidade habilidade;

    public RemoveHabilidade(InsereRemoveObjetos objeto) {
        this.objeto = objeto;
        this.parser = new JSONParser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.objeto.getTfHNome().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O preenchimento do campo Nome e obrigatorio", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        habilidade = new Habilidade();
        habilidade.setNome(this.objeto.getTfHNome().getText());
        manipulaJSON();
        this.objeto.getTfHNome().setText("");
        this.objeto.getTfHDescricao().setText("");
        this.objeto.getTfHCarga().setText("");
        this.objeto.getTfHDano().setText("");
    }

    @Override
    public void manipulaJSON() {
        try {
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject habilidades = (JSONObject) bancoDadosArray.get(2);
            JSONArray habilidadesArray = (JSONArray) habilidades.get("Habilidades");
            boolean existe = false;
            for (int i = 0; i < habilidadesArray.size(); i++) {
                JSONObject habilidadeAux = (JSONObject) habilidadesArray.get(i);
                if (habilidadeAux.get("Nome").equals(habilidade.getNome())) {
                    existe = true;
                    habilidadesArray.remove(i);
                    FileWriter fw = null;
                    fw = new FileWriter(CAMINHO_BANCO_DADOS);
                    fw.write(bancoDados.toJSONString());
                    fw.close();
                    JOptionPane.showMessageDialog(null, "A habilidade foi removida com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (existe == false) {
                JOptionPane.showMessageDialog(null, "A habilidades nao existe.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}