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

public class InsereHabilidade implements ActionListener, BancoDados {

    private InsereRemoveObjetos objeto;
    Habilidade habilidade;
    JSONObject bancoDados;
    JSONParser parser;

    public InsereHabilidade(InsereRemoveObjetos objeto) {
        this.objeto = objeto;
        parser = new JSONParser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.objeto.getTfHNome().getText().equals("") || this.objeto.getTfHDescricao().getText().equals("")
                || this.objeto.getTfHCarga().getText().equals("")
                || this.objeto.getTfHDano().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O preenchimento de todos os campos e obrigatorio", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        habilidade = new Habilidade();
        habilidade.setNome(this.objeto.getTfHNome().getText());
        habilidade.setDescricao(this.objeto.getTfHDescricao().getText());
        habilidade.setCarga(Integer.parseInt(this.objeto.getTfHCarga().getText()));
        habilidade.setDano(Integer.parseInt(this.objeto.getTfHDano().getText()));
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
                    JOptionPane.showMessageDialog(null, "A habilidade já existe.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (existe == false) {
                JSONObject habilidadeAux = new JSONObject();
                habilidadeAux.put("Nome", habilidade.getNome());
                habilidadeAux.put("Descricao", habilidade.getDescricao());
                habilidadeAux.put("Carga", habilidade.getCarga());
                habilidadeAux.put("Dano", habilidade.getDano());
                habilidadesArray.add(habilidadeAux);
                FileWriter fw = null;
                fw = new FileWriter(CAMINHO_BANCO_DADOS);
                fw.write(bancoDados.toJSONString());
                fw.close();
                JOptionPane.showMessageDialog(null, "Habilidade inserida com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}