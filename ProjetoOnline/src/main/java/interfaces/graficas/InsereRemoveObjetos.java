package interfaces.graficas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import tratamento.eventos.InsereConsumivel;
import tratamento.eventos.InsereDeus;
import tratamento.eventos.InsereHabilidade;
import tratamento.eventos.RemoveConsumivel;
import tratamento.eventos.RemoveDeus;
import tratamento.eventos.RemoveHabilidade;

public class InsereRemoveObjetos extends ConfiguracoesInternas implements ActionListener {

    private JLabel cNome, cDescricao, cCarga;
    private JTextField tfCNome, tfCDescricao, tfCCarga, tfCTipo;
    private JButton cInserir, cRemover;

    private JLabel hNome, hDescricao, hCarga, hDano;
    private JTextField tfHNome, tfHDescricao, tfHCarga, tfHDano;
    private JButton hInserir, hRemover;

    private JLabel dNome, dDescricao, dVidaBase, dNivel, dPoderBase, dH1Nome, dH2Nome, dH3Nome, dH4Nome, dCaminhoIcone;
    private JTextField tfDNome, tfDDescricao, tfDVidaBase, tfDNivel, tfDPoderBase, tfDH1Nome, tfDH2Nome, tfDH3Nome, tfDH4Nome, tfDCaminhoIcone;
    private JButton dInserir, dRemover;
    private ConfiguracoesInternas ci;
    private JMenuItem inserirRemover;

    public InsereRemoveObjetos(ConfiguracoesInternas ci, JMenuItem inserirRemover) {
        this.ci = ci;
        this.inserirRemover = inserirRemover;
        this.cNome = new JLabel("Nome");
        cNome.setFont(new Font("Arial", Font.BOLD, 10));
        this.cDescricao = new JLabel("Descricao");
        cDescricao.setFont(new Font("Arial", Font.BOLD, 10));
        this.cCarga = new JLabel("Carga");
        cCarga.setFont(new Font("Arial", Font.BOLD, 10));

        this.tfCNome = new JTextField(15);
        this.tfCDescricao = new JTextField(15);
        this.tfCCarga = new JTextField(15);

        this.cInserir = new JButton("Inserir");
        cInserir.addActionListener(new InsereConsumivel(this));
        cInserir.setToolTipText("Para inserir um objeto Carga todos os campos relativos a este devem estar devidamente preenchidos.");
        this.cRemover = new JButton("Remover");
        cRemover.addActionListener(new RemoveConsumivel(this));
        cRemover.setToolTipText("Para remover um objeto Carga basta informar seu nome.");

        this.hNome = new JLabel("Nome");
        hNome.setFont(new Font("Arial", Font.BOLD, 10));
        this.hDescricao = new JLabel("Descricao");
        hDescricao.setFont(new Font("Arial", Font.BOLD, 10));
        this.hCarga = new JLabel("Carga");
        hCarga.setFont(new Font("Arial", Font.BOLD, 10));
        this.hDano = new JLabel("Dano");
        hDano.setFont(new Font("Arial", Font.BOLD, 10));

        this.tfHNome = new JTextField(15);
        this.tfHDescricao = new JTextField(15);
        this.tfHCarga = new JTextField(15);
        this.tfHDano = new JTextField(15);

        this.hInserir = new JButton("Inserir");
        hInserir.addActionListener(new InsereHabilidade(this));
        hInserir.setToolTipText("Para inserir um objeto Habilidade todos os campos relativos a este devem estar devidamente preenchidos.");
        this.hRemover = new JButton("Remover");
        hRemover.addActionListener(new RemoveHabilidade(this));
        hRemover.setToolTipText("Para remover um objeto Habilidade basta informar seu nome.");

        this.dNome = new JLabel("Nome");
        dNome.setFont(new Font("Arial", Font.BOLD, 10));
        this.dDescricao = new JLabel("Descricao");
        dDescricao.setFont(new Font("Arial", Font.BOLD, 10));
        this.dVidaBase = new JLabel("Vida Base");
        dVidaBase.setFont(new Font("Arial", Font.BOLD, 10));
        this.dNivel = new JLabel("Nivel");
        dNivel.setFont(new Font("Arial", Font.BOLD, 10));
        this.dPoderBase = new JLabel("Poder Base");
        dPoderBase.setFont(new Font("Arial", Font.BOLD, 10));
        dH1Nome = new JLabel("Habilidade 1");
        dH1Nome.setFont(new Font("Arial", Font.BOLD, 10));
        dH2Nome = new JLabel("Habilidade 2");
        dH2Nome.setFont(new Font("Arial", Font.BOLD, 10));
        dH3Nome = new JLabel("Habilidade 3");
        dH3Nome.setFont(new Font("Arial", Font.BOLD, 10));
        dH4Nome = new JLabel("Habilidade 4");
        dH4Nome.setFont(new Font("Arial", Font.BOLD, 10));
        dCaminhoIcone = new JLabel("Diretório");
        dCaminhoIcone.setFont(new Font("Arial", Font.BOLD, 10));
        this.tfDNome = new JTextField(15);
        this.tfDDescricao = new JTextField(15);
        this.tfDVidaBase = new JTextField(15);
        this.tfDNivel = new JTextField(15);
        this.tfDPoderBase = new JTextField(15);
        this.tfDCaminhoIcone = new JTextField(15);
        tfDH1Nome = new JTextField(15);
        tfDH2Nome = new JTextField(15);
        tfDH3Nome = new JTextField(15);
        tfDH4Nome = new JTextField(15);
        dInserir = new JButton("Inserir");
        dInserir.addActionListener(new InsereDeus(this));
        dInserir.setToolTipText("Para inserir um objeto Deus todos os campos relativos a este devem estar devidamente preenchidos.");
        dRemover = new JButton("Remover");
        dRemover.addActionListener(new RemoveDeus(this));
        dRemover.setToolTipText("Para remover um objeto Deus basta informar seu nome.");
    }

