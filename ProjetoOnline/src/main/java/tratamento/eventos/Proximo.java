package tratamento.eventos;

import classes.Jogador;
import classes.Progressao;
import interfaces.graficas.Historia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//ainda nao foi implementado
public class Proximo implements ActionListener {
    Jogador jogador;

    public Proximo(Jogador jogador) {
    this.jogador=jogador;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.jogador.aumentaChaveDeProgresso();
        new Progressao(jogador);
    }
}
