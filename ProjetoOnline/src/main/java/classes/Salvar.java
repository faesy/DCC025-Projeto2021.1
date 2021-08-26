/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import interfaces.graficas.InsereRemoveObjetos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
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

/**
 *
 * @author mathe
 */
public class Salvar implements ActionListener, BancoDados {

    Jogador jogador;
    JSONObject bancoDados;
    JSONParser parser;
    Deus deus;
    private InsereRemoveObjetos objeto;

    public Salvar(Jogador jogador, InsereRemoveObjetos objeto) {
        this.objeto = objeto;
        parser = new JSONParser();
        this.jogador = jogador;
        deus = this.jogador.getDeus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        manipulaJSON();

    }

    @Override
    public void manipulaJSON() {
        try {
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject deuses = (JSONObject) bancoDadosArray.get(0);
            JSONArray jogadoresArray = (JSONArray) deuses.get("Jogadores");
            for (int i = 0; i < jogadoresArray.size(); i++) {
                JSONObject jogadorAux = (JSONObject) jogadoresArray.get(i);
                if (jogadorAux.get("Nome").equals(deus.getNome())) {
                    
                jogadorAux.put("Chave de Progresso", jogador.getChaveProgresso());
                
                jogadorAux.put("Nivel", jogador.getDeus().getNivel());
                    
                jogadorAux.put("Deus Escolhido", jogador.getDeus().getNome());
                
                FileWriter fw = null;
                fw = new FileWriter(CAMINHO_BANCO_DADOS);
                fw.write(bancoDados.toJSONString());
                fw.close();
                JOptionPane.showMessageDialog(null, "Jogo Salvo com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            
                }
            }      
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Salvar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Salvar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Salvar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
