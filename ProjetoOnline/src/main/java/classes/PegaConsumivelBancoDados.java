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

    public Consumivel pegaOConsumivelBancoDados(String nome){
        this.consumivel.setNome(nome);
        parser = new JSONParser();
        
        manipulaJSON();
        
        return this.consumivel;
    }
    
    @Override
    public void manipulaJSON() {
        
        try {
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject consumiveis = (JSONObject) bancoDadosArray.get(3);
            JSONArray consumivelArray = (JSONArray) consumiveis.get("Consumiveis");
            for (int i = 0; i < consumivelArray.size(); i++) {
                JSONObject consumivelAux = (JSONObject) consumivelArray.get(i);
                if (consumivelAux.get("Nome").equals(this.consumivel.getNome())) {
                    
                 this.consumivel.setDescricao(consumivelAux.get("Descricao").toString());
                 
                 this.consumivel.setCarga(Integer.parseInt(consumivelAux.get("Carga").toString()));
                 
                 this.consumivel.setEfeito(consumivelAux.get("Efeito").toString());

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
