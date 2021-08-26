package classes;

import interfaces.graficas.Login;
import interfaces.graficas.MenuHabilidades;
import interfaces.graficas.EscolhadePersonagens;
import interfaces.graficas.GameOver;
import interfaces.graficas.InterfaceBatalha;
import java.util.HashMap;
import java.util.Map;

public class Jogo {

    public static void main(String[] args) {
//        new Login().criaJanela();
        //o menu de escolhas do deus retornaria o deus escolhido e esse seria passado como
        //parametro para o menuHabilidades ou algo do tipo
        //teste
        //Deus deus = new Deus();
        //new MenuHabilidades(deus).criaJanela();
//         new Historia("Ola").criaJanela();
        //new EscolhadePersonagens().criaJanela();
        new GameOver();
    }
}
