
package view;
import repository.ClienteRepository;
import repository.ProdutoRepository;
import model.Cliente;
import model.Produto;

public class teste {
    public static void main(String[] args) {

        System.out.println("=== CLIENTES ===");
        for (Cliente c : ClienteRepository.listar()) {
            System.out.println(c.getIdCliente() + " - " + c.getNome());
        }

        System.out.println("\n=== PRODUTOS ===");
        for (Produto p : ProdutoRepository.listar()) {
            System.out.println(p.getIdProduto() + " - " + p.getNome() + " - R$" + p.getPreco());
        }
    }
}