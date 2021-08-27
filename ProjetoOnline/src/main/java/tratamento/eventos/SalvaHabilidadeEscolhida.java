package tratamento.eventos;

import classes.BancoDados;
import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import classes.Consumivel;
import classes.Habilidade;
import classes.Jogador;
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
    private Jogador jogador;

    public SalvaHabilidadeEscolhida(MenuHabilidades menuHabilidade, int indiceHabilidade, Jogador jogador) {
        this.menuHabilidade = menuHabilidade;
        this.parser = new JSONParser();
        this.indiceHabilidade = indiceHabilidade;
        this.jogador = jogador;
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
            if (indiceHabilidade != 4){
            JSONObject habilidades = (JSONObject) bancoDadosArray.get(2);
            JSONArray habilidadesArray = (JSONArray) habilidades.get("Habilidades");
            for (int j = 0; j < habilidadesArray.size(); j++) {
                JSONObject habilidadeAux = (JSONObject) habilidadesArray.get(j);
                if (habilidadeAux.get("Nome").equals(menuHabilidade.getListaHabilidades(indiceHabilidade).getSelectedItem())) {
                    String nome = habilidadeAux.get("Nome").toString();
                    String descricao = habilidadeAux.get("Descricao").toString();
                    int carga = Integer.parseInt(habilidadeAux.get("Carga").toString());
                    int dano = Integer.parseInt(habilidadeAux.get("Dano").toString());
                    menuHabilidade.getHabilidadeInfo().setText("\n  Nome:  " + nome + "\n  Descrição:  "
                            + descricao
                            + "\n  Carga:  " + carga
                            + "\n  Dano:  " + dano);
                    this.menuHabilidade.getJanela().repaint();
                    this.menuHabilidade.getJanela().validate();
                    Habilidade[] habilidadesArranjo = new Habilidade[4];
                    habilidadesArranjo = jogador.getDeus().getHabilidades();
                    habilidadesArranjo[indiceHabilidade].setNome(nome);
                    habilidadesArranjo[indiceHabilidade].setDescricao(descricao);
                    habilidadesArranjo[indiceHabilidade].setCarga(carga);
                    habilidadesArranjo[indiceHabilidade].setDano(dano);
                    jogador.getDeus().setHabilidades(habilidadesArranjo);
                    fr.close();
                    break;
                }
            }
            }
            else{
                JSONObject consumiveis = (JSONObject) bancoDadosArray.get(3);
                JSONArray consumiveisArray = (JSONArray) consumiveis.get("Consumiveis");
                for (int j = 0; j < consumiveisArray.size(); j++) {
                JSONObject consumivelAux = (JSONObject) consumiveisArray.get(j);
                if (consumivelAux.get("Nome").equals(menuHabilidade.getListaHabilidades(indiceHabilidade).getSelectedItem())) {
                    String nome = consumivelAux.get("Nome").toString();
                    String descricao = consumivelAux.get("Descricao").toString();
                    int carga = Integer.parseInt(consumivelAux.get("Carga").toString());
                    String efeito = consumivelAux.get("Efeito").toString();
                    menuHabilidade.getHabilidadeInfo().setText("\n  Nome:  " + nome + "\n  Descrição:  "
                            + descricao
                            + "\n  Carga:  " + carga
                            + "\n  Efeito:  " + efeito);
                    this.menuHabilidade.getJanela().repaint();
                    this.menuHabilidade.getJanela().validate();
                    Consumivel consumivel = new Consumivel();
                    consumivel.setNome(nome);
                    consumivel.setDescricao(descricao);
                    consumivel.setCarga(carga);
                    consumivel.setEfeito(efeito);
                    jogador.setConsumivel(consumivel);
                    fr.close();
                    break;
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
