package repository;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    private static List<Produto> produtos = new ArrayList<>();

    static {
        produtos.add(new Produto(1, "Notebook Dell", "i5 8GB RAM", 3500.0, 10, "Eletrônico"));
        produtos.add(new Produto(2, "Mouse Gamer", "RGB", 120.0, 30, "Acessório"));
        produtos.add(new Produto(3, "Teclado Mecânico", "Switch Azul", 250.0, 20, "Acessório"));
        produtos.add(new Produto(4, "Monitor 24\"", "Full HD", 900.0, 15, "Eletrônico"));
        produtos.add(new Produto(5, "Headset", "Com microfone", 180.0, 25, "Áudio"));
        produtos.add(new Produto(6, "Cadeira Gamer", "Ergonômica", 1200.0, 5, "Móveis"));
        produtos.add(new Produto(7, "Webcam", "HD 1080p", 200.0, 18, "Acessório"));
        produtos.add(new Produto(8, "HD Externo", "1TB", 350.0, 12, "Armazenamento"));
        produtos.add(new Produto(9, "SSD", "480GB", 300.0, 22, "Armazenamento"));
        produtos.add(new Produto(10, "Pen Drive", "64GB", 50.0, 40, "Armazenamento"));
        produtos.add(new Produto(11, "Impressora", "Multifuncional", 700.0, 8, "Periférico"));
        produtos.add(new Produto(12, "Roteador", "Wi-Fi 6", 400.0, 10, "Rede"));
        produtos.add(new Produto(13, "Tablet", "10 polegadas", 1500.0, 7, "Eletrônico"));
        produtos.add(new Produto(14, "Smartphone", "128GB", 2200.0, 14, "Eletrônico"));
        produtos.add(new Produto(15, "Carregador", "Turbo", 90.0, 35, "Acessório"));
    }

    public static List<Produto> listar() {
        return produtos;
    }

    public static Produto buscarPorId(int id) {
        for (Produto p : produtos) {
            if (p.getIdProduto() == id) {
                return p;
            }
        }
        return null;
    }
}