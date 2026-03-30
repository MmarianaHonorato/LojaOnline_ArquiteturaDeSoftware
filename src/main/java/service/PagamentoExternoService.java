// src/main/java/service/PagamentoExternoService.java
package service;

import model.Pedido;
import model.Pagamento;
import repository.PagamentoRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public class PagamentoExternoService {

    // 1. Instância estática e privada da própria classe (O coração do Singleton)
    private static PagamentoExternoService instancia;

    // 2. Construtor privado para impedir que outras classes criem novas instâncias (usando 'new')
    private PagamentoExternoService() {
        System.out.println("[GatewayPagamento] Inicializando conexão única com a API do Banco...");
        // Simulação de delay de conexão com o serviço externo
    }

    // 3. Método público estático para fornecer acesso global à instância única
    public static PagamentoExternoService getInstancia() {
        if (instancia == null) {
            instancia = new PagamentoExternoService();
        }
        return instancia;
    }

    // Método para simular o processamento do pagamento externamente
    public Pagamento processarPagamento(Pedido pedido, String formaPagamento) {
        System.out.println("[GatewayPagamento] Processando transação externa para o Pedido #" 
                           + pedido.getIdPedido() + " no valor de R$ " + pedido.getValorTotal());

        // Simula uma transação externa gerando um ID único
        String transacaoId = UUID.randomUUID().toString();
        String status = "APROVADO"; // Poderia conter lógica de "RECUSADO" também

        // Cria o registro do pagamento e salva no repositório
        int novoId = PagamentoRepository.listar().size() + 1;
        Pagamento pagamento = new Pagamento(
                novoId,
                pedido.getIdPedido(),
                formaPagamento,
                status,
                transacaoId,
                LocalDateTime.now().toString()
        );

        PagamentoRepository.salvar(pagamento);
        System.out.println("[GatewayPagamento] Transação aprovada com sucesso! ID: " + transacaoId);
        
        return pagamento;
    }
}