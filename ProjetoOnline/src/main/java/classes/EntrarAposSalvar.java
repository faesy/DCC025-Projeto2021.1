/*
Hiero Henrique Barcelos Costa -202065136A 

Matheus Cardoso Faesy - 202065065A 

Thaís de Jesus Soares - 202065511B 
*/
package classes;

import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import interfaces.graficas.MenuHabilidades;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author mathe
 */
public class EntrarAposSalvar implements BancoDados{
    JSONObject bancoDados;
    JSONParser parser;
    private Jogador jogador;
    private Deus deus=new Deus();
    
    public EntrarAposSalvar(Jogador jogador){
        parser = new JSONParser();
        this.jogador=jogador;
        
        manipulaJSON();
        
        this.deus.funcaoPoder();
        
        this.deus.funcaoVidaMax();
        
        this.jogador.setDeus(deus);
        
        JOptionPane.showMessageDialog(null, "Por favor selecione novamente suas Habilidades e seus Consumiveis ", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        
        new Progressao(jogador);
    }
    
    @Override
    public void manipulaJSON() {
        try {
            
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject jogadores = (JSONObject) bancoDadosArray.get(0);
            JSONArray jogadoresArray = (JSONArray) jogadores.get("Jogadores");
            for (int i = 0; i < jogadoresArray.size(); i++) {
                JSONObject jogadorAux = (JSONObject) jogadoresArray.get(i);
                if (jogadorAux.get("Nome").equals(jogador.getNome())) {
                    
                    deus.setNome(jogadorAux.get("Deus Escolhido").toString());
                    deus.setNivel(Integer.parseInt(jogadorAux.get("Nivel").toString()));
                    
                }
            }
                    

            JSONObject deuses = (JSONObject) bancoDadosArray.get(1);
            JSONArray deusesArray = (JSONArray) deuses.get("Deuses");
            for (int i = 0; i < deusesArray.size(); i++) {
                JSONObject deusAux = (JSONObject) deusesArray.get(i);
                if (deusAux.get("Nome").equals(deus.getNome())) {
                    deus.setDescricao(deusAux.get("Descricao").toString());
                    deus.setPoderBase(Integer.parseInt(deusAux.get("Poder Base").toString()));
                    deus.setVidaBase(Integer.parseInt(deusAux.get("Vida Base").toString()));
                    deus.setCaminhoIcone(deusAux.get("Diretorio").toString());
                    deus.setTipo(deusAux.get("Tipo").toString());
                    
                    JSONArray habilidades = (JSONArray) deusAux.get("Habilidades");
                    
                    Habilidade[] habilidade0 = new Habilidade[4];
                    for(i = 0; i < habilidades.size(); i++){
                        JSONObject habilidadeAux= (JSONObject) habilidades.get(i);
                        habilidade0[i] = new Habilidade();
                        habilidade0[i].setNome(habilidadeAux.get("Nome").toString());
                        habilidade0[i].setCarga(Integer.parseInt(habilidadeAux.get("Carga").toString()));
                        habilidade0[i].setDescricao(habilidadeAux.get("Descricao").toString());
                        habilidade0[i].setDano(Integer.parseInt(habilidadeAux.get("Dano").toString()));
                    }

                    deus.setHabilidades(habilidade0);
                }
            }    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EntrarAposSalvar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EntrarAposSalvar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(EntrarAposSalvar.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}
    
}
