// service/LojaService.java
package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import repository.ClienteRepository;
import repository.PedidoRepository;
import repository.ProdutoRepository;

public class LojaService {

    private static int contadorPedido = 1;
    private static int contadorItem = 1;

    //listar produtos
    public List<Produto> listarProdutos() {
        return ProdutoRepository.listar();
    }

//criar pedido: 
// Recebe o id do cliente e uma lista de
    // pares {idProduto, quantidade}
    public Pedido criarPedido(int idCliente, List<int[]> itensSolicitados) {

        // Valida cliente
        Cliente cliente = ClienteRepository.buscarPorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado: id " + idCliente);
            return null;
        }

        // Monta os itens do pedido
        List<ItemPedido> itens = new ArrayList<>();

        for (int[] par : itensSolicitados) {
            int idProduto  = par[0];
            int quantidade = par[1];

            Produto produto = ProdutoRepository.buscarPorId(idProduto);
            if (produto == null) {
                System.out.println("Produto não encontrado: id " + idProduto + " — ignorado.");
                continue;
            }

            ItemPedido item = new ItemPedido(
                    contadorItem++,
                    produto,
                    quantidade,
                    produto.getPreco()   // valorUnitário vem do catálogo
            );
            itens.add(item);
        }

        if (itens.isEmpty()) {
            System.out.println("Nenhum item válido — pedido não criado.");
            return null;
        }

        // Cria e persiste o pedido
        Pedido pedido = new Pedido(
                contadorPedido++,
                cliente,
                LocalDate.now().toString(),
                "AGUARDANDO_PAGAMENTO",
                itens
        );

        PedidoRepository.salvar(pedido);
        System.out.println("Pedido #" + pedido.getIdPedido() + " criado para " + cliente.getNome());
        return pedido;
    }
    //calcular total: 
    // Delega ao próprio Pedido (que já somou
    // os subtotais de cada ItemPedido)
    public double calcularTotal(Pedido pedido) {
        if (pedido == null) return 0;
        return pedido.getValorTotal();
    }
}