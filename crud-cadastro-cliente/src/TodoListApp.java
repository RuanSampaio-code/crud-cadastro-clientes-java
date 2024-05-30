import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TodoListApp extends Application {

    private ListView<String> todoListView;
    private TextField todoInputField;

    @Override
    public void start(Stage primaryStage) {
        // Layout principal
        BorderPane root = new BorderPane();

        // Lista de tarefas
        todoListView = new ListView<>();

        // Campo de entrada para adicionar tarefas
        todoInputField = new TextField();
        todoInputField.setPromptText("Adicionar nova tarefa");

        // Botão para adicionar tarefa
        Button addButton = new Button("Adicionar");
        addButton.setOnAction(e -> adicionarTarefa());

        // Botão para remover tarefa
        Button removeButton = new Button("Remover");
        removeButton.setOnAction(e -> removerTarefa());

        // Layout para botões
        HBox buttonBox = new HBox(5, addButton, removeButton);
        buttonBox.setPadding(new Insets(5));

        // Adicionando componentes ao layout principal
        root.setCenter(todoListView);
        root.setBottom(new HBox(10, todoInputField, buttonBox));

        // Configurando a cena
        Scene scene = new Scene(root, 400, 300);

        // Configurando o palco
        primaryStage.setTitle("Lista de Tarefas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para adicionar uma nova tarefa à lista
    private void adicionarTarefa() {
        String novaTarefa = todoInputField.getText();
        if (!novaTarefa.isEmpty()) {
            todoListView.getItems().add(novaTarefa);
            todoInputField.clear();
        }
    }

    // Método para remover uma tarefa da lista
    private void removerTarefa() {
        int selectedIndex = todoListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            todoListView.getItems().remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}