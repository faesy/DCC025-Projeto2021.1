package interfaces.graficas;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import tratamento.eventos.ApagaConsumiveis;
import tratamento.eventos.ApagaDeuses;
import tratamento.eventos.ApagaHabilidades;
import tratamento.eventos.FechaAdicionaHistoria;
import tratamento.eventos.FechaInsereRemoveObjetos;
import tratamento.eventos.InicializaBancoDados;

public class ConfiguracoesInternas {

    private JFrame janela;
    private JPanel painel;

    public ConfiguracoesInternas() {
        painel = new JPanel();
    }

    private JMenuBar posicionaComponentes() {
        JMenuBar menuAdministrador = new JMenuBar();
        JMenu bancoDados = new JMenu("Banco de Dados");
        menuAdministrador.add(bancoDados);

        JMenuItem inicializarJSON = new JMenuItem("Inicializar Banco de Dados");
        inicializarJSON.addActionListener(new InicializaBancoDados());
        bancoDados.add(inicializarJSON);

        JMenuItem inserirRemover = new JMenuItem("Adicionar ou Remover Objetos do Banco de Dados");
        inserirRemover.addActionListener(new InsereRemoveObjetos(this, inserirRemover));
        bancoDados.add(inserirRemover);

        JMenuItem fecharInserirRemover = new JMenuItem("Fechar painel \"Adicionar ou Remover Objetos do Banco de Dados\"");
        fecharInserirRemover.addActionListener(new FechaInsereRemoveObjetos(this, inserirRemover));
        bancoDados.add(fecharInserirRemover);

        JMenuItem apagarConsumiveis = new JMenuItem("Deletar Consumíveis");
        apagarConsumiveis.addActionListener(new ApagaConsumiveis());
        bancoDados.add(apagarConsumiveis);

        JMenuItem apagarDeuses = new JMenuItem("Deletar Deuses");
        apagarDeuses.addActionListener(new ApagaDeuses());
        bancoDados.add(apagarDeuses);

        JMenuItem apagarHabilidades = new JMenuItem("Deletar Habilidades");
        apagarHabilidades.addActionListener(new ApagaHabilidades());
        bancoDados.add(apagarHabilidades);
        
        JMenuItem inserirHistoria = new JMenuItem("Adicionar ou Remover Histórias");
        inserirHistoria.addActionListener(new AdicionaRemoveHistoria(this, inserirHistoria));
        bancoDados.add(inserirHistoria);
        
        JMenuItem fecharInserirHistoria = new JMenuItem("Fechar painel \"Adicionar ou Remover Histórias\"");
        fecharInserirHistoria.addActionListener(new FechaAdicionaHistoria(this, inserirHistoria));
        bancoDados.add(fecharInserirHistoria);

        return menuAdministrador;
    }

    public void criaJanela() {
        janela = new JFrame("Configurações");
        janela.setSize(940, 520);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.setJMenuBar(posicionaComponentes());
        janela.setVisible(true);
    }

    public JFrame getJanela() {
        return janela;
    }

    public void setJanela(JFrame janela) {
        this.janela = janela;
    }

    public JPanel getPainel() {
        return painel;
    }

    public void setPainel(JPanel painel) {
        this.painel = painel;
    }

}