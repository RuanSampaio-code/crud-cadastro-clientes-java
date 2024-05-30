// Interface CRUD para operações básicas de manipulação de clientes
public interface ClienteCRUD {
    // Método para criar um novo cliente
    void criarCliente(Cliente cliente);

    // Método para todos os clientes
    void buscarClientes();

    // Método para atualizar os dados de um cliente
    void atualizarCliente(String nome, Cliente novoCliente);

    // Método para deletar um cliente
    void deletarCliente(String nome);

}