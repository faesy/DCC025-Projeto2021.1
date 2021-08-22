package tratamento.eventos;

import interfaces.graficas.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import classes.BancoDados;
import classes.Jogador;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException; 

public class CadastraJogador implements ActionListener, BancoDados {

    Login cadastro;
    Jogador jogador;
    JSONObject bancoDados;
    JSONParser parser;

    public CadastraJogador(Login cadastro) {
        this.cadastro = cadastro;
        parser = new JSONParser();
    }

    @Override
    public void manipulaJSON() {
        try {
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject jogadores = (JSONObject) bancoDadosArray.get(0);
            JSONArray jogadoresArray = (JSONArray) jogadores.get("Jogadores");
            boolean existe = false;
            for (int i = 0; i < jogadoresArray.size(); i++) {
                JSONObject jogadorAux = (JSONObject) jogadoresArray.get(i);
                if (jogadorAux.get("Nome").equals(jogador.getNome())) {
                    JOptionPane.showMessageDialog(null, "O nome de usuário digitado já existe.");
                    existe = true;
                }
            }
            if (existe == false) {
                JSONObject jogadorAux = new JSONObject();
                jogadorAux.put("Nome", jogador.getNome());
                jogadorAux.put("Senha", jogador.getSenha());
                jogadorAux.put("Chave de Progresso", jogador.getChaveProgresso());
                jogadoresArray.add(jogadorAux);
                FileWriter fw = null;
                fw = new FileWriter(CAMINHO_BANCO_DADOS);
                fw.write(bancoDados.toJSONString());
                fw.close();
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
            }

        } catch (IOException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.cadastro.getTfLogin().getText().equals("") || this.cadastro.getTfSenha().getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "O preenchimento de todos os campos é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        jogador = new Jogador();
        jogador.setNome(this.cadastro.getTfLogin().getText());
        jogador.setSenha(new String(this.cadastro.getTfSenha().getPassword()));
        jogador.setChaveProgresso(0);
        
        manipulaJSON();
        this.cadastro.getTfLogin().setText("");
        this.cadastro.getTfSenha().setText("");
    }

}