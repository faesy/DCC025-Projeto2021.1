package tratamento.eventos;

import classes.BancoDados;
import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import classes.Deus;
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

public class InsereDeus implements ActionListener, BancoDados {

    private InsereRemoveObjetos objeto;
    Deus deus;
    JSONObject bancoDados;
    String[] nomeHabilidades;
    JSONParser parser;

    public InsereDeus(InsereRemoveObjetos objeto) {
        this.objeto = objeto;
        parser = new JSONParser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.objeto.getTfDNome().getText().equals("") || this.objeto.getTfDDescricao().getText().equals("")
                || this.objeto.getTfDPoderBase().getText().equals("")
                || this.objeto.getTfDVidaBase().getText().equals("")
                || this.objeto.getTfDNivel().getText().equals("")
                || this.objeto.getTfDH1Nome().getText().equals("")
                || this.objeto.getTfDH2Nome().getText().equals("")
                || this.objeto.getTfDH3Nome().getText().equals("")
                || this.objeto.getTfDH4Nome().getText().equals("")
                || this.objeto.getTfDCaminhoIcone().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O preenchimento de todos os campos é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        deus = new Deus();
        deus.setNome(this.objeto.getTfDNome().getText());
        deus.setDescricao(this.objeto.getTfDDescricao().getText());
        deus.setPoderBase(Integer.parseInt(this.objeto.getTfDPoderBase().getText()));
        deus.setNivel(Integer.parseInt(this.objeto.getTfDNivel().getText()));
        deus.setVidaBase(Integer.parseInt(this.objeto.getTfDVidaBase().getText()));
        nomeHabilidades = new String[4];
        nomeHabilidades[0] = this.objeto.getTfDH1Nome().getText();
        nomeHabilidades[1] = this.objeto.getTfDH2Nome().getText();
        nomeHabilidades[2] = this.objeto.getTfDH3Nome().getText();
        nomeHabilidades[3] = this.objeto.getTfDH4Nome().getText();
        deus.setCaminhoIcone(this.objeto.getTfDCaminhoIcone().getText());
        manipulaJSON();

        this.objeto.getTfDNome().setText("");
        this.objeto.getTfDDescricao().setText("");
        this.objeto.getTfDPoderBase().setText("");
        this.objeto.getTfDVidaBase().setText("");
        this.objeto.getTfDNivel().setText("");
        this.objeto.getTfDH1Nome().setText("");
        this.objeto.getTfDH2Nome().setText("");
        this.objeto.getTfDH3Nome().setText("");
        this.objeto.getTfDH4Nome().setText("");
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
        } catch (IOException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
