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
import interfaces.graficas.EscolhadePersonagens;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LogaJogador implements ActionListener, BancoDados {

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
        if (this.login.getTfLogin().getText().equals("") || this.login.getTfSenha().getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "O preenchimento de todos os campos é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        jogador = new Jogador();
        jogador.setNome(this.login.getTfLogin().getText());
        jogador.setSenha(new String(this.login.getTfSenha().getPassword()));
        manipulaJSON();
        this.login.getTfLogin().setText("");
        this.login.getTfSenha().setText("");
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
                if (jogadorAux.get("Nome").equals(jogador.getNome()) && jogadorAux.get("Senha").equals(jogador.getSenha())) {
                    existe = true;
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    login.janela.setVisible(false);
                    EscolhadePersonagens a =new EscolhadePersonagens(jogador);
                    
                }
            }
            if (existe == false) {
                JOptionPane.showMessageDialog(null, "Nome e/ou senha digitados inválidos", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LogaJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}