package classes;

public class Consumivel {

    private String nome;
    private String efeito;
    private String descricao;
    private int carga;


    public Consumivel() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEfeito() {
        return efeito;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public static double efeitoPot(String nome) {
        double ocorrencia;
        if (nome.contains("Menor")) {
            ocorrencia = 0.10;
        } else if (nome.contains("Maior")) {
            ocorrencia = 0.30;
        } else {
            ocorrencia = 0.20;
        }
        return ocorrencia;
    }
}
