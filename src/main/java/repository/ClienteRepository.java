package repository;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private static List<Cliente> clientes = new ArrayList<>();

    static {
        clientes.add(new Cliente(1, "Lucas Pereira", "lucas@email.com", "99994", "123", "Rua D"));
        clientes.add(new Cliente(2, "Juliana Rocha", "juliana@email.com", "99995", "123", "Rua E"));
        clientes.add(new Cliente(3, "Bruno Martins", "bruno@email.com", "99996", "123", "Rua F"));
        clientes.add(new Cliente(4, "Camila Ferreira", "camila@email.com", "99997", "123", "Rua G"));
        clientes.add(new Cliente(5, "Rafael Gomes", "rafael@email.com", "99998", "123", "Rua H"));
        clientes.add(new Cliente(6, "Patricia Nunes", "patricia@email.com", "99999", "123", "Rua I"));
        clientes.add(new Cliente(7, "Diego Barros", "diego@email.com", "99990", "123", "Rua J"));
    }

    public static List<Cliente> listar() {
        return clientes;
    }

    public static Cliente buscarPorId(int id) {
        for (Cliente c : clientes) {
            if (c.getIdCliente() == id) {
                return c;
            }
        }
        return null;
    }
}
