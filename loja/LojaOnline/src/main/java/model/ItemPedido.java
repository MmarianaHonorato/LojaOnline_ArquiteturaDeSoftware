
package model;

public class ItemPedido {
    private int idItemPedido;
    private Produto produto;
    private int quantidade;
    private double valorUnitario;

    public ItemPedido(int idItemPedido, Produto produto, int quantidade, double valorUnitario) {
        this.idItemPedido = idItemPedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public double getSubtotal() {
        return quantidade * valorUnitario;
    }

    public Produto getProduto() {
        return produto;
    }
}