package tratamento.eventos;

import interfaces.graficas.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
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

public class LogaJogador extends BancoDados implements ActionListener { 

    Login login;
    Jogador jogador;
    JSONObject bancoDados;
    JSONParser parser;

    public LogaJogador(Login usuario) {
        this.login = usuario;
        parser = new JSONParser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jogador = new Jogador();
        jogador.setNome(this.login.getTfLogin().getText());
        jogador.setSenha(new String(this.login.getTfSenha().getPassword()));
        manipulaJSON();
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
                if(jogadorAux.get("Nome").equals(jogador.getNome()) && jogadorAux.get("Senha").equals(jogador.getSenha())) {
                    existe = true;
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso.");
                }
            }
            if(existe == false)
            {
                JOptionPane.showMessageDialog(null, "Nome e/ou senha digitados inválidos");
            }
        } catch (IOException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