    private GridBagConstraints posicao(int gridx, int gridy) {
        GridBagConstraints pos = new GridBagConstraints();
        pos.gridx = gridx;
        pos.gridy = gridy;
        return pos;
    }

    private JScrollPane insereConsumivel() {
        JPanel painel = new JPanel();
        Border borda = BorderFactory.createEtchedBorder();
        TitledBorder titulo = BorderFactory.createTitledBorder(borda, "Consumivel");
        titulo.setTitleJustification(TitledBorder.CENTER);
        titulo.setTitlePosition(TitledBorder.TOP);
        painel.setBorder(titulo);
        painel.setLayout(new GridBagLayout());
        GridBagConstraints pos = posicao(0, 0);
        pos.insets = new Insets(-400, 0, 0, 5);
        painel.add(cNome, pos);
        pos = posicao(1, 0);
        pos.insets = new Insets(-400, 0, 0, 0);
        painel.add(tfCNome, pos);
        pos = posicao(0, 1);
        pos.insets = new Insets(-350, 0, 0, 0);
        painel.add(cDescricao, pos);
        pos = posicao(1, 1);
        pos.insets = new Insets(-350, 0, 0, 0);
        painel.add(tfCDescricao, pos);
        pos = posicao(0, 2);
        pos.insets = new Insets(-300, 0, 0, 0);
        pos = posicao(0, 3);
        pos.insets = new Insets(-300, 0, 0, 0);
        painel.add(cCarga, pos);
        pos = posicao(1, 3);
        pos.insets = new Insets(-300, 0, 0, 0);
        painel.add(tfCCarga, pos);
        pos = posicao(0, 4);
        pos.insets = new Insets(-230, 5, 0, -10);
        painel.add(cInserir, pos);
        pos = posicao(1, 4);
        pos.insets = new Insets(-230, 0, 0, -55);
        painel.add(cRemover, pos);

        JScrollPane painelRolante = new JScrollPane(painel);
        return painelRolante;
    }

