/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author mathe
 */
public class PegaConsumivelBancoDados implements BancoDados{
    
    Consumivel consumivel = new Consumivel();
    JSONObject bancoDados;
    JSONParser parser;

    public Consumivel PegaConsumivelBancoDados(String nome){
        this.consumivel.setNome(nome);
        parser = new JSONParser();
        
        return this.consumivel;
    }
    
    @Override
    public void manipulaJSON() {
        
        try {
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject deuses = (JSONObject) bancoDadosArray.get(1);
            JSONArray deusesArray = (JSONArray) deuses.get("Deuses");
            boolean existe = false;
            for (int i = 0; i < deusesArray.size(); i++) {
                JSONObject deusAux = (JSONObject) deusesArray.get(i);
                if (deusAux.get("Nome").equals(deus.getNome())) {
                    existe = true;
//                    deus.setNome(deusAux.get("Nome").toString());
//                    deus.setDescricao(deusAux.get("Descricao").toString());
//                    deus.setPoderBase(Integer.parseInt(deusAux.get("Poder Base").toString()));
//                    deus.setVidaBase(Integer.parseInt(deusAux.get("Vida Base").toString()));
//                    deus.setNivel(Integer.parseInt(deusAux.get("Nivel").toString()));
//                    deus.setCaminhoIcone(deusAux.get("Diretorio").toString());
//                    deus.setTipo(deusAux.get("Tipo").toString());
                    

                }
            }    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PegaConsumivelBancoDados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PegaConsumivelBancoDados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PegaConsumivelBancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
