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
                Historia b = new Historia("Tudo começou quando ...", jogador);
                break;
            case 2:
                InterfaceBatalha c = new InterfaceBatalha(jogador, "Zeus");
                break;
            case 3:
                TelaDeDescanso d = new TelaDeDescanso(jogador);
                break;
            case 4:
                Historia e = new Historia("Tudo começou quando ...", jogador);
                break;
            case 5:
                InterfaceBatalha f = new InterfaceBatalha(jogador, "Zeus");
                break;
            case 6:
                TelaDeDescanso g = new TelaDeDescanso(jogador);
                break;
            case 7:
                Historia h = new Historia("Tudo começou quando ...", jogador);
                break;
            case 8:
                InterfaceBatalha i = new InterfaceBatalha(jogador, "Zeus");
                break;
            case 9:
                TelaDeDescanso j = new TelaDeDescanso(jogador);
                break;
                
           /* case 10:
                Historia e = new Historia("Tudo começou quando ...", jogador);
                break;
            case 11:
                InterfaceBatalha f = new InterfaceBatalha(jogador, "Zeus");
                break;
            case 12:
                TelaDeDescanso g = new TelaDeDescanso(jogador);
                break;
            case 13:
                Historia e = new Historia("Tudo começou quando ...", jogador);
                break;
            case 14:
                InterfaceBatalha f = new InterfaceBatalha(jogador, "Zeus");
                break;
            case 15:
                TelaDeDescanso g = new TelaDeDescanso(jogador);
                break;
            case 16:
                Historia e = new Historia("Tudo começou quando ...", jogador);
                break;
            case 17:
                InterfaceBatalha f = new InterfaceBatalha(jogador, "Zeus");
                break;
            case 18:
                TelaDeDescanso g = new TelaDeDescanso(jogador);
                break;*/

        }
    }
}
