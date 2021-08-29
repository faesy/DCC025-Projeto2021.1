/*
Hiero Henrique Barcelos Costa -202065136A 

Matheus Cardoso Faesy - 202065065A 

Thaís de Jesus Soares - 202065511B 
*/
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
        new Login().criaJanela();
    }
}
