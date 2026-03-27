
package model;

public class Produto {
    private int idProduto;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
    private String categoria;

    public Produto(int idProduto, String nome, String descricao, double preco, int estoque, String categoria) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}