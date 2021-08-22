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
        
        int chave=jogador.getChaveDeProgresso();
        
        switch (chave){
            case 0:
                System.out.println("Tem Algo de Errado aqui kkk");
                break;
            case 1:
                EscolhadePersonagens a =new EscolhadePersonagens(jogador);
                break;
            case 2:
                Historia b = new Historia("Tudo começou quando ...",jogador);
                break;
            case 3:
                InterfaceBatalha c = new InterfaceBatalha(jogador, "Rá");
                break;
            case 4:
                TelaDeDescanso d = new TelaDeDescanso();
                break;
            case 5:
                Historia e = new Historia("Tudo começou quando ...",jogador);
                break;
            case 6:
                //InterfaceBatalha f = new InterfaceBatalha();
                break;
            case 7:
                TelaDeDescanso g = new TelaDeDescanso();
                break;
            case 8:
                Historia h = new Historia("Tudo começou quando ...",jogador);
                break;
            case 9:
                //InterfaceBatalha i = new InterfaceBatalha();
                break;
            case 10:
                TelaDeDescanso j = new TelaDeDescanso();
                break;

    }
    

    
}
}
