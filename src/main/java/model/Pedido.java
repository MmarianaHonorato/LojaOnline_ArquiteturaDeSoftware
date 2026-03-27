
package model;

import java.util.List;

public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private String dataPedido;
    private double valorTotal;
    private String statusPedido;
    private List<ItemPedido> itens;

    public Pedido(int idPedido, Cliente cliente, String dataPedido, String statusPedido, List<ItemPedido> itens) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.itens = itens;
        this.valorTotal = calcularTotal();
    }

    private double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public int getIdPedido() {
        return idPedido;
    }
}