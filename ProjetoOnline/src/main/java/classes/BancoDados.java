package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import tratamento.eventos.LogaJogador;

//Mudar nome da classe para Armazem
public abstract class BancoDados {

    public final static String CAMINHO_BANCO_DADOS = "./src/main/java/arquivo/JSON/BancoDados.json";

    public abstract void manipulaJSON();

    //acessada pelo administrador?
    public void inicializaJSON() {
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
            habilidades.put("Habilidade", habilidadesArray);
            bancoDadosArray.add(habilidades);

            JSONObject consumiveis = new JSONObject();
            JSONArray consumiveisArray = new JSONArray();
            consumiveis.put("Consumiveis", consumiveisArray);
            bancoDadosArray.add(consumiveis);

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


