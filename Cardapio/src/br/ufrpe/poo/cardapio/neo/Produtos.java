package br.ufrpe.poo.cardapio.neo;

/**
 *
 * @author Endryo
 */
public class Produtos {

    private String nome;
    private double preco;
    private String obs;
    private int quantidade;

    //contrutores
    public Produtos(String nome, double preco, String obs, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.obs = obs;
        this.quantidade = quantidade;
    }

    public Produtos() {
    }

    public Produtos(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    //metodos get's
    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public String getObs() {
        return this.obs;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    //metodos set's
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
