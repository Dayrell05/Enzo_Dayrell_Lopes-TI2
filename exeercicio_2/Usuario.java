package exercicio_2;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private java.sql.Timestamp dataCadastro;

    public Usuario() {}

    public Usuario(int id, String nome, String email, String telefone, java.sql.Timestamp dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public java.sql.Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(java.sql.Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", email='" + email + '\'' +
               ", telefone='" + telefone + '\'' +
               ", dataCadastro=" + dataCadastro +
               '}';
    }
}

