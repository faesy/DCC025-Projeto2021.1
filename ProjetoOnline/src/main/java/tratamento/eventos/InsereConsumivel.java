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

public class InsereConsumivel implements ActionListener, BancoDados {

    private InsereRemoveObjetos objeto;
    Consumivel consumivel;
    JSONObject bancoDados;
    JSONParser parser;

    public InsereConsumivel(InsereRemoveObjetos objeto) {
        this.objeto = objeto;
        parser = new JSONParser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.objeto.getTfCNome().getText().equals("") || this.objeto.getTfCDescricao().getText().equals("")
                || this.objeto.getTfCCarga().getText().equals("")
                || this.objeto.getTfCEfeito().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O preenchimento de todos os campos e obrigatorio", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        consumivel = new Consumivel();
        consumivel.setNome(this.objeto.getTfCNome().getText());
        consumivel.setDescricao(this.objeto.getTfCDescricao().getText());
        consumivel.setCarga(Integer.parseInt(this.objeto.getTfCCarga().getText()));
        consumivel.setEfeito(this.objeto.getTfCEfeito().getText());
        manipulaJSON();
        this.objeto.getTfCNome().setText("");
        this.objeto.getTfCDescricao().setText("");
        this.objeto.getTfCCarga().setText("");
        this.objeto.getTfCEfeito().setText("");
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
                    JOptionPane.showMessageDialog(null, "O consumivel já existe.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (existe == false) {
                JSONObject consumivelAux = new JSONObject();
                consumivelAux.put("Nome", consumivel.getNome());
                consumivelAux.put("Descricao", consumivel.getDescricao());
                consumivelAux.put("Carga", consumivel.getCarga());
                consumivelAux.put("Efeito", consumivel.getEfeito());
                System.out.println(consumivelAux.toString());
                consumiveisArray.add(consumivelAux);
                FileWriter fw = null;
                fw = new FileWriter(CAMINHO_BANCO_DADOS);
                fw.write(bancoDados.toJSONString());
                fw.close();
                JOptionPane.showMessageDialog(null, "Consumivel inserido com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}