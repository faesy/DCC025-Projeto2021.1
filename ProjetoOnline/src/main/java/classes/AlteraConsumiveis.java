/*
Hiero Henrique Barcelos Costa -202065136A 

Matheus Cardoso Faesy - 202065065A 

Thaís de Jesus Soares - 202065511B 
*/
package classes;

/**
 *
 * @author mathe
 */
public class AlteraConsumiveis {

    private Jogador jogador;
    private String nome, tipo;
    private int chave;
    private Consumivel[] elixires = new Consumivel[9];
    private Consumivel[] elixiresDoJogador;
    private String[] nomeElixires = new String[9];

    public AlteraConsumiveis(Jogador jogador) {
        this.jogador = jogador;

        this.tipo = jogador.getDeus().getTipo();
        this.chave = jogador.getChaveProgresso();

        PegaConsumivelBancoDados g = new PegaConsumivelBancoDados();

        nomeElixires[0] = "Elixir Vida Menor";
        nomeElixires[1] = "Elixir Vida";
        nomeElixires[2] = "Elixir Vida Maior";
        nomeElixires[3] = "Elixir Veneno Menor";
        nomeElixires[4] = "Elixir Veneno";
        nomeElixires[5] = "Elixir Veneno Maior";
        nomeElixires[6] = "Elixir Poder Menor";
        nomeElixires[7] = "Elixir Poder";
        nomeElixires[8] = "Elixir Poder Maior";
        organizaArranjoConsumivel(nomeElixires);

        if (chave == 1) {
            elixiresDoJogador = new Consumivel[1];
            tipoJogador(0);

        } else if (chave == 3) {
            criaArranjoConsumivel(2);
            tipoJogador(2);
            jogador.setConsumiveis(elixiresDoJogador);
        } else if (chave == 6) {
            criaArranjoConsumivel(3);
            tipoJogador(3);
            jogador.setConsumiveis(elixiresDoJogador);
        } else if (chave == 9) {
            criaArranjoConsumivel(4);
            tipoJogador(4);
            jogador.setConsumiveis(elixiresDoJogador);
        } else if (chave == 12) {
            criaArranjoConsumivel(5);
            tipoJogador(5);
            jogador.setConsumiveis(elixiresDoJogador);
        } else if (chave == 15) {
            criaArranjoConsumivel(6);
            tipoJogador(6);
            jogador.setConsumiveis(elixiresDoJogador);
        } else if (chave == 18) {
            criaArranjoConsumivel(7);
            tipoJogador(7);
            jogador.setConsumiveis(elixiresDoJogador);
        } else if (chave == 21) {
            criaArranjoConsumivel(8);
            tipoJogador(8);
            jogador.setConsumiveis(elixiresDoJogador);
        } else if (chave == 24) {
            criaArranjoConsumivel(9);
            tipoJogador(9);
            jogador.setConsumiveis(elixiresDoJogador);
        }

    }

    public void criaArranjoConsumivel(int tamanho) {
        this.elixiresDoJogador = new Consumivel[tamanho+1];
        for (int i = 0; i < tamanho; i++) {
            this.elixiresDoJogador[i] = this.elixires[i];
        }
    }

    public void organizaArranjoConsumivel(String[] arranjoOrganizado) {
        int i = 0;
        this.elixires = new Consumivel[9];
        for (String string : arranjoOrganizado) {
            PegaConsumivelBancoDados g = new PegaConsumivelBancoDados();
            this.elixires[i] = g.pegaOConsumivelBancoDados(string);
            i++;
        }
    }

    public void tipoJogador(int i) {
        if (this.tipo.equals("Nordico")) {
            for (Consumivel elixir : elixires) {
                if (elixir.getNome().contains("Poder Menor")) {
                    jogador.setConsumivel(elixir);

                    elixiresDoJogador[i] = elixir;
                    jogador.setConsumiveis(elixiresDoJogador);
                }
            }
        } else if (this.tipo.equals("Egipcio")) {
            for (Consumivel elixir : elixires) {
                if (elixir.getNome().contains("Veneno Menor")) {
                    jogador.setConsumivel(elixir);

                    elixiresDoJogador[i] = elixir;
                    jogador.setConsumiveis(elixiresDoJogador);
                }
            }
        } else if (this.tipo.equals("Grego")) {
            for (Consumivel elixir : elixires) {
                if (elixir.getNome().contains("Vida Menor")) {
                    jogador.setConsumivel(elixir);

                    elixiresDoJogador[i] = elixir;
                    jogador.setConsumiveis(elixiresDoJogador);
                }
            }
        }

    }
//olha qual o deus do jogador (decide o tipo do elixir)(Cura=grego,veneno=egipcio,poder=nordico) 
    //olha qual a chave de progresso do jogador (decide a intensidade do elixir) 
    //decide qual elixir deveria ser dado ao jogador
    //cria o elixir a partir do banco de dados
    //da o elixir ao jogador

}
