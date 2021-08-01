package tratamento.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cancela implements ActionListener {

    private ChecaAcesso objeto;

    public Cancela(ChecaAcesso checaAcesso) {
        this.objeto = checaAcesso;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        objeto.janela.setVisible(false);
        objeto.janela.setEnabled(false);
    }
}