package view;

import repository.ClienteRepository;
import repository.ProdutoRepository;
import model.Cliente;
import model.Produto;
import model.Pedido;
import model.Pagamento;
import service.LojaService;
import service.PagamentoExternoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Importação necessária para ler o teclado

public class teste {
    public static void main(String[] args) {
        // Criando o Scanner para ler o que o usuário digita
        Scanner scanner = new Scanner(System.in);
        LojaService lojaService = new LojaService();

        System.out.println("=== CLIENTES ===");
        for (Cliente c : ClienteRepository.listar()) {
            System.out.println(c.getIdCliente() + " - " + c.getNome());
        }

        System.out.println("\n=== PRODUTOS ===");
        for (Produto p : ProdutoRepository.listar()) {
            System.out.println(p.getIdProduto() + " - " + p.getNome() + " - R$" + p.getPreco());
        }

        System.out.println("\n=================================");
        System.out.println("   BEM-VINDO À LOJA ONLINE!   ");
        System.out.println("=================================");

        // 1. Identificação do Cliente pelo console
        System.out.print("\nSelecione seu usuario (digite o ID): ");
        int idCliente = scanner.nextInt();
        Cliente cliente = ClienteRepository.buscarPorId(idCliente);

        // Se o usuário digitar um ID que não existe
        if (cliente == null) {
            System.out.println("Cliente não encontrado! Encerrando o sistema.");
            scanner.close();
            return;
        }
        System.out.println("\nBem vindo, " + cliente.getNome() + "!");

        // 2. Adicionando produtos na sacola de forma interativa
        List<int[]> carrinho = new ArrayList<>();
        System.out.println("\n=== ADICIONAR NA SACOLA ===");
        
        while (true) {
            System.out.print("Digite o ID do produto (ou 0 para finalizar e pagar): ");
            int idProduto = scanner.nextInt();

            if (idProduto == 0) {
                break; // Sai do loop (repetição) e vai para o pagamento
            }

            Produto produto = ProdutoRepository.buscarPorId(idProduto);
            if (produto == null) {
                System.out.println("Produto inválido. Tente novamente.");
                continue; // Volta pro início do while
            }

            System.out.print("Quantidade desejada de " + produto.getNome() + ": ");
            int quantidade = scanner.nextInt();

            if (quantidade > 0) {
                carrinho.add(new int[]{idProduto, quantidade});
                System.out.println("-> " + quantidade + "x " + produto.getNome() + " adicionado(s) na sacola!\n");
            } else {
                System.out.println("Quantidade inválida.\n");
            }
        }

        // Verifica se o cliente colocou algo na sacola antes de sair
        if (carrinho.isEmpty()) {
            System.out.println("\nSua sacola está vazia. Compra cancelada.");
            scanner.close();
            return;
        }

        // 3. Criação do Pedido
        System.out.println("\n=== FECHANDO PEDIDO ===");
        Pedido pedido = lojaService.criarPedido(cliente.getIdCliente(), carrinho);
        
        if (pedido != null) {
            System.out.println("Valor total a pagar: R$ " + lojaService.calcularTotal(pedido));

            // 4. Pagamento (Parte Final)
            System.out.println("\n=== PROCESSANDO PAGAMENTO ===");
            System.out.print("Qual a forma de pagamento (ex: PIX, CARTAO)? ");
            String formaPagamento = scanner.next();

            // Chamando a classe Singleton criada anteriormente
            PagamentoExternoService gateway = PagamentoExternoService.getInstancia();
            Pagamento pagamento = gateway.processarPagamento(pedido, formaPagamento);
        }
        
        System.out.println("\nObrigado por comprar conosco!");
        scanner.close();
    }
}