package tratamento.eventos;

import classes.BancoDados;
import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import interfaces.graficas.MenuHabilidades;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SalvaHabilidadeEscolhida implements ItemListener, BancoDados {

    private MenuHabilidades menuHabilidade;
    private JSONObject bancoDados;
    private JSONParser parser;
    private int indiceHabilidade;

    public SalvaHabilidadeEscolhida(MenuHabilidades menuHabilidade, int indiceHabilidade) {
        this.menuHabilidade = menuHabilidade;
        this.parser = new JSONParser();
        this.indiceHabilidade = indiceHabilidade;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        manipulaJSON();
    }

    @Override
    public void manipulaJSON() {
        try {
            FileReader fr = new FileReader(CAMINHO_BANCO_DADOS);
            bancoDados = (JSONObject) parser.parse(fr);
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject deuses = (JSONObject) bancoDadosArray.get(1);
            JSONArray deusesArray = (JSONArray) deuses.get("Deuses");
            for (int i = 0; i < deusesArray.size(); i++) {
                JSONObject deusAux = (JSONObject) deusesArray.get(i);
                if (deusAux.get("Nome").equals(this.menuHabilidade.getDeus().getNome())) {
                    JSONArray dHabilidadesArray = (JSONArray) deusAux.get("Habilidades");
                    JSONObject dHabilidadeAux = (JSONObject) dHabilidadesArray.get(indiceHabilidade);
                    if (!dHabilidadeAux.get("Nome").equals(menuHabilidade.getListaHabilidades(indiceHabilidade).getSelectedItem())) {
                        JSONObject habilidades = (JSONObject) bancoDadosArray.get(2);
                        JSONArray habilidadesArray = (JSONArray) habilidades.get("Habilidades");
                        for (int j = 0; j < habilidadesArray.size(); j++) {
                            JSONObject habilidadeAux = (JSONObject) habilidadesArray.get(j);
                            if (habilidadeAux.get("Nome").equals(menuHabilidade.getListaHabilidades(indiceHabilidade).getSelectedItem())){ 
                                menuHabilidade.getHabilidadeInfo().setText("\n  Nome:  " + habilidadeAux.get("Nome").toString() + "\n  Descrição:  "
                                        + habilidadeAux.get("Descricao").toString()
                                        + "\n  Carga:  " + Integer.parseInt(habilidadeAux.get("Carga").toString())
                                        + "\n  Dano:  " + Integer.parseInt(habilidadeAux.get("Dano").toString())); 
                                this.menuHabilidade.getJanela().repaint();
                                this.menuHabilidade.getJanela().validate();
                                dHabilidadesArray.set(indiceHabilidade, habilidadeAux);
                                FileWriter fw = null;
                                fw = new FileWriter(CAMINHO_BANCO_DADOS);
                                fw.write(bancoDados.toJSONString());
                                fw.close();
                                fr.close();
                                break;
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SalvaHabilidadeEscolhida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SalvaHabilidadeEscolhida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
