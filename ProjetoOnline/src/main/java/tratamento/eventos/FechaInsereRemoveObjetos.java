/*
Hiero Henrique Barcelos Costa -202065136A 

Matheus Cardoso Faesy - 202065065A 

Thaís de Jesus Soares - 202065511B 
*/
package tratamento.eventos;

import interfaces.graficas.ConfiguracoesInternas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public class FechaInsereRemoveObjetos implements ActionListener {

    private JMenuItem inserirRemover;
    private ConfiguracoesInternas ci;

    public FechaInsereRemoveObjetos(ConfiguracoesInternas ci, JMenuItem inserirRemover) {
        this.inserirRemover = inserirRemover;
        this.ci = ci;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.ci.getJanela().remove(this.ci.getPainel());
        inserirRemover.setEnabled(true);
        this.ci.getJanela().repaint();
        this.ci.getJanela().validate();

    }

}