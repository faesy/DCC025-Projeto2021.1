/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static classes.BancoDados.CAMINHO_BANCO_DADOS;
import interfaces.graficas.EscolhadePersonagens;
import interfaces.graficas.Historia;
import interfaces.graficas.InterfaceBatalha;
import java.io.IOException;
import interfaces.graficas.TelaDeDescanso;
import interfaces.graficas.YouWin;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tratamento.eventos.InsereHistoria;

/**
 *
 * @author mathe
 */
public class Progressao implements BancoDados{
    
    private String chaveRecuperacao, texto;

    public Progressao(Jogador jogador) {

        int chave = jogador.getChaveProgresso();

        switch (chave) {
            case -1:
                System.exit(0);
                break;
            case 0:
                EscolhadePersonagens a = new EscolhadePersonagens(jogador);
                break;
            case 1:
                jogador.getDeus().funcaoVidaMax();
                jogador.getDeus().funcaoPoder();
                jogador.getDeus().setVidaAtual(jogador.getDeus().getVidaMax());
                new AlteraConsumiveis(jogador);
                chaveRecuperacao = new String();
                chaveRecuperacao = "b";
                manipulaJSON();
                Historia b = new Historia(texto, jogador);
//                Historia b = new Historia(" Loki convenceu algum dos deuses dos 3 panteoes(nordico,grego e egipcio) a se rebelarem"
//                        + "\n contra o mundo. Seguindo a trilha dele voce encontra um de seus cumplices em busca de descobrir a verdade.", jogador);
                break;
            case 2:
                InterfaceBatalha c = new InterfaceBatalha(jogador, "Medusa");          
                break;
            case 3:
                new AlteraConsumiveis(jogador);
                TelaDeDescanso d = new TelaDeDescanso(jogador);
                break;
            case 4:
                chaveRecuperacao = new String();
                chaveRecuperacao = "e";
                manipulaJSON();
                Historia e = new Historia(texto, jogador);
//                Historia e = new Historia(" Durante sua batalha com a Medusa, ela deixa escapar que estava trabalhando com"
//                        + "\n com a deusa da vinganca Nemesis. Assim, voce vai de encontro a ela para buscar mais informacoes.", jogador);
                break;
            case 5:
                InterfaceBatalha f = new InterfaceBatalha(jogador, "Nemesis");
                break;
            case 6:
                new AlteraConsumiveis(jogador);
                TelaDeDescanso g = new TelaDeDescanso(jogador);
                break;
            case 7:
                chaveRecuperacao = new String();
                chaveRecuperacao = "h";
                manipulaJSON();
                Historia h = new Historia(texto, jogador);
//                Historia h = new Historia(" Apos derrota-la, voce avista um deus vindo de encontro a ela,"
//                        + "\n este que voce reconhece como Thanatos. Porem ao se aproximar deste deus, ele acaba te atacando.", jogador);
                break;
            case 8:
                InterfaceBatalha i = new InterfaceBatalha(jogador, "Thanatos");
                break;
            case 9:
                new AlteraConsumiveis(jogador);
                TelaDeDescanso j = new TelaDeDescanso(jogador);
                break;
            case 10:
                chaveRecuperacao = new String();
                chaveRecuperacao = "k";
                manipulaJSON();
                Historia k = new Historia(texto, jogador);
//                Historia k = new Historia(" Voce consegue subjugar o deus e acaba gastando um tempo questionando-o."
//                        + "\n com isso voce descobre uma pista sobre um deus egipcio responsavel pelos pergaminhos de comunicacao."
//                        + "\n Voce entao vai ao encontro de Thoth.", jogador);
                break;
            case 11:
                InterfaceBatalha l = new InterfaceBatalha(jogador, "Thoth");
                break;
            case 12:
                 new AlteraConsumiveis(jogador);
                TelaDeDescanso m = new TelaDeDescanso(jogador);
                break;
            case 13:
                chaveRecuperacao = new String();
                chaveRecuperacao = "n";
                manipulaJSON();
                Historia n = new Historia(texto, jogador);
//                Historia n = new Historia(" Voce subjuga Thoth e consegue convense-lo de que ele estava fazendo a coisa errada."
//                        + "\n Assim ele te ajuda, dizendo o nome dos outros 2 deuses de seu panteao que estavam envolvidos com Loki."
//                        + "\n Entao, enquanto voce vai atras de Serqet, ele vai buscar por mais informacoes.", jogador);
                break;
            case 14:
                InterfaceBatalha o = new InterfaceBatalha(jogador, "Serqet");
                break;
            case 15:
                 new AlteraConsumiveis(jogador);
                TelaDeDescanso p = new TelaDeDescanso(jogador);
                break;
            case 16:
                chaveRecuperacao = new String();
                chaveRecuperacao = "q";
                manipulaJSON();
                Historia q = new Historia(texto, jogador);
//                Historia q = new Historia(" Depois de derrotar Serqet, Thoth chega afoito, dizendo que Anubis, estava fazendo"
//                        + "\n algo suspeito. Voces rapidamente abandonam Serqet e vao atras de Anubis.", jogador);
                break;
            case 17:
                InterfaceBatalha r = new InterfaceBatalha(jogador, "Anubis");
                break;
            case 18:
                 new AlteraConsumiveis(jogador);
                TelaDeDescanso s = new TelaDeDescanso(jogador);
                break;
            case 19:
                chaveRecuperacao = new String();
                chaveRecuperacao = "t";
                manipulaJSON();
                Historia t = new Historia(texto, jogador);
//                Historia t = new Historia("Nos momentos finais de Anubis, ele, como um bom vilao cliche acaba dizendo"
//                        + "\n todos os planos de Loki para voce. Assim com estas informacoes voce vai atras do paradero de Loki.", jogador);
                break;
            case 20:
                InterfaceBatalha u = new InterfaceBatalha(jogador, "Loki");
                break;
            case 21:
                 new AlteraConsumiveis(jogador);
                TelaDeDescanso v = new TelaDeDescanso(jogador);
                break;
            case 22:
                chaveRecuperacao = new String();
                chaveRecuperacao = "w";
                manipulaJSON();
                Historia w = new Historia(texto, jogador);
//                Historia w = new Historia(" Apos derrotar Loki, voce percebe que ele te enganou, pois ao longe voce encherga Loki soltando"
//                        + "\n um mosntro aterrorizante que estava afugentado mais a frente. Porem como reviravolta, logo depois de soltar Fenrir,"
//                        + "\n este ataca Loki e o devora. Agora, faminto, este monstro te olha no fundo dos olhos e corre em sua direcao.", jogador);
                break;
            case 23:
                InterfaceBatalha x = new InterfaceBatalha(jogador, "Fenrir");
                break;
            case 24:
                 new AlteraConsumiveis(jogador);
                TelaDeDescanso y = new TelaDeDescanso(jogador);
                break;
            case 25:
                chaveRecuperacao = new String();
                chaveRecuperacao = "z";
                manipulaJSON();
                Historia z = new Historia(texto, jogador);
//                Historia z = new Historia(" Sua batalha ardua consegue evitar o ragnarok , mesmo que tenha destruido boa parte"
//                        + "\n do reino do panteao nordico. Entretanto, parece que sua luta acordou um mal ainda maior. Voce entao enxerga"
//                        + "\n uma serpente colosal capaz de dar a volta no mundo e ainda morder sua calda, dado seu tamanho."
//                        + "\n Assim cabe a voce agora derrotar essa monstruosidade antes que ela acabe com o mundo.", jogador);
                break;
            case 26:
                InterfaceBatalha aa = new InterfaceBatalha(jogador, "Jormungandr");
                break;
            case 27:
                chaveRecuperacao = new String();
                chaveRecuperacao = "last";
                manipulaJSON();
                Historia last = new Historia(texto, jogador);
//                Historia last = new Historia(" Voce, apos uma longa  batalha voce consegue derrotar o monstro, salvando o mundo"
//                        + "\n para sempre desses perigos, que antes, prometiam destrui-lo.", jogador);
                break;
            case 28:
                new YouWin(jogador);
                break;

        }
    }

    @Override
    public void manipulaJSON() {
        try {
            JSONObject bancoDados;
            JSONParser parser = new JSONParser();
            bancoDados = (JSONObject) parser.parse(new FileReader(CAMINHO_BANCO_DADOS));
            JSONArray bancoDadosArray = (JSONArray) bancoDados.get("Banco de Dados");
            JSONObject historia = (JSONObject) bancoDadosArray.get(5);
            JSONArray historiaArray = (JSONArray) historia.get("Historia");
            boolean existe = false;
            for (int i = 0; i < historiaArray.size(); i++) {
                JSONObject historiaAux = (JSONObject) historiaArray.get(i);
                if (historiaAux.get("Chave de Recuperacao").equals(this.chaveRecuperacao)) {
                    existe = true;
                    texto = new String();
                    texto = historiaAux.get("Texto").toString();
                }
            }
            if (existe == false) {
                JOptionPane.showMessageDialog(null, "Não existe uma história com chave de recuperação " + this.chaveRecuperacao + " ", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(InsereHistoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(InsereHistoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
