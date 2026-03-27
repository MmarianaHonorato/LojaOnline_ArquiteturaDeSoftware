package repository;

import model.Pagamento;
import java.util.ArrayList;
import java.util.List;

public class PagamentoRepository {

    private static List<Pagamento> pagamentos = new ArrayList<>();

    public static void salvar(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public static List<Pagamento> listar() {
        return pagamentos;
    }
}