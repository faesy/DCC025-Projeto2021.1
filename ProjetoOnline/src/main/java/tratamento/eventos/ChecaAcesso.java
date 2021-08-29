/*
Hiero Henrique Barcelos Costa -202065136A 

Matheus Cardoso Faesy - 202065065A 

Thaís de Jesus Soares - 202065511B 
*/
package tratamento.eventos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ChecaAcesso implements ActionListener {

    private JPasswordField tfChave;
    protected JFrame janela;

    public ChecaAcesso() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        janela = new JFrame("Acesso - Administrador");
        janela.setSize(300, 120);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        GridBagConstraints pos = new GridBagConstraints();
        pos.gridx = 0;
        pos.gridy = 0;
        pos.insets = new Insets(-40, 0, 0, 0);
        painel.add(new JLabel("Chave de Segurança:"), pos);

        tfChave = new JPasswordField(12);
        pos.gridx = 1;
        pos.gridy = 0;
        pos.insets = new Insets(-40, 5, 0, 0);
        painel.add(tfChave, pos);

        JButton ok = new JButton("Ok");
        ok.addActionListener(new Ok(this));
        pos.gridx = 0;
        pos.gridy = 1;
        pos.insets = new Insets(-5, 10, -40, 0);
        painel.add(ok, pos);

        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new Cancela(this));
        pos.gridx = 1;
        pos.gridy = 1;
        pos.insets = new Insets(-5, 0, -40, 0);
        painel.add(cancelar, pos);

        janela.add(painel);
        janela.setVisible(true);
    }

    public JPasswordField getTfChave() {
        return tfChave;
    }

}