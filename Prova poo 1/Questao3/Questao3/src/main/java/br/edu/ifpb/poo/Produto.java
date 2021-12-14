package br.edu.ifpb.poo;

public class Produto {
    private int cod;
    private String descricao;
    private String cidadeOrigem;
    private double preco;
    private int quantidade;

    public Produto() {
        this(0, "--sem descricao--", "--sem cidade--", 0.0, 0);
    }
    public Produto(int cod, String descricao, String cidadeOrigem, double preco, int quantidade) {
        setCod(cod);
        setDescricao(descricao);
        setCidadeOrigem(cidadeOrigem);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }
    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
