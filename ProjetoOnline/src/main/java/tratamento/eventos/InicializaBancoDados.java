package tratamento.eventos;

import classes.BancoDados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class InicializaBancoDados implements ActionListener, BancoDados {

    @Override
    public void actionPerformed(ActionEvent e) {
        manipulaJSON();
        JOptionPane.showMessageDialog(null, "O Banco de Dados foi inicializado com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void manipulaJSON() {
        FileWriter fw = null;
        try {
            JSONArray bancoDadosArray = new JSONArray();

            JSONObject jogadores = new JSONObject();
            JSONArray jogadoresArray = new JSONArray();
            jogadores.put("Jogadores", jogadoresArray);
            bancoDadosArray.add(jogadores);

            JSONObject deuses = new JSONObject();
            JSONArray deusesArray = new JSONArray();
            deuses.put("Deuses", deusesArray);
            bancoDadosArray.add(deuses);

            JSONObject habilidades = new JSONObject();
            JSONArray habilidadesArray = new JSONArray();
            habilidades.put("Habilidades", habilidadesArray);
            bancoDadosArray.add(habilidades);

            JSONObject consumiveis = new JSONObject();
            JSONArray consumiveisArray = new JSONArray();
            consumiveis.put("Consumiveis", consumiveisArray);
            bancoDadosArray.add(consumiveis);

            JSONObject chaveSeguranca = new JSONObject();
            chaveSeguranca.put("Chave de Seguranca", "123456789**");
            bancoDadosArray.add(chaveSeguranca);

            JSONObject bancoDados = new JSONObject();
            bancoDados.put("Banco de Dados", bancoDadosArray);

            fw = new FileWriter(CAMINHO_BANCO_DADOS);
            fw.write(bancoDados.toJSONString());

        } catch (IOException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}