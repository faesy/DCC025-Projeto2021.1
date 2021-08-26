package tratamento.eventos;

import interfaces.graficas.ConfiguracoesInternas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public class FechaAdicionaHistoria implements ActionListener{
    private ConfiguracoesInternas ci;
    private JMenuItem inserirHistoria;

    public FechaAdicionaHistoria(ConfiguracoesInternas ci, JMenuItem inserirHistoria) {
        this.ci = ci;
        this.inserirHistoria = inserirHistoria;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.ci.getJanela().remove(this.ci.getPainel());
        inserirHistoria.setEnabled(true);
        this.ci.getJanela().repaint();
        this.ci.getJanela().validate();
    }
    
    
    
}
