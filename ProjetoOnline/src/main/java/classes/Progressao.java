/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.graficas.EscolhadePersonagens;
import interfaces.graficas.Historia;
import interfaces.graficas.InterfaceBatalha;
import java.io.IOException;
import interfaces.graficas.TelaDeDescanso;
import interfaces.graficas.YouWin;

/**
 *
 * @author mathe
 */
public class Progressao {

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
                Historia b = new Historia(" Loki convenceu algum dos deuses dos 3 panteoes(nordico,grego e egipcio) a se rebelarem"
                        + "\n contra o mundo. Seguindo a trilha dele voce encontra um de seus cumplices em busca de descobrir a verdade.", jogador);
                break;
            case 2:
                InterfaceBatalha c = new InterfaceBatalha(jogador, "Medusa");          
                break;
            case 3:
                new AlteraConsumiveis(jogador);
                TelaDeDescanso d = new TelaDeDescanso(jogador);
                break;
            case 4:
                Historia e = new Historia(" Durante sua batalha com a Medusa, ela deixa escapar que estava trabalhando com"
                        + "\n com a deusa da vinganca Nemesis. Assim voce vai de encontro a ela para buscar mais informacoes.", jogador);
                break;
            case 5:
                InterfaceBatalha f = new InterfaceBatalha(jogador, "Nemesis");
                break;
            case 6:
                new AlteraConsumiveis(jogador);
                TelaDeDescanso g = new TelaDeDescanso(jogador);
                break;
            case 7:
                Historia h = new Historia(" Apos derrota-la, voce avista um deus vindo de encontro a ela,"
                        + "\n este que voce reconhece como Thanatos. Porem ao se aproximar deste deus, ele acaba te atacando.", jogador);
                break;
            case 8:
                InterfaceBatalha i = new InterfaceBatalha(jogador, "Thanatos");
                break;
            case 9:
                new AlteraConsumiveis(jogador);
                TelaDeDescanso j = new TelaDeDescanso(jogador);
                break;
            case 10:
                Historia k = new Historia(" Voce consegue subjugar o deus e acaba gastando um tempo questionando-o."
                        + "\n com isso voce descobre uma pista sobre um deus egipcio responsavel pelos pergaminhos de comunicacao."
                        + "\n Voce entao vai ao encontro de Thoth.", jogador);
                break;
            case 11:
                InterfaceBatalha l = new InterfaceBatalha(jogador, "Thoth");
                break;
            case 12:
                 new AlteraConsumiveis(jogador);
                TelaDeDescanso m = new TelaDeDescanso(jogador);
                break;
            case 13:
                Historia n = new Historia(" Voce subjuga Thoth e consegue convense-lo de que ele estava fazendo a coisa errada."
                        + "\n Assim ele te ajuda, dizendo o nome dos outros 2 deuses de seu panteao que estavam envolvidos com Loki."
                        + "\n Entao, enquanto voce vai atras de Serqet, ele vai buscar por mais informacoes.", jogador);
                break;
            case 14:
                InterfaceBatalha o = new InterfaceBatalha(jogador, "Serqet");
                break;
            case 15:
                 new AlteraConsumiveis(jogador);
                TelaDeDescanso p = new TelaDeDescanso(jogador);
                break;
            case 16:
                Historia q = new Historia(" Depois de derrotar Serqet, Thoth chega afoito, dizendo que Anubis, estava fazendo"
                        + "\n algo suspeito. Voces rapidamente abandonam Serqet e vao atras de Anubis.", jogador);
                break;
            case 17:
                InterfaceBatalha r = new InterfaceBatalha(jogador, "Anubis");
                break;
            case 18:
                 new AlteraConsumiveis(jogador);
                TelaDeDescanso s = new TelaDeDescanso(jogador);
                break;
            case 19:
                Historia t = new Historia("Nos momentos finais de Anubis, ele, como um bom vilao cliche acaba dizendo"
                        + "\n todos os planos de Loki para voce. Assim com estas informacoes voce vai atras do paradero de Loki.", jogador);
                break;
            case 20:
                InterfaceBatalha u = new InterfaceBatalha(jogador, "Loki");
                break;
            case 21:
                 new AlteraConsumiveis(jogador);
                TelaDeDescanso v = new TelaDeDescanso(jogador);
                break;
            case 22:
                Historia w = new Historia(" Apos derrotar Loki, voce percebe que ele te enganou, pois ao longe voce encherga Loki soltando"
                        + "\n um mosntro aterrorizante que estava afugentado mais a frente. Porem como reviravolta, logo depois de soltar Fenrir,"
                        + "\n este ataca Loki e o devora. Agora, faminto, este monstro te olha no fundo dos olhos e corre em sua direcao.", jogador);
                break;
            case 23:
                InterfaceBatalha x = new InterfaceBatalha(jogador, "Fenrir");
                break;
            case 24:
                 new AlteraConsumiveis(jogador);
                TelaDeDescanso y = new TelaDeDescanso(jogador);
                break;
            case 25:
                Historia z = new Historia(" Sua batalha ardua consegue evitar o ragnarok , mesmo que tenha destruido boa parte"
                        + "\n do reino do panteao nordico. Entretanto, parece que sua luta acordou um mal ainda maior. Voce entao enxerga"
                        + "\n uma serpente colosal capaz de dar a volta no mundo e ainda morder sua calda, dado seu tamanho."
                        + "\n Assim cabe a voce agora derrotar essa monstruosidade antes que ela acabe com o mundo.", jogador);
                break;
            case 26:
                InterfaceBatalha aa = new InterfaceBatalha(jogador, "Jormungandr");
                break;
            case 27:
                Historia last = new Historia(" Voce, apos uma longa  batalha voce consegue derrotar o monstro, salvando o mundo"
                        + "\n para sempre desses perigos, que antes, prometiam destrui-lo.", jogador);
                break;
            case 28:
                new YouWin(jogador);
                break;

        }
    }
}
