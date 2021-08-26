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
    
    public Salvar(Jogador jogador,InsereRemoveObjetos objeto){
        this.objeto = objeto;
        parser = new JSONParser();
        this.jogador=jogador;
        deus=this.jogador.getDeus();
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
            JSONObject deuses = (JSONObject) bancoDadosArray.get(1);
            JSONArray deusesArray = (JSONArray) deuses.get("Deuses");
            boolean existe = false;
            for (int i = 0; i < deusesArray.size(); i++) {
                JSONObject deusAux = (JSONObject) deusesArray.get(i);
                if (deusAux.get("Nome").equals(deus.getNome())) {
                    existe = true;
                    JOptionPane.showMessageDialog(null, "O Deus já existe.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (existe == false) {
                JSONObject deusAux = new JSONObject();
                deusAux.put("Nome", deus.getNome());
                deusAux.put("Descricao", deus.getDescricao());
                deusAux.put("Poder Base", deus.getPoderBase());
                deusAux.put("Vida Base", deus.getVidaBase());
                deusAux.put("Nivel", deus.getNivel());
                deusAux.put("Diretorio", deus.getCaminhoIcone());
                deusAux.put("Tipo", deus.getTipo());
                JSONObject habilidades = (JSONObject) bancoDadosArray.get(2);
                JSONArray habilidadesArray = (JSONArray) habilidades.get("Habilidades");
                JSONArray dHabilidadeArray = new JSONArray();
                deusAux.put("Habilidades", dHabilidadeArray);
                int[] hExiste = {0, 0, 0, 0};
                for (int i = 0; i < habilidadesArray.size(); i++) {
                    JSONObject habilidadeAux = (JSONObject) habilidadesArray.get(i);
                    if (habilidadeAux.get("Nome").equals(nomeHabilidades[0])) {
                        dHabilidadeArray.add(habilidadeAux);
                        hExiste[0] = 1;
                    }
                    if (habilidadeAux.get("Nome").equals(nomeHabilidades[1])) {
                        dHabilidadeArray.add(habilidadeAux);
                        hExiste[1] = 1;
                    }
                    if (habilidadeAux.get("Nome").equals(nomeHabilidades[2])) {
                        dHabilidadeArray.add(habilidadeAux);
                        hExiste[2] = 1;
                    }
                    if (habilidadeAux.get("Nome").equals(nomeHabilidades[3])) {
                        dHabilidadeArray.add(habilidadeAux);
                        hExiste[3] = 1;
                    }
                }
                for (int j = 0; j < hExiste.length; j++) {
                    if (hExiste[j] == 0) {
                        JOptionPane.showMessageDialog(null, "A habilidade " + nomeHabilidades[j] + " não existe. Crie-a primeiro ", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                deusesArray.add(deusAux);
                FileWriter fw = null;
                fw = new FileWriter(CAMINHO_BANCO_DADOS);
                fw.write(bancoDados.toJSONString());
                fw.close();
                JOptionPane.showMessageDialog(null, "Deus inserido com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
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