    private JScrollPane insereHabilidade() {
        JPanel painel = new JPanel();
        Border borda = BorderFactory.createEtchedBorder();
        painel.setBorder(borda);
        TitledBorder titulo = BorderFactory.createTitledBorder(borda, "Habilidade");
        titulo.setTitleJustification(TitledBorder.CENTER);
        titulo.setTitlePosition(TitledBorder.TOP);
        painel.setBorder(titulo);
        painel.setLayout(new GridBagLayout());
        GridBagConstraints pos = posicao(0, 0);
        pos.insets = new Insets(-400, 0, 0, 5);
        painel.add(hNome, pos);
        pos = posicao(1, 0);
        pos.insets = new Insets(-400, 0, 0, 0);
        painel.add(tfHNome, pos);
        pos = posicao(0, 1);
        pos.insets = new Insets(-350, 0, 0, 0);
        painel.add(hDescricao, pos);
        pos = posicao(1, 1);
        pos.insets = new Insets(-350, 0, 0, 0);
        painel.add(tfHDescricao, pos);
        pos = posicao(0, 2);
        pos.insets = new Insets(-300, 0, 0, 0);
        painel.add(hDano, pos);
        pos = posicao(1, 2);
        pos.insets = new Insets(-300, 0, 0, 0);
        painel.add(tfHDano, pos);
        pos = posicao(0, 3);
        pos.insets = new Insets(-250, 0, 0, 0);
        painel.add(hCarga, pos);
        pos = posicao(1, 3);
        pos.insets = new Insets(-250, 0, 0, 0);
        painel.add(tfHCarga, pos);
        pos = posicao(0, 4);
        pos.insets = new Insets(-180, 5, 0, -10);
        painel.add(hInserir, pos);
        pos = posicao(1, 4);
        pos.insets = new Insets(-180, 0, 0, -55);
        painel.add(hRemover, pos);

        JScrollPane painelRolante = new JScrollPane(painel);
        return painelRolante;
    }

    private JScrollPane insereDeus() {
        JPanel painel = new JPanel();
        Border borda = BorderFactory.createEtchedBorder();
        painel.setBorder(borda);
        TitledBorder titulo = BorderFactory.createTitledBorder(borda, "Deus");
        titulo.setTitleJustification(TitledBorder.CENTER);
        titulo.setTitlePosition(TitledBorder.TOP);
        painel.setBorder(titulo);
        painel.setLayout(new GridBagLayout());
        GridBagConstraints pos = posicao(0, 0);
        pos.insets = new Insets(-400, 0, 0, 5);
        painel.add(dNome, pos);
        pos = posicao(1, 0);
        pos.insets = new Insets(-400, 0, 0, 0);
        painel.add(tfDNome, pos);
        pos = posicao(0, 1);
        pos.insets = new Insets(-350, 0, 0, 0);
        painel.add(dDescricao, pos);
        pos = posicao(1, 1);
        pos.insets = new Insets(-350, 0, 0, 0);
        painel.add(tfDDescricao, pos);
        pos = posicao(0, 2);
        pos.insets = new Insets(-300, 0, 0, 0);
        painel.add(dVidaBase, pos);
        pos = posicao(1, 2);
        pos.insets = new Insets(-300, 0, 0, 0);
        painel.add(tfDVidaBase, pos);
        pos = posicao(0, 3);
        pos.insets = new Insets(-250, 0, 0, 0);
        painel.add(dNivel, pos);
        pos = posicao(1, 3);
        pos.insets = new Insets(-250, 0, 0, 0);
        painel.add(tfDNivel, pos);
        pos = posicao(0, 4);
        pos.insets = new Insets(-200, 0, 0, 0);
        painel.add(dPoderBase, pos);
        pos = posicao(1, 4);
        pos.insets = new Insets(-200, 0, 0, 0);
        painel.add(tfDPoderBase, pos);

        pos = posicao(0, 5);
        pos.insets = new Insets(-150, 0, 0, 5);
        painel.add(dH1Nome, pos);
        pos = posicao(1, 5);
        pos.insets = new Insets(-150, 0, 0, 0);
        painel.add(tfDH1Nome, pos);

        pos = posicao(0, 6);
        pos.insets = new Insets(-100, 0, 0, 5);
        painel.add(dH2Nome, pos);
        pos = posicao(1, 6);
        pos.insets = new Insets(-100, 0, 0, 0);
        painel.add(tfDH2Nome, pos);

        pos = posicao(0, 7);
        pos.insets = new Insets(-50, 0, 0, 5);
        painel.add(dH3Nome, pos);
        pos = posicao(1, 7);
        pos.insets = new Insets(-50, 0, 0, 0);
        painel.add(tfDH3Nome, pos);

        pos = posicao(0, 8);
        pos.insets = new Insets(-10, 0, 0, 5);
        painel.add(dH4Nome, pos);
        pos = posicao(1, 8);
        pos.insets = new Insets(-10, 0, 0, 0);
        painel.add(tfDH4Nome, pos);

        pos = posicao(0, 9);
        pos.insets = new Insets(0, 5, -30, 5);
        painel.add(dCaminhoIcone, pos);
        pos = posicao(1, 9);
        pos.insets = new Insets(0, 0, -30, 0);
        painel.add(tfDCaminhoIcone, pos);

        pos = posicao(0, 10);
        pos.insets = new Insets(0, 5, -100, -10);
        painel.add(dInserir, pos);
        pos = posicao(1, 10);
        pos.insets = new Insets(0, 0, -100, -55);
        painel.add(dRemover, pos);

        JScrollPane painelRolante = new JScrollPane(painel);
        return painelRolante;
    }

