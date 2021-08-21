package tratamento.eventos;

import classes.Jogador;
import interfaces.graficas.Historia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//ainda nao foi implementado
public class Proximo implements ActionListener {

    public Proximo() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Jogador a=new Jogador();
        new Historia("a",a).criaJanela();
    }
}
