
package model;

public class Pagamento {
    private int idPagamento;
    private int idPedido;
    private String formaPagamento;
    private String statusPagamento;
    private String transacaoId;
    private String dataPagamento;

    public Pagamento(int idPagamento, int idPedido, String formaPagamento,
                     String statusPagamento, String transacaoId, String dataPagamento) {
        this.idPagamento = idPagamento;
        this.idPedido = idPedido;
        this.formaPagamento = formaPagamento;
        this.statusPagamento = statusPagamento;
        this.transacaoId = transacaoId;
        this.dataPagamento = dataPagamento;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }
}