import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;




public class ImplementaCRUD implements ClienteCRUD {

    private List<Cliente> contas = new ArrayList<>();
    private TableView<Cliente> tabelaClientes;
    private Stage primaryStage; // Variável para armazenar o palco principal

    // Construtor que recebe o palco principal como parâmetro
    public ImplementaCRUD(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void criarCliente(Cliente cliente) {
        contas.add(cliente);
        exibirAlerta("feito", "cadastro feito com suceso");
        
    }

   

    @Override
    public void atualizarCliente(String cpfcnpj, Cliente novoCliente) {
        // Percorre a lista de clientes
        for (Cliente cliente : contas) {
            // Se encontrar um cliente com o CPF fornecido, atualiza os dados do cliente
            if (cliente.getCpfcnpj().equals(cpfcnpj)) {
                // Configura o novo cliente com os dados fornecidos
                cliente.setNome(novoCliente.getNome());
                cliente.setCidade(novoCliente.getCidade());
                cliente.setEmail(novoCliente.getEmail());
                cliente.setTelefone(novoCliente.getTelefone());
    
                // Exibe um formulário de atualização do cliente com os novos dados
                exibirFormularioAtualizacao(cliente);
    
                // Exibe uma mensagem indicando que o cliente foi alterado com sucesso
                System.out.println("Cliente com CPF " + cpfcnpj + " alterado com sucesso.");
                return; // Interrompe o loop após alterar o cliente
            }
        }
        // Se não encontrar nenhum cliente com o CPF fornecido, exibe uma mensagem de erro
        exibirAlerta("Alteração de Cliente", "Cliente com CPF " + cpfcnpj + " não encontrado na lista.");
    }
    

    @Override
    public void deletarCliente(String cpfcnpj) {
      

        // Percorre a lista de clientes
        for (int i = 0; i < contas.size(); i++) {
            Cliente cliente = contas.get(i);
            
            // Se encontrar um cliente com o CPF fornecido, remove da lista
            if (cliente.getCpfcnpj().equals(cpfcnpj)) {
                contas.remove(i);
                /* System.out.println("Cliente com CPF " + cpfcnpj + " removido com sucesso."); */
                exibirAlerta("Sucesso", "cpf:" + cpfcnpj + "deletado com sucesso");
                return; // Interrompe o loop após remover o cliente
            }
        }
        // Se não encontrar nenhum cliente com o CPF fornecido, exibe uma mensagem de erro
        System.out.println();
        exibirAlerta("Erro", "Cliente com CPF " + cpfcnpj + " não encontrado na lista.");

        }

    @Override
    public void buscarClientes() {

       
        // Criar um novo palco para exibir a tabela de clientes
        Stage stageTabelaClientes = new Stage();
        stageTabelaClientes.setTitle("Lista de Clientes");

        // Cria uma TableView para exibir os clientes
        tabelaClientes = new TableView<>();

        // Cria as colunas da tabela
        TableColumn<Cliente, String> colunaCPFCNPJ = new TableColumn<>("CPF / CNPJ");
        TableColumn<Cliente, String> colunaNome = new TableColumn<>("Nome");
        TableColumn<Cliente, String> colunaCidade = new TableColumn<>("Cidade");
        TableColumn<Cliente, String> colunaEmail = new TableColumn<>("Email");
        TableColumn<Cliente, String> colunaTelefone = new TableColumn<>("Telefone");

        // Configura as células das colunas para obter os valores corretos do objeto Cliente
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colunaCPFCNPJ.setCellValueFactory(new PropertyValueFactory<>("cpfcnpj"));

        // Adiciona as colunas à tabela
        tabelaClientes.getColumns().addAll(colunaCPFCNPJ, colunaNome, colunaCidade, colunaEmail, colunaTelefone);

        // Adiciona os clientes à tabela
        tabelaClientes.getItems().addAll(contas);

        // Criar o layout da cena
        StackPane root = new StackPane();
        root.getChildren().add(tabelaClientes);

        // Criar a cena
        Scene scene = new Scene(root, 600, 200);

        // Configurar a cena no novo palco e exibi-lo
        stageTabelaClientes.setScene(scene);
        stageTabelaClientes.show();
    }


     // Método para exibir um alerta simples
     private void exibirAlerta(String titulo, String mensagem) {
        Stage alertStage = new Stage();
        alertStage.initModality(Modality.APPLICATION_MODAL);
        alertStage.setTitle(titulo);

        Label lblMensagem = new Label(mensagem);
        Button btnOK = new Button("OK");
        btnOK.setOnAction(e -> alertStage.close());

        VBox alertLayout = new VBox(10);
        alertLayout.getChildren().addAll(lblMensagem, btnOK);
        alertLayout.setAlignment(Pos.CENTER);
        alertLayout.setPadding(new Insets(20));

        Scene alertScene = new Scene(alertLayout, 300, 100);
        alertStage.setScene(alertScene);
        alertStage.show();
    }


        // Método para exibir um formulário de atualização do cliente
    private void exibirFormularioAtualizacao(Cliente cliente) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Atualizar Cliente");

        // Elementos de layout para o formulário de atualização
        Label lblNome = new Label("Nome:");
        TextField txtNome = new TextField(cliente.getNome());

        Label lblCidade = new Label("Cidade:");
        TextField txtCidade = new TextField(cliente.getCidade());

        Label lblEmail = new Label("Email:");
        TextField txtEmail = new TextField(cliente.getEmail());

        Label lblTelefone = new Label("Telefone:");
        TextField txtTelefone = new TextField(cliente.getTelefone());

        Button btnAtualizar = new Button("Atualizar");
        btnAtualizar.setOnAction(e -> {
            // Atualiza os dados do cliente com os dados inseridos no formulário
            cliente.setNome(txtNome.getText());
            cliente.setCidade(txtCidade.getText());
            cliente.setEmail(txtEmail.getText());
            cliente.setTelefone(txtTelefone.getText());

            // Fecha a janela após a atualização
            stage.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(lblNome, txtNome, lblCidade, txtCidade, lblEmail, txtEmail, lblTelefone, txtTelefone, btnAtualizar);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

    
}
