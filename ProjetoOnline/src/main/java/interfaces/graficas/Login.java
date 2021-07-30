package interfaces.graficas;

import java.awt.*;
import javax.swing.*;
import tratamento.eventos.CadastraJogador;
import tratamento.eventos.LogaJogador;

public class Login {

    final private ImageIcon imagem = new ImageIcon("./src/main/java/imagens/Login.jpg");
    final private JLabel login, senha;
    final private JTextField tfLogin;
    final private JPasswordField tfSenha;
    final private JButton logar, cadastrar;
    public JFrame janela;

    private ImagemFundo posicionaComponentes() {

        ImagemFundo painel = new ImagemFundo();

        GridBagLayout layout = new GridBagLayout();
        painel.setLayout(layout);

        GridBagConstraints posLogin = new GridBagConstraints();
        posLogin.insets = new Insets(280, 5, 5, 5);
        posLogin.gridy = 0;
        posLogin.gridx = 0;
        painel.add(login, posLogin);

        GridBagConstraints posTfLogin = new GridBagConstraints();
        posTfLogin.insets = new Insets(280, 5, 5, 5);
        posTfLogin.ipady = 4;
        posTfLogin.gridx = 1;
        posTfLogin.gridy = 0;
        painel.add(tfLogin, posTfLogin);

        GridBagConstraints posSenha = new GridBagConstraints();
        posSenha.insets = new Insets(0, 5, 5, 5);
        posSenha.gridx = 0;
        posSenha.gridy = 1;
        painel.add(senha, posSenha);

        GridBagConstraints posTfSenha = new GridBagConstraints();
        posTfSenha.insets = new Insets(0, 5, 5, 5);
        posTfSenha.ipady = 4;
        posTfSenha.gridx = 1;
        posTfSenha.gridy = 1;
        painel.add(tfSenha, posTfSenha);

        GridBagConstraints posBotaoLogar = new GridBagConstraints();
        posBotaoLogar.insets = new Insets(5, 5, 5, 5);
        posBotaoLogar.gridx = 0;
        posBotaoLogar.gridy = 2;
        painel.add(logar, posBotaoLogar);

        GridBagConstraints posBotaoCadastrar = new GridBagConstraints();
        posBotaoCadastrar.insets = new Insets(5, 5, 5, 5);
        posBotaoCadastrar.gridx = 1;
        posBotaoCadastrar.gridy = 2;
        painel.add(cadastrar, posBotaoCadastrar);

        return painel;
    }

    public Login() {

        login = new JLabel("Login");
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Georgia", Font.BOLD, 30));

        senha = new JLabel("Senha");
        senha.setForeground(Color.WHITE);
        senha.setFont(new Font("Georgia", Font.BOLD, 30));

        tfLogin = new JTextField(15);
        tfSenha = new JPasswordField(15);

        logar = new JButton("Entrar");
        logar.addActionListener(new LogaJogador(this));
        cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(new CadastraJogador(this));

        ImagemFundo painel = posicionaComponentes();

        janela = new JFrame();
        janela.setSize(940, 520);
        janela.setResizable(false);

        //implementar -> ao fechar salvar alterações
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pesquisar 
        janela.setLocationRelativeTo(null);

        janela.add(painel);
        janela.setVisible(true);

    }

    private class ImagemFundo extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image imagemFundo = imagem.getImage();
            g.drawImage(imagemFundo, 0, 0, this);

        }
    }

    public JTextField getTfLogin() {
        return tfLogin;
    }

    public JPasswordField getTfSenha() {
        return tfSenha;
    }
} 
