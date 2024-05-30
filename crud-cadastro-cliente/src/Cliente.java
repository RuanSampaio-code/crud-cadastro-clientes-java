public class Cliente {
    private String nome;
    private String cidade;
    private String email;
    private String telefone;
    private String cpfcnpj;


    // Construtor
    public Cliente(String nome, String cidade, String email, String telefone, String cpfcnpj) {
        this.nome = nome;
        this.cidade = cidade;
        this.email = email;
        this.telefone = telefone;
        this.cpfcnpj = cpfcnpj;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }
}