    public JTextField getTfCNome() {
        return tfCNome;
    }

    public JTextField getTfCDescricao() {
        return tfCDescricao;
    }

    public JTextField getTfCCarga() {
        return tfCCarga;
    }

    public JTextField getTfCTipo() {
        return tfCTipo;
    }

    public JTextField getTfHNome() {
        return tfHNome;
    }

    public JTextField getTfHDescricao() {
        return tfHDescricao;
    }

    public JTextField getTfHCarga() {
        return tfHCarga;
    }

    public JTextField getTfHDano() {
        return tfHDano;
    }

    public JTextField getTfDNome() {
        return tfDNome;
    }

    public JTextField getTfDDescricao() {
        return tfDDescricao;
    }

    public JTextField getTfDVidaBase() {
        return tfDVidaBase;
    }

    public JTextField getTfDNivel() {
        return tfDNivel;
    }

    public JTextField getTfDPoderBase() {
        return tfDPoderBase;
    }

    public JTextField getTfDH1Nome() {
        return tfDH1Nome;
    }

    public JTextField getTfDH2Nome() {
        return tfDH2Nome;
    }

    public JTextField getTfDH3Nome() {
        return tfDH3Nome;
    }

    public JTextField getTfDH4Nome() {
        return tfDH4Nome;
    }

    public void setTfCCarga(JTextField tfCCarga) {
        this.tfCCarga = tfCCarga;
    }

    public void setTfCNome(JTextField tfCNome) {
        this.tfCNome = tfCNome;
    }

    public void setTfCDescricao(JTextField tfCDescricao) {
        this.tfCDescricao = tfCDescricao;
    }

    public void setTfCTipo(JTextField tfCTipo) {
        this.tfCTipo = tfCTipo;
    }

    public void setTfHNome(JTextField tfHNome) {
        this.tfHNome = tfHNome;
    }

    public void setTfHDescricao(JTextField tfHDescricao) {
        this.tfHDescricao = tfHDescricao;
    }

    public void setTfHCarga(JTextField tfHCarga) {
        this.tfHCarga = tfHCarga;
    }

    public void setTfHDano(JTextField tfHDano) {
        this.tfHDano = tfHDano;
    }

    public void setTfDNome(JTextField tfDNome) {
        this.tfDNome = tfDNome;
    }

    public void setTfDDescricao(JTextField tfDDescricao) {
        this.tfDDescricao = tfDDescricao;
    }

    public void setTfDVidaBase(JTextField tfDVidaBase) {
        this.tfDVidaBase = tfDVidaBase;
    }

    public void setTfDNivel(JTextField tfDNivel) {
        this.tfDNivel = tfDNivel;
    }

    public void setTfDPoderBase(JTextField tfDPoderBase) {
        this.tfDPoderBase = tfDPoderBase;
    }

    public void setTfDH1Nome(JTextField tfDH1Nome) {
        this.tfDH1Nome = tfDH1Nome;
    }

    public void setTfDH2Nome(JTextField tfDH2Nome) {
        this.tfDH2Nome = tfDH2Nome;
    }

    public void setTfDH3Nome(JTextField tfDH3Nome) {
        this.tfDH3Nome = tfDH3Nome;
    }

    public void setTfDH4Nome(JTextField tfDH4Nome) {
        this.tfDH4Nome = tfDH4Nome;
    }

    public JTextField getTfDCaminhoIcone() {
        return tfDCaminhoIcone;
    }

    public void setTfDCaminhoIcone(JTextField tfDCaminhoIcone) {
        this.tfDCaminhoIcone = tfDCaminhoIcone;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel painel = new JPanel(new GridLayout(0, 3));
        painel.add(insereConsumivel());
        painel.add(insereHabilidade());
        painel.add(insereDeus());
        this.ci.setPainel(painel);
        this.ci.getJanela().add(this.ci.getPainel());
        this.inserirRemover.setEnabled(false);
        this.ci.getJanela().repaint();
        this.ci.getJanela().validate();
    }
}
