
package model;

public class Cliente {
    private int idCliente;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String endereco;

    public Cliente(int idCliente, String nome, String email, String telefone, String senha, String endereco) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.endereco = endereco;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }
}